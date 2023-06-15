package org.example;

public class Player {
    private int[] answer;

    public void check(String answer){
        this.answer = stringToNumber(answer);
    }
    public int[] stringToNumber(String answer){
        String[] stringArray = answer.split("");
        int[] arrayAnswer = new int[3];
        for(int i = 0; i < stringArray.length; i++){
            arrayAnswer[i] = Integer.parseInt(stringArray[i]);
        }
        return arrayAnswer;
    }

    public int[] getAnswer() {
        return answer;
    }
}
