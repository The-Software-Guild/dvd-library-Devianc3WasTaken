package dao;

public class DVDDaoException extends Exception {
      public DVDDaoException(String msg) {
        super(msg);
    }

    public DVDDaoException(String msg, Throwable cause) {
        super (msg, cause);
    }
}
