
import java.util.ArrayList;


public class DotWriter {
    public Courses courses = new Courses();
    ArrayList<Course> c = new ArrayList<Course>();
    public DotWriter(Courses courses){
         this.courses = courses;
         c = this.courses.getC();
     }
     
    public String write(){
         String s = "digraph g{\n\trankdir = LR\n";
         s += drawSubgraphs();
         /*for(int k = 0; k < c.size(); k++){
            s += drawNode(c.get(k));
         }*/
         
         for(int k = 0; k < c.size(); k++){
             s += drawArrow(c.get(k));
         }
         s += "}";
         return s;
     }
    
    private String drawNode(Course c){
        String s = "";
        if(c.getTitle().equalsIgnoreCase("GEN_ED")){
            int subs = Integer.parseInt(c.getStatus());
            String gened = "GeneralEducation";
            s = "\"GEN_ED\"[shape=\"none\", fontsize=20, label=<\n" +
                 "<table cellpadding=\"0\" cellborder=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                 "<tr>\n" +
                 "<td bgcolor=\"green\">" + gened.substring(0,subs) + "</td>\n" +
                 "<td bgcolor=\"red\">" + gened.substring(subs, gened.length()) +"</td>\n" + 
                 "</tr>\n" +
                 "</table>\n" +
                 ">]";
        }else {
            s = "\"" + c.getTitle() + 
                    "\" [" + statusColorNode(c.getStatus()) + 
                    ",style=filled," + subjShape(c) + 
                    "," + availableColor(c.isAvailable()) + 
                    "]";
    }
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
                s = "fillcolor=orange";
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
                s = "color=orange";
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
          //s = "\t\"START\" -> \"" + c.getTitle() + "\" [color=green]\n";
      }else {
          String[] temp = c.getPreReqs().split(",");
          for(int k = 0; k < temp.length; k++){
              s += "\t\"" + temp[k] + "\" -> \"" + c.getTitle() + "\" [" + statusColorArrow(courses.getCourseByName(temp[k]).getStatus()) + "]\n";
          }
      }
      if(!c.coReqs.equalsIgnoreCase("NONE")){
          String[] temp = c.getCoReqs().split(",");
          for(int k = 0; k < temp.length; k++){
              s += "\t\"" + temp[k] + "\" -> \"" + c.getTitle()  + "\" [style=dashed,dir=both," + statusColorArrow(courses.getCourseByName(temp[k]).getStatus()) + "]\n";
          }
      }
      
      return s;
     }
     private String subgraphColor(String sub){
         String s = "";
         
         switch(sub){
            case "HUMAN":
                s = "yellow";
                break;
            case "ENGL":
                s = "darkgoldenrod1";
                break;
            case "PROG":
                s = "white";
                break;
            case "GEN":
                s = "chartreuse";
                break;
            case "SBS":
                s = "black";
                break;
            case "NAT":
                s = "purple";
                break; 
            case "MATH":
                s = "brown";
                break;
            case "ADD":
                s = "grey";
                break;                
        }
         
         return s;
     }
     private String subgraphNodes(String subn){
      String s = "";
      String[] names = subn.split(" ");
      for(String node : names){
          s += "\n\t\t"+ drawNode(courses.getCourseByName(node));
      }
      
      return s;
     }
     private String drawSubgraphs(){
         String s = "";
         for(int k = 0; k < courses.getSubgraphNames().size(); k++){
             s += "\tsubgraph cluster_" + k 
                 + "{\n\t\t"
                 + "label = \"" + courses.getSubgraphNames().get(k) + "\";" 
                 + subgraphNodes(courses.getSmap().get(courses.getSubgraphNames().get(k)))
                 + "\n\t\tstyle=filled;\n\t\tfillcolor="
                 + subgraphColor(courses.getSubgraphNames().get(k))
                 + ";\n\t}\n";
         }
         return s;
     }
}
