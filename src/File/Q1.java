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
        int i = 0;
        int getRandomArray[] = new int[randomArray.length];

        for (i = 0; i < getRandomArray.length; i++) {
            getRandomArray[i] = randomRange(11, 99);
            out.print(getRandomArray[i] + " ");
        }

        return getRandomArray;
    }

    public static String printRandomNumber(int[] randomArray) {
        // printRandomNumber 가
        // 랜덤 값을 출력할 때
        // getRandomNumber 로부터
        // randomArray 배열을 넘겨 받아서
        // loopResult 에 저장하여 랜덤 값을 출력한다.

        int i = 0;
        String loopResult = "";

        for (i = 0; i < randomArray.length; i++) {
            loopResult += randomArray[i] + " ";
        }

        return loopResult;
    }

    public static double sumRandomNumber(int[] randomArray) {
        int i = 0;
        double sum = 0;

        // randomArray 로부터 값을 넘겨 받은 다음, sum 값에 randomArray의 값을 저장
        for (i = 0; i < randomArray.length; i++) {
            sum += randomArray[i];
            out.println(sum + " ");
        }

        return sum;
    }

    public static double averageRandomNumber(int[] randomArray) {
        // 누가, 언제, 어디서, 무엇을, 어떻게, 왜
        // averageRandomNumber 가
        // 평균을 구할 때
        // sumRandomNumber 로부터
        // sum 값을
        // 넘겨 받아서
        // 평균을 계산한다.

        double sum = sumRandomNumber(randomArray);

        double average = 0;
        average = sum / randomArray.length;

        return average;
    }

    public static Double varianceRandomNumber(int[] randomArray) {
        // varianceRandomNumber 가
        // 각 랜덤 값과 평균 값의 차를 구할 때
        // averageRandomNumber 로부터
        // average 값을
        // 넘겨 받아서
        // 각 랜덤 값과 평균 값의 차를 구한다.

        double total = 0;
        double getAverage = averageRandomNumber(randomArray);

        for (int i = 0; i < randomArray.length; i++) {
            total += (randomArray[i] - getAverage) * (randomArray[i] - getAverage);
            out.println(total + " " + i);
        }

        return total;
    }

    public static Double varianceNumber(int[] randomArray) {
        // varianceNumber 가
        // 분산 값을 구할 때
        // varianceRandomNumber 로부터
        // total(각 랜덤 값과 평균 값의 차) 값을
        // 넘겨 받아서
        // 분산 값을 구한다.

        double total = varianceRandomNumber(randomArray);

        double variance = 0;
        variance = total / randomArray.length;

        return variance;
    }

    public static Double standardDeviation(int[] randomArray) {
        // standardDeviation 가
        // 표준 편차를 구할 때
        // varianceNumber 로부터
        // variance (분산) 값을
        // 넘겨 받아서
        // 분산 값을 구한다.

        double variance = varianceNumber(randomArray);

        double standardDeviation = 0;
        standardDeviation = Math.sqrt(variance);

        return standardDeviation;
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

        // randomArray 값 추출
        randomArray = getRandomNumber(randomArray);

        // randomArray 값 loopResult 에 저장
        loopResult = printRandomNumber(randomArray);

        // 합계
        sum = sumRandomNumber(randomArray);

        // 평균
        average = averageRandomNumber(randomArray);

        // 분산 값(각 랜덤 값과 평균의 차) 저장
        total = varianceRandomNumber(randomArray);

        // 분산
        variance = varianceNumber(randomArray);

        // 표준 편차
        standardDeviation = standardDeviation(randomArray);

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