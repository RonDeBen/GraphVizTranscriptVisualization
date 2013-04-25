
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {

    private static PrintWriter outFile;
    
    public static void main(String[] args) throws IOException {
        
        Scanner fileScan = new Scanner(new File("transcript.txt"));
        outFile = new PrintWriter (new FileWriter ("transcript.dot"));
        
        Courses c = new Courses();
        DotWriter dw = new DotWriter(c);
        
        c.read(fileScan);
        c.findAvailableClasses();
        
        String s = dw.write();
        
        System.out.println(s);
        
        outFile.println(s);
        outFile.close();
    }
}
