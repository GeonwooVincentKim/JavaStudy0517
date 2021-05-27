package File;

import java.util.Scanner;

import Manager.FileManager;
import static java.lang.System.out;

import java.io.File;
import java.io.FileWriter;

public class Q3 {
    public static Scanner readFile(FileManager fManager, String fileName){
        return fManager.readFile(fileName);
    }

    public static void writeFile(FileManager fManager, String result){
        fManager.writeFile("result3.txt", result);
    }

    public static int[][] rotate(int[][] matrix){
        int m = matrix.length;
        int n = matrix.length;

        int[][] array = new int[m][n];
        int print = m;
        int right = -1;
        int bottom = 0;
        int top = 1;
        int k = 1;

        for(int i = m; i > 0; i--){
            for(int j = 0; j < print; j++){
                right += top;
                array[bottom][right] = k;
                k++;
            }
            
            print--;

            for (int j = 0; j < print; j++){
                bottom += top;
                array[bottom][right] = k;
                k++;
            }

            top = top * (-1);
        }
        out.println("");

        return array;
    }

    public static String getData(Scanner fileReader){
        out.println();
        int readFile = Integer.parseInt(fileReader.nextLine());
        out.print(readFile);

        int [][]splitNumLength = new int[readFile][readFile];
        int [][] getMatrix = splitNumLength;

        String result = "";

        splitNumLength = rotate(getMatrix);

        for(int i = 0; i < splitNumLength.length; i++){
            for(int j = 0; j < splitNumLength[i].length; j++){
                result += splitNumLength[i][j] + " ";
            }
            result += "\n";
        }

        out.print(result);
        return result;
    }

    public static void writeResult(Scanner getResult, FileManager mFM){
        String getData = getData(getResult);
        writeFile(mFM, getData);
    }

    public static void sub_main_q3(int userInput){
        Scanner mainMenuInput = new Scanner(System.in);
        System.out.println("선택하세요.\n1. File 입출력\n2. 직접 입력");
        int selectNum = mainMenuInput.nextInt();
        
        File file = new File("data3.txt");

        Scanner fileReader = null;
        FileWriter fileWriter = null;
        
        FileManager mFM = new FileManager(file, fileWriter, fileReader);

        if(selectNum == 1){
            fileReader = readFile(mFM, "data3.txt");    
            writeResult(fileReader, mFM);
            mainMenuInput.close();
            
        } else if (selectNum == 2){
            fileReader = new Scanner(System.in);  
            out.print("데이터의 수량을 입력해주세요 : ");
            writeResult(fileReader, mFM);
            mainMenuInput.close();
        }
    }
}
