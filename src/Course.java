public class Course {
    String title = "";
    String subj = "";
    String subgraph = "";
    String status = "";
    String preReqs = "";
    String coReqs = "";
    boolean available = false;

    public Course(String title, String subgraph, String subj, String preReqs, String coReqs) {
        this.title = title;
        this.subgraph = subgraph;
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

    public String getSubgraph() {
        return subgraph;
    }
    
    public String getSubj() {
        return subj;
    }
   
    
     public String getStatus() {
        return status;
    }

    public String getCoReqs() {
        return coReqs;
    }

    public String getPreReqs() {
        return preReqs;
    }

    public boolean isAvailable() {
        return available;
    }
     
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubgraph(String subgraph) {
        this.subgraph = subgraph;
    }
    
    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPreReqs(String preReqs) {
        this.preReqs = preReqs;
    }

    public void setCoReqs(String coReqs) {
        this.coReqs = coReqs;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
}
