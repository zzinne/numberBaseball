package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rule {
    private int[] result;


    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }


    public RefereeResult resultCheck(int[] result, int[] answer, RefereeResult refereeResult){
        int ball=0;
        int strike=0;
        int[] resultArray = result;
        System.out.println("result:"+ Arrays.toString(resultArray));
        resultArray = strikeCheck(answer, resultArray);
        strike = countZero(resultArray);
        if(strike == 3){
            Printer.printMessage("You Win result = :"+Arrays.toString(resultArray));
            refereeResult.setStatus(Status.END);
            return refereeResult;
        }
        ball = ballCheck(answer, resultArray);
        Printer.printMessage(strike+"S, "+ball+"B");
        refereeResult.setStatus(Status.CONTINUED);
        return refereeResult;
    }
    private int[] strikeCheck(int[] playerAnswer, int[] resultArray){
        for(int i=0; i < playerAnswer.length; i++){
            if (resultArray[i] == playerAnswer[i]){
                resultArray[i] = 0;
            }
        }
        return resultArray;
    }
    private int ballCheck(int[] playerAnswer, int[] resultArray){
        int ball=0;
        for (int result:resultArray){
            if(result > 0) {
                for (int answerValue : playerAnswer) {
                    if(result == answerValue){
                        ball++;
                        break;
                    }
                }
            }
        }
        return ball;
    }
    private int countZero(int[] resultArray){
        int strike=0;
        for (int result : resultArray){
            if (result ==0){
                strike++;
            }
        }
        return strike;
    }


    public boolean answerCheck(String answer){
        if (answer.length() < 3){
            return true;
        }
        return false;
    }
}
