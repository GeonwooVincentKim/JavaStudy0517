package File;

import java.util.Scanner;

import Manager.FileManager;
import static java.lang.System.out;

import java.io.File;
import java.io.Writer;

public class Q4 {
    public static Scanner readFile(FileManager fManager, String fileName) {
        return fManager.readFile(fileName);
    }

    public static void writeFile(FileManager fManager, String result) {
        fManager.writeFile("result4.txt", result);
    }

    public static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public static String getData(Scanner fileReader) {
        int readLine = Integer.parseInt(fileReader.nextLine());

        String getData = "";
        String first = "";
        String last = "";

        String result = "";

        boolean isDifference = false;

        for (int i = 1; i <= readLine; i++) {
            if (!fileReader.hasNextLine()) {
                System.out.println("더 이상 줄을 받아올 수 없습니다.");
                break;
            }

            int len = 0;
            boolean alpha[] = new boolean[125];
            String pattern = "";

            getData = fileReader.next();

            for (int j = 1; j <= getData.length(); j++) {
                first = getData.substring(0, j);
                last = getData.substring(j, j * 2);

                if (first.equals(last)) {
                    // out.println("ddddddddd");
                    result += "#" + i + " " + first.length() + "\n";
                    break;
                }

                // if (j == 1) {
                // // out.println("----------");
                // first = getData.substring(0, 1);
                // last = getData.substring(1, 2);

                // if (first.equals(last)) {
                // result += "#" + i + " " + first.length() + "\n";
                // // result += "#" + i + " " + first.charAt(j) + "\n";
                // break;
                // }
                // // else {
                // // // result += "#" + i + " " + first.charAt(j) + "\n";
                // // result += "#" + i + " " + first.length() + "\n";
                // // break;
                // // }
                // }
                // if (!alpha[(int) getData.charAt(j)]) {
                // alpha[(int) getData.charAt(j)] = true;
                // pattern += getData.charAt(j);
                // } else {
                // String competition = "";
                // len = pattern.length();
                // for (int k = len; k < len * 2; k++)
                // competition += getData.charAt(k);
                // if (pattern.equals(competition))
                // break;
                // else
                // pattern += getData.charAt(j);
                // }
            }
        }

        System.out.println(result);
        return result;
    }

    public static void writeResult(Scanner getResult, FileManager mFM) {
        String getData = getData(getResult);
        writeFile(mFM, getData);
    }

    public static void sub_main_q4(int userInput) {
        Scanner mainMenuInput = new Scanner(System.in);
        System.out.println("선택하세요.\n1. File 입출력\n2. 직접 입력");
        int selectNum = mainMenuInput.nextInt();

        File file = new File("data4.txt");

        Scanner fileReader = null;
        Writer fileWriter = null;

        FileManager mFM = new FileManager(file, fileWriter, fileReader);

        if (selectNum == 1) {
            fileReader = readFile(mFM, "data4.txt");
            writeResult(fileReader, mFM);
            mainMenuInput.close();

        } else if (selectNum == 2) {
            fileReader = new Scanner(System.in);
            out.print("데이터의 수량을 입력해주세요 : ");
            writeResult(fileReader, mFM);
            mainMenuInput.close();
        }
    }
}
