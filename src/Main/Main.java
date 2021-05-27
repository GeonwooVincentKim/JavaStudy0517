package Main;

import java.io.File;
import java.util.Scanner;

import static File.Q1.sub_main_q1;
import static File.Q2.sub_main_q2;
import static File.Q3.sub_main_q3;
import static File.Q4.sub_main_q4;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Q1\n2. Q2\n3. Q3\n4. Q4");
        System.out.print("원하는 메뉴를 선택하세요 : ");
        
        int userInput = sc.nextInt();

        if(userInput == 1){
            sub_main_q1(userInput);
        } else if (userInput == 2){
            sub_main_q2(userInput);
        } else if (userInput == 3){
            sub_main_q3(userInput);
        } else if (userInput == 4){
            sub_main_q4(userInput);
        }

        sc.close();
    }
}
