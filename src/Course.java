
import java.lang.String;
import java.util.ArrayList;


public class Course {
    String title = "";
    String subj = "";
    String status = "";
    String preReqs = "";
    String coReqs = "";
    boolean available = false;

    public Course(String title, String subj, String preReqs, String coReqs) {
        this.title = title;
        this.subj = subj;
        this.preReqs = preReqs;
        this.coReqs = coReqs;
        available = false;
    }

        
    public String getTitle() {
        return title;
    }

    public String getSubj() {
        return subj;
    }
   
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }
}
