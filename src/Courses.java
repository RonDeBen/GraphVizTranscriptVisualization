
import java.util.ArrayList;
import java.util.Scanner;


public class Courses {
    
    private ArrayList<Course> c = new ArrayList<Course>();
    
    public Courses(){
        //I. ENGLISH COMPOSITION(6 hrs)
       c.add(new Course("ENGL_105", "ENGL", "NONE", "NONE"));
       c.add(new Course("ENGL_115", "ENGL", "ENGL_105", "NONE"));
       
       //II.Social/Behavioral Sciences (6 hrs.) must be from two different disciplines 
       c.add(new Course("ECON_2XX", "ECO", "NONE", "NONE"));
       c.add(new Course("S/BS", "GRID", "NONE", "NONE"));//special case- make exception for it
       
       //III. Mathematics(8 hrs.)
       c.add(new Course("MATH_221", "MATH", "NONE", "NONE"));
       c.add(new Course("MATH_222", "MATH", "NONE", "NONE"));
       
       //IV. Natural Sciences(9 hrs. GE) & (2hrs ABET)
       c.add(new Course("BIOS_110", "BIO", "NONE", "NONE"));
       c.add(new Course("PHYS", "GRID", "NONE", "NONE"));//special case CHEM_121, CHEM_124, PHYS_261, PHYS_262
       //-----TODO-----
       //sequence and lab1 and lab2: figure out how to display
       ///----TODO-----
       
       //V. Humanities(9 hrs.)
       c.add(new Course("COMM_135", "HUMAN", "NONE", "NONE"));
       c.add(new Course("HIST", "GRID", "NONE", "NONE"));//HIST_105, HIST_106, HIST_107, HIST_145, HIST_146
       c.add(new Course("ENGL_2XX", "ENGL", "NONE", "NONE"));
       
       //General Electives(16 hrs.)
       //----TODO-----
       c.add(new Course("FS_104", "FS", "NONE", "NONE"));//OR
       //c.add(new Course("General_Electives", "GRID", "NONE", "NONE"));
       
       //Program Requirements (46 hrs.)
       c.add(new Course("CSC_135", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_145", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_242", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_285", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_315", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_345", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_346", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_382", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_405", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_460", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_480", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_481", "CSC", "NONE", "NONE"));
       c.add(new Course("CSC_485", "CSC", "NONE", "NONE"));
       
       //Electives(9 hrs.)
       c.add(new Course("CSC_400+", "GRID", "NONE", "NONE"));
       
       //Additional Degree Requirements(15 hrs.)
       c.add(new Course("ENGL_325", "ENGL", "NONE", "NONE"));
       c.add(new Course("SCIENCE", "GRID", "NONE", "NONE"));//FIX THIS SHIT, BRAH
       c.add(new Course("MATH_201", "MATH", "NONE", "NONE"));
       c.add(new Course("MATH_254", "MATH", "NONE", "NONE"));
       c.add(new Course("MATH_260", "MATH", "NONE", "NONE"));
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
}
    

