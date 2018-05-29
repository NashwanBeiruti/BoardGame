package code.fileIo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileIO {
    /**
     * This method reads the contents of the indicated file and returns the contents as a String.
     * @param filename - the name of the file whose contents is to be read
     * @return the contents of the file, as String
     */
    public static String readFileToString(String filename) {
        Scanner scan = null;
        String contents = "";
        try {
            scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                contents = contents + scan.nextLine();
            }
         } catch (FileNotFoundException e) {
            System.err.println("File not found: "+filename);
        }
        finally {
        	if(scan != null)
            scan.close();
        }
        return contents;
    }
    
    /**
     * This method writes the String toOutput to the indicated file.
     * If the file does not exist, it is created.
     * If the file exists, it is overwritten.
     * @param filename - the name of the file to write to
     * @param toOutput - the String to be written to the file
     * @return true if writing the file was successful, false otherwise
     */
    public static boolean writeStringToFile(String filename, String toOutput) {
        PrintStream stream = null;
        boolean result = false;
        try {
            stream = new PrintStream(filename);
            stream.format("%s%n",toOutput);
            result = true;
        } catch (FileNotFoundException e) {
            System.err.println("File not found and cannot be created: "+filename);
        }
        finally {
        	if(stream != null)
            stream.close();
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(FileIO.writeStringToFile("team156.kbr", "example3"));
        System.out.println(FileIO.readFileToString("team156.kbr"));
    }

}
