package File;

import java.util.ArrayList;
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

        for (int i = 0; i < cntArr.size(); i++) {
            out.print(cntArr.get(i) + " ");
        }

        out.println();
        setResult += "\n";

        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printCnt; i++) {
            out.print("#" + (i + 1) + " " + cntArr.get(i));
            out.println(" (" + frequency(randArr, cntArr.get(i)) + ")");
            setResult += "#" + (i + 1) + " " + cntArr.get(i) + "\n";
        }

        return setResult;
    }

    public static void bubbleSort(List<Integer> countList, int tempValue, int currentValue, int i, int j,
            int nextValue) {
        tempValue = currentValue;
        countList.set(i, nextValue);
        countList.set(j, tempValue);
    }

    public static boolean containsList(List<Integer> countList, int temp) {
        boolean result = false;
        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) != temp) {
                result = true;
            }
        }

        return result;
    }

    public static int frequency(List<Integer> countList, int n) {
        int count = 0;

        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) == n) {
                count++;
            }
        }

        return count;
    }

    public static boolean isContains(List<Integer> countList, int temp) {
        for (int i = 0; i < countList.size(); i++) {
            if (countList.get(i) == temp) {
                return true;
            }
        }
        return false;
    }

    public static int[] convertToIntArray(List<Integer> countList) {
        int[] returnArray = new int[countList.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = countList.get(i).intValue();
        }
        return returnArray;
    }

    public static String getData(int loopCount) {
        /*
         * 1. 배열에 random 값 담기 2. 중복 제거 된 배열 만들기 (contains 함수 사용 금지 - 새로 들어온 숫자가 기존 배열에
         * 있는지 체크하는 함수하나 만들기) 3. 중복 제거 된 배열 루프 돌면서 각각 몇 번 발생한 횟수 (발생 횟수 세는 함수 만들기) 4.
         * 발생한 횟수로 역순 정렬 5. 출력
         */
        int printT = 5; // 출력할 랜덤 값 개수
        String result = "";

        List<Integer> randList = new ArrayList<>(); // 랜덤 값
        List<Integer> countList = new ArrayList<>(); // 중복 제거

        int temp[] = new int[loopCount]; // 랜덤 값
        // temp = extracted3(randList, temp);
        randList = getRandomList(randList, temp);

        // temp = extracted2(countList, temp);
        countList = countRandomList(countList, temp);

        // 빈도수를 찾음과 동시에 bubbleSort
        result = getResult(printT, randList, countList);

        return result;
    }

    public static String getResult(int printT, List<Integer> randList, List<Integer> countList) {
        String result;
        arrangeRandomList(randList, countList);

        // out.println();
        result = printArray(randList, countList, printT) + " ";
        return result;
    }

    public static List<Integer> getRandomList(List<Integer> randList, int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            // T 값만큼 랜덤한 수를 생성
            temp[i] = (int) (Math.random() * (99 - 11 + 1) + 11);
            randList.add(temp[i]);
        }

        return randList;
    }

    public static List<Integer> countRandomList(List<Integer> countList, int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            // 랜덤한 수에서 중복 제거
            if (!isContains(countList, temp[i])) {
                countList.add(temp[i]);
            }
        }

        return countList;
    }

    public static void arrangeRandomList(List<Integer> randList, List<Integer> countList) {
        int currentValue = 0; // 현재 값
        int currentCount = 0; // 현재 값의 빈도 수
        int nextValue = 0; // 다음 값
        int nextCount = 0; // 다음 값의 빈도 수

        for (int i = 0; i < countList.size(); i++) {
            for (int j = i + 1; j < countList.size(); j++) {
                currentValue = countList.get(i);
                nextValue = countList.get(j);

                currentCount = frequency(randList, currentValue);
                nextCount = frequency(randList, nextValue);

                int tempValue = 0; // 임시 저장 값
                // 내림차순 정렬
                if (currentCount < nextCount) {
                    bubbleSort(countList, tempValue, currentValue, i, j, nextValue);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    bubbleSort(countList, tempValue, currentValue, i, j, nextValue);
                }
            }
        }
    }

    public static void writeResult(int loopCount, FileManager mFM) {
        String getData = getData(loopCount);
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
            int loopCount = Integer.parseInt(fileReader.nextLine()); // 생성할 랜덤 값 개수
            writeResult(loopCount, mFM);
            mainMenuInput.close();

        } else if (selectNum == 2) {
            fileReader = new Scanner(System.in);
            out.print("데이터의 수량을 입력해주세요 : ");
            int loopCount = Integer.parseInt(fileReader.nextLine()); // 생성할 랜덤 값 개수
            writeResult(loopCount, mFM);
            mainMenuInput.close();
        }
    }
}
