
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {

    private static PrintWriter outFile;
    
    public static void main(String[] args) throws IOException {
        
        Scanner fileScan = new Scanner(new File("transcript.txt"));
        outFile = new PrintWriter (new FileWriter ("transcript2.txt"));
        
        Courses c = new Courses();
        c.read(fileScan);
        c.findAvailableClasses();
        c.findAvailableClasses();
        c.write();
        
        outFile.println("");
        outFile.close();
    }
}
