package UI;

public interface UserIO {
    
    void print(String message);
    
    int readInt(String prompt, int min, int max);
    
    String readString(String prompt);
}
