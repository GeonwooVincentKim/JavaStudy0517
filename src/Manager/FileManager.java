package Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {
    public File file;
    public Scanner fileReader;
    public FileWriter fileWriter;

    public FileManager(File file, FileWriter fileWriter, Scanner fileReader){
        this.file = file;
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
    }

    public Scanner readFile(String fileName){
        file = new File(fileName);

        try {
            fileReader = new Scanner(file);
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return fileReader;
    }

    public void writeFile(String fileName, String result){
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(result);
            fileWriter.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
