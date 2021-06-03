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

    public static String getData(int loopCount) {
        // RNDM
        // int randomArray = 0;
        int[] randomArray = new int[loopCount];

        double average = 0; // 평균
        double sum = 0; // 랜덤 값을 더하기 위한 합
        double variance; // 분산
        double standardDeviation; // 표준편차
        double total = 0; // 분산 값을 더하기 위한 값

        String result = "";
        String loopResult = "";

        // 합계
        // for : 개별숫자합

        // 평균 : 합계 / loopCount

        // 분산
        // for : (개별숫자- 평균) 제곱

        // 표준편차
        // 분산 sqrt
        int i = 1;

        // 합계 저장 및 randomArray 출력
        for (i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomRange(11, 99);
            out.print(randomArray[i] + " ");
            loopResult += randomArray[i] + " ";
            sum += randomArray[i];
        }

        average = sum / randomArray.length; // 평균 계산

        // 분산 값 저장
        for (i = 0; i < randomArray.length; i++) {
            total += (randomArray[i] - average) * (randomArray[i] - average);
        }

        // 분산 계산
        variance = total / loopCount;

        // 표준 편차 계산
        standardDeviation = Math.sqrt(variance);

        out.print("\n");
        out.printf("평균 : %.2f", average);
        out.print("\n");

        out.printf("분산 : %.2f", variance);
        out.print("\n");

        out.printf("표준 편차 : %.2f", standardDeviation);
        out.print("\n");

        result = loopResult + "\n" + "평균 : " + String.format("%.2f", average) + "\n" + "분산 : "
                + String.format("%.2f", variance) + "\n" + "표준 편차 : " + String.format("%.2f", standardDeviation);

        return result;
    }

    public static void writeResult(int loopResult, FileManager mFM) {
        String getData = getData(loopResult);
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
            int loopCount = Integer.parseInt(fileReader.nextLine());
            writeResult(loopCount, mFM);
            mainMenuInput.close();

        } else if (selectNum == 2) {
            fileReader = new Scanner(System.in);
            out.print("데이터의 수량을 입력해주세요 : ");
            int loopCount = Integer.parseInt(fileReader.nextLine());
            writeResult(loopCount, mFM);
            mainMenuInput.close();
        }
    }
}
