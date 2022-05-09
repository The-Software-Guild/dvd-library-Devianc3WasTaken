package dao;

import dto.DVDCollection;
import java.util.*;

public interface DVDDao {
    
    DVDCollection addDVD(String title, DVDCollection dvd) throws DVDDaoException;
    
    List<DVDCollection> getAllDVDs() throws DVDDaoException;
    
    DVDCollection getDVD(String title) throws DVDDaoException;
    
    DVDCollection removeDVD(String title) throws DVDDaoException;
    
    DVDCollection editDVD(String title, DVDCollection dvd) throws DVDDaoException;
}
