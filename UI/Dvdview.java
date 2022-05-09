package UI;

import dto.DVDCollection;
import java.util.*;

public class Dvdview {
    
    private UserIO sys;
    
    public Dvdview(UserIO sys){
        this.sys=sys;
    }
    
    public int printmenu(){
        System.out.println("Main menu Which one you would like to enter");
        System.out.println("1. List");
        System.out.println("2. Create");
        System.out.println("3. View");
        System.out.println("4. Remove");
        System.out.println("5. Edit");
        System.out.println("6. Exit");
        
        return sys.readInt("Please select from above", 1, 6);
}
        public void displayDisplayAll() {
        sys.print("Display All DVDs");
    }

    public void displayDVDList(List<DVDCollection> dvdList) {
        for (DVDCollection currentDVD : dvdList) {
            sys.print(currentDVD.getTitle() + " "
                    + currentDVD.getDate() + " "
                    + currentDVD.getStudioName() + " "
                    + currentDVD.getDirectorName() + " "
                    + currentDVD.getUserNote() + " "
                    + currentDVD.getRating());
        }
        sys.readString("Please hit enter to continue.");
    }

    public void displayCreateDVD() { 
        sys.print("Create DVD");
    }

    public void displayCreateSuccess() { 
        sys.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public DVDCollection getDVDInfo() {
        String title = sys.readString("Enter the DVD title");
        String year = sys.readString("Enter the date");
        String studsys = sys.readString("Enter the studio");
        String directorsName = sys.readString("Enter the directors name");
        String userRating = sys.readString("Enter a rating 1 - 5 stars");
        String mpaaRating = sys.readString("Enter the MPAA rating");
        DVDCollection currentDVD = new DVDCollection(title);
        currentDVD.setDate(year);
        currentDVD.setStudioName(studsys);
        currentDVD.setDirectorName(directorsName);
        currentDVD.setUserNote(userRating);
        currentDVD.setRating(mpaaRating);
        return currentDVD;
    }

    public DVDCollection editDVD(DVDCollection dvd) {

        String title = sys.readString("Enter the title");
        String year = sys.readString("Enter the year");
        String studioName = sys.readString("Enter the studio name");
        String directorsName = sys.readString("Enter the directors name");
        String userRating = sys.readString("Enter a rating 1 - 5 stars");
        String mpaaRating = sys.readString("Enter the MPAA rating");

        dvd.setDate(year);
        dvd.setStudioName(studioName);
        dvd.setDirectorName(directorsName);
        dvd.setUserNote(userRating);
        dvd.setRating(mpaaRating);

        return dvd;

    }

    public String getDVDTitleChoice() { 
        return sys.readString("Please enter the DVD Title.");
    }

    public void displayDisplayDVD() { 
        sys.print("Display DVD");
    }

    public void displayDVD(DVDCollection dvd) {
        if (dvd != null) {
            sys.print(dvd.getTitle());
            sys.print(dvd.getDate() + " " + dvd.getStudioName());
            sys.print(dvd.getDirectorName() + " " + dvd.getUserNote());
            sys.print(dvd.getRating());
            sys.print("");
        } else {
            sys.print("No such DVD.");
        }
        sys.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVD() { 
        sys.print("Remove DVD");
    }

    public void displayRemove() { 
        sys.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExit() {
        sys.print("Goodbye!");
    }

    public void displayEditDVD() {
        sys.print("Edit DVD");
    }

    public void displayEdit() { 
        sys.readString("DVD successfully Edited. Please hit enter to continue.");
    }

    public void displayUnknownCommand() {
        sys.print("Unknown Command!");
    }

    public void displayErrorMessage(String errorMsg) {
        sys.print("ERROR");
        sys.print(errorMsg);
    }
}