/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DVDCollection;
import dao.DVDDao;
import dao.DVDDaoException;
import UI.Dvdview;
import java.util.*;
/**
 *
 * @author aakar
 */
public class DVDController {
    
    Dvdview view;
    DVDDao dao;

    public DVDController(DVDDao dao, Dvdview view) {
        this.dao = dao;
        this.view = view;
    }

    private int getMenuSelection() {
        return view.printmenu();
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelect = 0;
        try {
            while (keepGoing) {

                try {
                    menuSelect = getMenuSelection();
                } catch (NumberFormatException e) {
                    view.displayErrorMessage(e.getMessage());
                    continue;
                }
                switch (menuSelect) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private void listDVDs() throws DVDDaoException {
        view.displayDisplayAll();
        List<DVDCollection> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDDaoException {
        view.displayCreateDVD();
        DVDCollection newDVD = view.getDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccess();
    }

    private void viewDVD() throws DVDDaoException {
        view.displayDisplayDVD();
        String title = view.getDVDTitleChoice();
        DVDCollection dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDDaoException {
        view.displayRemoveDVD();
        String title = view.getDVDTitleChoice();
        dao.removeDVD(title);
        view.displayRemove();
    }

    private void editDVD() throws DVDDaoException {
        view.displayEditDVD();
        String title = view.getDVDTitleChoice();
        DVDCollection previousDVD = dao.getDVD(title);
        DVDCollection editedDVD = view.editDVD(previousDVD);
        dao.editDVD(editedDVD.getTitle(), editedDVD);
        view.displayEdit();
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    private void exitMessage() {
        view.displayExit();
    }
}