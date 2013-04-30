
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Courses {
    
    public ArrayList<Course> c = new ArrayList<Course>();
    public Map<String, String> smap = new HashMap<String, String>();
    public ArrayList<String> subgraphNames = new ArrayList<String>();
    public Courses(Scanner fileScan){
        while(fileScan.hasNext()){
            c.add(new Course(fileScan.next(), fileScan.next(), fileScan.next(), fileScan.next(), fileScan.next()));
        }
    }
    public Courses(){
       /*//I. ENGLISH COMPOSITION(6 hrs)
       c.add(new Course("ENGL_105", "ENGL", "NONE", "NONE"));
       c.add(new Course("ENGL_115", "ENGL", "ENGL_105", "NONE"));
       
       //II.Social/Behavioral Sciences (6 hrs.) must be from two different disciplines 
       c.add(new Course("ECON_2XX", "ECO", "MATH_121", "NONE"));
       c.add(new Course("SBS", "GRID", "NONE", "NONE"));//special case- make exception for it
       
       //III. Mathematics(8 hrs.)
       c.add(new Course("MATH_121", "MATH", "NONE", "NONE"));//not in curriculum
       c.add(new Course("MATH_122", "MATH", "MATH_121", "NONE"));//not in curriculum
       c.add(new Course("MATH_221", "MATH", "MATH_121,MATH_122", "NONE"));
       c.add(new Course("MATH_222", "MATH", "MATH_221", "NONE"));
       
       //IV. Natural Sciences(9 hrs. GE) & (2hrs ABET)
       c.add(new Course("BIOS_110", "BIO", "NONE", "NONE"));
       c.add(new Course("PHYS", "GRID", "NONE", "NONE"));//special case CHEM_121, CHEM_124, PHYS_261, PHYS_262
       //-----TODO-----
       //sequence and lab1 and lab2: figure out how to display
       ///----TODO-----
       
       //V. Humanities(9 hrs.)
       c.add(new Course("COMM_135", "HUMAN", "ENGL_105", "NONE"));
       c.add(new Course("HIST", "GRID", "NONE", "NONE"));//HIST_105, HIST_106, HIST_107, HIST_145, HIST_146
       c.add(new Course("ENGL_2XX", "ENGL", "ENGL_115", "NONE"));
       
       //General Electives(16 hrs.)
       c.add(new Course("GEN_ED", "GRID", "NONE", "NONE"));
       
       //Program Requirements (46 hrs.)
       c.add(new Course("CSC_115", "CSC", "NONE", "NONE"));//not in curriculum
       c.add(new Course("CSC_120", "CSC", "CSC_115", "MATH_121"));//not in curriculum
       
       c.add(new Course("CSC_135", "CSC", "CSC_115", "MATH_121"));
       c.add(new Course("CSC_145", "CSC", "CSC_135", "NONE"));
       c.add(new Course("CSC_242", "CSC", "CSC_135", "CSC_145,MATH_201"));
       c.add(new Course("CSC_285", "CSC", "CSC_145,MATH_201", "NONE"));
       c.add(new Course("CSC_315", "CSC", "CSC_145,MATH_201", "NONE"));
       c.add(new Course("CSC_345", "CSC", "CSC_145", "NONE"));//CHECK THIS
       c.add(new Course("CSC_346", "CSC", "CSC_345", "NONE"));
       c.add(new Course("CSC_382", "CSC", "CSC_242", "CSC_345"));
       c.add(new Course("CSC_405", "CSC", "CSC_345", "NONE"));
       c.add(new Course("CSC_460", "CSC", "CSC_345,MATH_254", "NONE"));
       c.add(new Course("CSC_480", "CSC", "CSC_345", "NONE"));
       c.add(new Course("CSC_481", "CSC", "CSC_480,CSC_315,CSC_460", "NONE"));
       c.add(new Course("CSC_485", "CSC", "CSC_345", "NONE"));
       
       //Electives(9 hrs.)
       c.add(new Course("CSC_400", "GRID", "NONE", "NONE"));// do special stuff with this one
       
       //Additional Degree Requirements(15 hrs.)
       c.add(new Course("ENGL_325", "ENGL", "ENGL_115", "NONE"));
       c.add(new Course("SCIENCE", "GRID", "NONE", "NONE"));//FIX THIS SHIT, BRAH
       c.add(new Course("MATH_201", "MATH", "MATH_121", "NONE"));
       c.add(new Course("MATH_254", "MATH", "MATH_221", "NONE"));
       c.add(new Course("MATH_260", "MATH", "MATH_121,CSC_115", "NONE"));*/
    }

    public ArrayList<Course> getC() {
        return c;
    }

    public Map<String, String> getSmap() {
        return smap;
    }

    public ArrayList<String> getSubgraphNames() {
        return subgraphNames;
    }
    
    
    public Course getCourseByName(String name){
        int i = 0;
        while(i < c.size()){
            if(c.get(i).getTitle().equalsIgnoreCase(name)){
                return c.get(i);
            }
            i++;
        }
        return null;
     }
    
    public void read(Scanner fileScan){
        while(fileScan.hasNext()){
                getCourseByName(fileScan.next()).setStatus(fileScan.next());
            }
}
    public void write(){
        for(int k = 0; k < c.size(); k++){ System.out.println(c.get(k));}
    }
    
    public void findAvailableClasses(){
         String[] temp = null;
        for(int k = 0; k < c.size(); k++){
            c.get(k).setAvailable(true);
            if(!c.get(k).getPreReqs().equalsIgnoreCase("NONE")){
                temp = c.get(k).getPreReqs().split(",");
                for(int j = 0; j < temp.length; j++){
                    if(!getCourseByName(temp[j]).getStatus().equalsIgnoreCase("2")){
                        c.get(k).setAvailable(false);
                    }
                }
            }
        }
        
    }
    
    public void findSubgraphs(){
        ArrayList<String> contains = new ArrayList<String>();
        String temp = "";
        boolean add = false;
        for(int k = 0; k < c.size(); k++){
            add = true;
            for(int j = 0; j < subgraphNames.size();j++){
                if(c.get(k).getSubgraph().equalsIgnoreCase(subgraphNames.get(j)))
                    add = false;
            }
            if(add)
                subgraphNames.add(c.get(k).getSubgraph());
        }
        
        for(int k = 0; k < subgraphNames.size(); k++){
            temp = "";
            for(int j = 0; j < c.size(); j++){
                if(c.get(j).getSubgraph().equalsIgnoreCase(subgraphNames.get(k)))
                    temp += "\"" + c.get(j).getTitle() + "\";";
            }
            contains.add(temp);
        }
        for(int k = 0; k < subgraphNames.size(); k++){
            smap.put(subgraphNames.get(k), contains.get(k));
        }
    }
}
    

