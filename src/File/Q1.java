package File;

import java.util.Scanner;

import Manager.FileManager;
import static java.lang.System.out;

import java.io.File;
import java.io.Writer;

public class Q1 {
    public static Scanner readFile(FileManager fManager, String fileName) {
        return fManager.readFile(fileName);
    }

    public static void writeFile(FileManager fManager, String result) {
        fManager.writeFile("result1.txt", result);
    }

    public static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public static String getData(Scanner fileReader) {
        int readLine = Integer.parseInt(fileReader.nextLine());

        int storeRanNum = 0;

        double avg = 0; // 평균
        double sum = 0; // 분산 값을 더하기 위한 합
        double breakUp = 0; // 분산
        double standard = 0; // 표준편차

        String result = "";
        String loopResult = "";

        for (int i = 1; i <= readLine; i++) {
            storeRanNum = randomRange(11, 99);
            avg += storeRanNum / readLine;
            sum += (storeRanNum - avg) * (storeRanNum - avg);
            breakUp = sum / storeRanNum;

            out.print(storeRanNum + " ");
            loopResult += storeRanNum + " ";
        }

        standard = Math.sqrt(breakUp);

        out.print("\n");
        out.printf("평균 : %.2f", avg);
        out.print("\n");

        out.printf("분산 : %.2f", breakUp);
        out.print("\n");

        out.printf("표준 편차 : %.2f", standard);
        out.print("\n");

        result = loopResult + "\n" + "평균 : " + String.format("%.2f", avg) + "\n" + "분산 : "
                + String.format("%.2f", breakUp) + "\n" + "표준 편차 : " + String.format("%.2f", standard);

        return result;
    }

    public static void writeResult(Scanner getResult, FileManager mFM) {
        String getData = getData(getResult);
        writeFile(mFM, getData);
    }

    public static void sub_main_q1(int userInput) {
        Scanner mainMenuInput = new Scanner(System.in);
        System.out.println("선택하세요.\n1. File 입출력\n2. 직접 입력");
        int selectNum = mainMenuInput.nextInt();

        File file = new File("data1.txt");

        Scanner fileReader = null;
        Writer fileWriter = null;

        FileManager mFM = new FileManager(file, fileWriter, fileReader);

        if (selectNum == 1) {
            fileReader = readFile(mFM, "data1.txt");
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
