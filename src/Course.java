
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

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", subj=" + subj + ", status=" + status + ", preReqs=" + preReqs + ", coReqs=" + coReqs + ", available=" + available + '}';
    }
    
    
    
    
    public String getTitle() {
        return title;
    }

    public String getSubj() {
        return subj;
    }
   
    
     public String getStatus() {
        return status;
    }
     
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
