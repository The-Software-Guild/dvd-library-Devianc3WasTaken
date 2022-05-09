package dto;

public class DVDCollection {
    private String title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studioName;
    private String userNote;
    
    public DVDCollection(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
     public void setDate(String date){
        this.releaseDate = date;
        
    }
    public String getDate(){
        return releaseDate;
    }
     public void setRating(String rating){
        this.rating = rating;
        
    }
    public String getRating(){
        return rating;
    }
     public void setDirectorName(String directorName){
        this.directorName = directorName;
        
    }
    public String getDirectorName(){
        return directorName;
    }
     public void setStudioName(String studioName){
        this.studioName = studioName;
        
    }
    public String getStudioName(){
        return studioName;
    }
     public void setUserNote(String userNote){
        this.userNote = userNote;
        
    }
    public String getUserNote(){
        return userNote;
    }
    
 
}
