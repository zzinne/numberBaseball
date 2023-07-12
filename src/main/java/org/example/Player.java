package org.example;

import java.util.Scanner;

public class Player {
    private int[] answer;

    public void registAnswer(String answer){
        this.answer = stringToNumber(answer);
    }
    public int[] stringToNumber(String answer){
//        String[] stringArray = answer.split("");
        int[] arrayAnswer = new int[3];
        for(int i = 0; i < stringArray.length; i++){
            arrayAnswer[i] = Integer.parseInt(stringArray[i]);
        }
            return arrayAnswer;
    }
    public void sayAnwser(){
        Printer.printMessage("0 ~ 9까지의 수를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        registAnswer(scanner.nextLine());
    }

    public int[] getAnswer() {
        return this.answer;
    }
}
