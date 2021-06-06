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

    public static int[] getRandomNumber(int[] randomArray) {
        String loopResult = ""; // 출력된 getRandomArray 값들을 저장

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = randomRange(11, 99);
            // getRandomArray[i] = (int) (Math.random() * (99 - 11 + 1)) + 11;
            out.print(randomArray[i] + " ");
            loopResult += randomArray[i] + " ";
        }

        return randomArray;
    }

    public static String printRandomNumber(int[] randomArray) {
        String loopResult = "";

        for (int i = 0; i < randomArray.length; i++) {
            loopResult += randomArray[i] + " ";
        }

        return loopResult;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static double averageArray(double sum, int length) {
        return sum / length;
    }

    public static double varianceTotal(int[] arr, double average) {
        double total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += (arr[i] - average) * (arr[i] - average);
        }

        return total;
    }

    public static double variance(double total, int length) {
        return Double.parseDouble(String.format("%.2f", total / length));
    }

    public static double standardDeviation(double variance) {
        return Double.parseDouble(String.format("%.2f", Math.sqrt(variance)));
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

        String result = ""; // 최종 결과 값
        String loopResult = ""; // sum 값을 저장하기 위한 값

        // 합계
        // for : 개별숫자합

        // 평균 : 합계 / loopCount

        // 분산
        // for : (개별숫자- 평균) 제곱

        // 표준편차
        // 분산 sqrt

        // randomArray 출력
        randomArray = getRandomNumber(randomArray);
        loopResult = printRandomNumber(randomArray);
        out.println();

        // 합계 계산
        sum = sumArray(randomArray);
        // out.println(sum);

        // 평균 계산
        average = averageArray(sum, randomArray.length);
        // out.println(average);

        // 분산 값 저장
        total = varianceTotal(randomArray, average);
        // out.println(total);

        // 분산 계산
        variance = variance(total, randomArray.length);
        // out.println(variance);

        // 표준 편차
        standardDeviation = standardDeviation(variance);
        // out.println(standardDeviation);

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
