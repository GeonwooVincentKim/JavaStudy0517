package File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Manager.FileManager;
import static java.lang.System.out;

import java.io.File;
import java.io.Writer;

public class Q2 {
    public static Scanner readFile(FileManager fManager, String fileName) {
        return fManager.readFile(fileName);
    }

    public static void writeFile(FileManager fManager, String result) {
        fManager.writeFile("result2.txt", result);
    }

    public static String printArray(List<Integer> randArr, List<Integer> cntArr, int printCnt) {
        String setResult = "";

        // 랜덤 배열 출력
        for (int i = 0; i < randArr.size(); i++) {
            out.print(randArr.get(i) + " ");
            setResult += randArr.get(i) + " ";
        }

        out.println();
        setResult += "\n";

        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printCnt; i++) {
            out.print("#" + (i + 1) + " " + cntArr.get(i));
            out.println(" (" + Collections.frequency(randArr, cntArr.get(i)) + ")");
            setResult += "#" + (i + 1) + " " + cntArr.get(i) + "\n";
        }

        return setResult;
    }

    public static void bubbleSort(List<Integer> cntList, int tempValue, int currentValue, int i, int j, int nextValue) {
        tempValue = currentValue;
        cntList.set(i, nextValue);
        cntList.set(j, tempValue);
    }

    public static String getData(Scanner fileReader) {
        int T = Integer.parseInt(fileReader.nextLine()); // 생성할 랜덤 값 개수
        int printT = 5; // 출력할 랜덤 값 개수
        String result = "";

        List<Integer> randList = new ArrayList<>(); // 랜덤 값
        List<Integer> cntList = new ArrayList<>(); // 중복 제거

        int temp = 0; // 랜덤 값
        for (int i = 0; i < T; i++) {
            // T 값만큼 랜덤한 수를 생성
            temp = (int) (Math.random() * (99 - 11 + 1) + 11);
            randList.add(temp);

            // 랜덤한 수에서 중복 제거
            if (!cntList.contains(temp)) {
                cntList.add(temp);
            }
        }

        int currentValue = 0; // 현재 값
        int currentCnt = 0; // 현재 값의 빈도 수
        int nextValue = 0; // 다음 값
        int nextCnt = 0; // 다음 값의 빈도 수

        for (int i = 0; i < cntList.size(); i++) {
            for (int j = i + 1; j < cntList.size(); j++) {
                currentValue = cntList.get(i);
                nextValue = cntList.get(j);

                currentCnt = Collections.frequency(randList, currentValue);
                nextCnt = Collections.frequency(randList, nextValue);

                int tempValue = 0; // 임시 저장 값
                // 내림차순 정렬
                if (currentCnt < nextCnt) {
                    bubbleSort(cntList, tempValue, currentValue, i, j, nextValue);
                } else if (currentCnt == nextCnt && currentValue < nextValue) {
                    bubbleSort(cntList, tempValue, currentValue, i, j, nextValue);
                }
            }
        }

        out.println();
        result = printArray(randList, cntList, printT) + " ";

        return result;
    }

    public static void writeResult(Scanner getResult, FileManager mFM) {
        String getData = getData(getResult);
        writeFile(mFM, getData);
    }

    public static void sub_main_q2(int userInput) {
        Scanner mainMenuInput = new Scanner(System.in);
        System.out.println("선택하세요.\n1. File 입출력\n2. 직접 입력");
        int selectNum = mainMenuInput.nextInt();

        File file = new File("data2.txt");

        Scanner fileReader = null;
        Writer fileWriter = null;

        FileManager mFM = new FileManager(file, fileWriter, fileReader);

        if (selectNum == 1) {
            fileReader = readFile(mFM, "data2.txt");
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
