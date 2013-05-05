
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class GraphViz {

    private static PrintWriter outFile;
    private String curriculum, transcript, outName;
    public static void main(String[] args) throws IOException {
        
        GraphViz program = new GraphViz(args);
        program.run();
    }
    
    private GraphViz(String[] args){
        this.curriculum = args[0];
        this.transcript = args[1];
        this.outName = args[2];
    }
    
    private void run() throws IOException{
        Scanner fileScan = new Scanner(new File(curriculum+".txt"));
        outFile = new PrintWriter (new FileWriter (outName+".dot"));
        
        Courses c = new Courses(fileScan);
        DotWriter dw = new DotWriter(c);
        
        fileScan = new Scanner(new File(transcript+".txt"));
        
        c.read(fileScan);
        c.findAvailableClasses();
        c.findSubgraphs();
        
        String s = dw.write();
        
        System.out.println(s);
        
        outFile.println(s);
        outFile.close();
    }
}

