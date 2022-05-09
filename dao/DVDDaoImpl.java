package dao;
import dto.DVDCollection;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DVDDaoImpl implements DVDDao {
     private Map<String, DVDCollection> dvds = new HashMap<>();

        public final String textFile;
        public final String str = ":";

        String currentLine;

        String[] currentTokens;

        public DVDDaoImpl(){
        textFile = "library.txt";
    }

        public DVDDaoImpl(String libraryTextFile){
        textFile = libraryTextFile;
    }

        
        public DVDCollection addDVD(String title, DVDCollection dvd) throws DVDDaoException {
            DVDCollection newDVD = dvds.put(title, dvd);
            try {
                writeDVD();
            } catch (DVDDaoException | IOException ex) {
                ex.printStackTrace();

            }
        return newDVD;
        }

        public List<DVDCollection> getAllDVDs() throws DVDDaoException {
            loadDVD();
            return new ArrayList<DVDCollection>(dvds.values());
        }

        public DVDCollection removeDVD(String title) throws DVDDaoException {
            DVDCollection removedDVD = dvds.remove(title);
            try {
                writeDVD();
            } catch (DVDDaoException | IOException ex) {
                ex.printStackTrace();

            }
            return removedDVD;
        }

        public DVDCollection getDVD(String title) {
            return dvds.get(title);
        }

        public DVDCollection editDVD(String title, DVDCollection dvd) {
            dvds.put(title, dvd);
            return dvd;
        }

        private void loadDVD() throws DVDDaoException {
            Scanner scanner;

            try {
                scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(textFile)));
            }
            catch (FileNotFoundException e) {
                throw new DVDDaoException("Could not load library data.", e);
            }

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentTokens = currentLine.split(str);

                DVDCollection currentDVD = new DVDCollection(currentTokens[0]);

                currentDVD.setDate(currentTokens[1]);
                currentDVD.setStudioName(currentTokens[2]);
                currentDVD.setDirectorName(currentTokens[3]);
                currentDVD.setUserNote(currentTokens[4]);
                currentDVD.setRating(currentTokens[5]);

                dvds.put(currentDVD.getTitle(), currentDVD);
            }
        }

        private void writeDVD() throws DVDDaoException, IOException {
            PrintWriter writer;

            try {
                writer = new PrintWriter(new FileWriter(textFile));
            }
            catch (IOException e) {
                throw new DVDDaoException("Could not save dvd data.", e);
            }

            List<DVDCollection> DVDList = this.getAllDVDs();
            for (DVDCollection currentDVD : DVDList) {

                writer.println(currentDVD.getTitle() + str
                        + currentDVD.getDate() + str
                        + currentDVD.getStudioName() + str
                        + currentDVD.getDirectorName() + str
                        + currentDVD.getUserNote() + str
                        + currentDVD.getRating());

                writer.flush();
            }

            writer.close();
        }
}