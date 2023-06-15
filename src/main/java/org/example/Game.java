package org.example;

import java.util.*;

public class Game {
    private int[] answer;

    private int count = 0;
    Player player = new Player();
    public String answerCheck(int[] playerAnswer){
        int ball=0;
        int strike=0;
        int[] resultArray = this.answer;
        System.out.println("result:"+Arrays.toString(resultArray));
        resultArray = strikeCheck(playerAnswer,resultArray);
        strike = countZero(resultArray);
        if(strike == 3){
            return "You Win result = :"+Arrays.toString(resultArray);
        }
        ball = ballCheck(playerAnswer, this.answer);


        return strike+"S, "+ball+"B";
    }
    private int[] strikeCheck(int[] playerAnswer,int[] resultArray){
        for(int i=0; i<playerAnswer.length; i++){
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
        for (int result:resultArray){
            if (result ==0){
                strike++;
            }
        }
        return strike;
    }
    public boolean countCheck(){
        return this.count < 6 ;
    }
    public int countAdd(){
        return this.count++;
    }

    public void makeResult(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.shuffle(list);
        this.answer= new int[]{list.get(0),list.get(1), list.get(2)};
    }
}
