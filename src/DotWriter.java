
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DotWriter {
       
    public Map<String, String> map = new HashMap<String, String>();
    
    public DotWriter(){
        map.put("ENGL 105", "NO_REQUIREMENTS -> ENGL_105 @");
        map.put("ENGL 115", "ENGL_105 -> ENGL_115 @");
        map.put("GE II*", "");
        map.put("GE II*", "");
        map.put("MATH 221", "MATH_121 -> MATH_221 @\n\tMATH_122 -> MATH_221 @");
        map.put("MATH 222", "MATH_221 -> MATH_222 @");
        map.put("GE IV*", "");
        map.put("GE IV*", "");
        map.put("GE IV*", "");
        map.put("GE IV*", "");
        map.put("GE IV*", "");
        map.put("GE IV*", "");
        map.put("COMM 135", "ENGL_105 -> COMM_135 @");
        map.put("GE V*", "");
        map.put("GE V*", "");
        map.put("GE VI*", "");
        map.put("MATH 201", "MATH_121 -> MATH_201 @");
        map.put("MATH 254", "MATH_221 -> MATH_254 @");
        map.put("MATH 260", "MATH_121 -> MATH_260 @\n\tCSC_115 -> MATH_260 @");
        map.put("ENGL 325", "ENGL_115 -> ENGL_325 @");
        map.put("CSC 135", "CSC_115 -> CSC_135 @");
        map.put("CSC 145", "CSC_135 -> CSC_145 @");
        map.put("CSC 285", "CSC_145 -> CSC_285 @ \n\t MATH_201 -> CSC_285 @");
        map.put("CSC 242", "CSC_135 -> CSC_242 @");
        map.put("CSC 315", "CSC_145 -> CSC_315 @\n\t MATH_201 -> CSC_315 @");
        map.put("CSC 345", "CSC_145 -> CSC_345 @");
        map.put("CSC 346", "CSC_345 -> CSC_346 @");
        map.put("CSC 382", "CSC_242 -> CSC_382 @");
        map.put("CSC 405", "CSC_345 -> CSC_405 @");
        map.put("CSC 460", "CSC_345 -> CSC_460 @");
        map.put("CSC 480", "CSC_345 -> CSC_480 @");
        map.put("CSC 481", "CSC_480 -> CSC_481 @\n\t CSC_315 -> CSC_481 @\n\t CSC_460 -> CSC_481 @");
        map.put("CSC 485", "CSC_345 -> CSC_485 @");
        map.put("CSC 400+", "");
        map.put("CSC 400+", "");
        map.put("CSC 400+", "");
        map.put("FS 104", "");
        map.put("EL2#", "");
        map.put("EL3#", "");
        map.put("EL4#", "");
        map.put("EL5#", "");
        map.put("EL6#", "");
    }
    
    public String write (Student stud){
        ArrayList<String> subj = stud.getSubj();
        ArrayList<String> status = stud.getStatus();
        String s = "digraph g {\n";
        
        for(int k = 0; k < subj.size();k++){
            s+= "\t" + denoteStatus(underScorned(subj.get(k)) + " @", status.get(k)) + "\n";
        }
        
        for(int k = 0; k < subj.size(); k++){
            s += "\t" + map.get(subj.get(k)) + "\n";
        }
        s += "}";
        return s;
    }
    
    private String denoteStatus(String toDenote, String status){
        String s = "";
        switch(status){
            case "0":
                s = toDenote.replace("@", "[color=red]");
                break;
            case "1":
                s = toDenote.replace("@", "[color=yellow]");
                break;
            case "2":
                s = toDenote.replace("@", "[color=green]");
                break;
        }
        return s;
    }
    private String underScorned(String toChange){
        String s = "";
        s = toChange.replace(" ","_");
        return s;
    }
}
