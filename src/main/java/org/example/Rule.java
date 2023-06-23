package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rule {
    private int[] result;
    private int count = 0;
    private String printValue = "";

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    public String getPrintValue() {
        return printValue;
    }

    public int getCount() {
        return count;
    }

    public boolean resultCheck(int[] playerAnswer){
        int ball=0;
        int strike=0;
        int[] resultArray = getResult();
        System.out.println("result:"+ Arrays.toString(resultArray));
        resultArray = strikeCheck(playerAnswer, resultArray);
        strike = countZero(resultArray);
        if(strike == 3){
            this.printValue = "You Win result = :"+Arrays.toString(resultArray);
            return true;
        }
        ball = ballCheck(playerAnswer, resultArray);
        this.printValue = strike+"S, "+ball+"B";
        return false;
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
    public int countAdd(){
        return this.count++;
    }

    public void makeResult(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.shuffle(list);
        result= new int[]{list.get(0),list.get(1), list.get(2)};
        setResult(result);
    }
    public boolean answerCheck(String answer){
        if (answer.length() < 3){
            return true;
        }
        return false;
    }
}
