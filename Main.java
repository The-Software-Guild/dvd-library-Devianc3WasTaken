import dao.DVDDao;
import dao.DVDDaoImpl;
import controller.DVDController;
import UI.UserIO;
import UI.UserIOImpl;
import UI.Dvdview;

public class Main {
    public static void main(String[] args) {
        UserIO myIo = new UserIOImpl();
        Dvdview myView = new Dvdview(myIo);
        DVDDao myDao = new DVDDaoImpl();
        DVDController controller = new DVDController(myDao, myView);
        controller.run();
    }
    
}
