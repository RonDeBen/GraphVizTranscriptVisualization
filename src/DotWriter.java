
import java.util.ArrayList;


public class DotWriter {
    public Courses courses = new Courses();
    ArrayList<Course> c = new ArrayList<Course>();
    public DotWriter(Courses courses){
         this.courses = courses;
         c = this.courses.getC();
     }
     
    public String write(){
         String s = "digraph g{\n";
         
         for(int k = 0; k < c.size(); k++){
             s += "\t\"" + c.get(k).getTitle() + 
                  "\" [" + statusColorNode(c.get(k).getStatus()) + 
                  ",style=filled," + subjShape(c.get(k)) + 
                  "," + availableColor(c.get(k).isAvailable()) + 
                  "]\n";
         }
         
         for(int k = 0; k < c.size(); k++){
             s += drawArrow(c.get(k));
         }
         s += "}";
         return s;
     }
     private String subjShape(Course course){
         String s = "";
         String subj = course.getSubj();
         switch(subj){
            case "CSC":
                s = "shape=ellipse";
                break;
            case "ENGL":
                s = "shape=triangle";
                break;
            case "ECO":
                s = "shape=box";
                break;
            case "MATH":
                s = "shape=septagon";
                break;
            case "BIO":
                s = "shape=trapezium";
                break;
            case "HUMAN":
                s = "shape=invtriangle";
                break;               
            case "FS":
                s = "shape=parallelogram";
                break;
            case "GRID":
                s = "shape=tripleoctagon";
                break;
        }
         return s;
     }
     private String statusColorNode(String status){
         String s = "";
         switch(status){
            case "0":
                s = "fillcolor=white";
                break;
            case "1":
                s = "fillcolor=yellow";
                break;
            case "2":
                s = "fillcolor=green";
                break;
        }
      return s;   
     }
     
     private String availableColor(boolean available){
      String s = "";
      if(available)
          s = "color=blue";
      else
          s = "color=red";
      return s;     
     }
     
     private String statusColorArrow(String status){
         String s = "";
         switch(status){
            case "0":
                s = "color=red";
                break;
            case "1":
                s = "color=yellow";
                break;
            case "2":
                s = "color=green";
                break;
        }
      return s;   
     }
     
     private String drawArrow(Course c){
      String s = "";
      if(c.preReqs.equalsIgnoreCase("NONE")){
          s = "\tSTART -> " + c.getTitle() + " [color=green]\n";
      }else {
          String[] temp = c.getPreReqs().split(",");
          for(int k = 0; k < temp.length; k++){
              s += "\t" + temp[k] + " -> " + c.getTitle() + " [" + statusColorArrow(courses.getCourseByName(temp[k]).getStatus()) + "]\n";
          }
      }
      return s;
     }
}
