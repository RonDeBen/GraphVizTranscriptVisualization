
import java.util.ArrayList;
import java.util.Scanner;


public class ClassReader {
    public ClassReader(){
    }
    ArrayList<String> subj = new ArrayList<String>();
    ArrayList<String> status = new ArrayList<String>();
    public Student read(Scanner fileScan){
     int counter = 0;
        String temp = "";
        while(fileScan.hasNext()){
            subj.add(fileScan.next());
            
            if(fileScan.hasNextInt()){
                temp = fileScan.next();
                if(Integer.parseInt(temp) > 2){
                    subj.set(counter, subj.get(counter) + " " + temp);
                    status.add(fileScan.next());
                }
                else if (Integer.parseInt(temp) >= 0)
                {
                    status.add(temp);
                }
            }else{
                temp = fileScan.next();
                subj.set(counter, subj.get(counter) + " " + temp);
                status.add(fileScan.next());
            }
            counter++;
        }
        return new Student(subj, status);
    }
}
