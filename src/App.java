import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        fun(new File(System.getProperty("user.dir") + File.separator + "input.ics"));
        System.out.println("done");
    }

    public static void fun(File f) throws IOException{
        File out = new File("output.ics");
        String s;
        String buffer = "";
        String outString = "";
        Boolean flag = false;
        try(Scanner sc = new Scanner(f)){
            while(sc.hasNextLine()){
                s = sc.nextLine() + "\n";
                buffer = "";
                flag = false;
                if(s.contains("BEGIN:VEVENT")){
                    buffer = s;
                    while(!s.contains("END:VEVENT")){
                        s = sc.nextLine() + "\n";
                        if(!s.contains("Como")){
                            buffer += s;
                        }else{
                            flag = true;
                        }
                    }
                    if(!flag)
                        outString += buffer;
                }else{
                    outString += s;
                }
            }
        }
        try(FileWriter fw = new FileWriter(out)){
            fw.append(outString);
        }
    }
}
