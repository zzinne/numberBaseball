package org.example;

import java.util.Scanner;

public class Player {
    private int[] answer;
    Validater validater = new Validater();
    public void   playerSayAnswer(String answer){
        try{
            setAnswer(validater.validationAnswer(answer));
        }catch (Exception e){

        }
    }

    public String sayAnswer(){
        Printer.printMessage("0 ~ 9까지의 수를 입력하세요 ex) 123");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int[] getAnswer() {
        return this.answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
