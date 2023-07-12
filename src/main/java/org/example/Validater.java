package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validater {


    public Boolean validationAnswer(String answer, Player player){
        if (numberCheck(answer) && lengthAndDupCheck(answer)){
            player.setAnswer(stringToNumberArray(answer));
            return true;
        }
        return false;
    }
    public Boolean numberCheck(String answer){
        return answer!= null && answer.matches("[0-9]+");
    }

    public String[] stringToArray(String answer){
        return answer.split("");

    }
    public Boolean lengthAndDupCheck(String answer){
        String[] stringArray = stringToArray(answer);
        if(stringArray.length == 3){
            Set<String> set = new HashSet<>(Arrays.asList(stringArray));
            return set.size() == stringArray.length;
        }
        return false;
    }

    public int[] stringToNumberArray(String answer){
        String[] stringArray = stringToArray(answer);
        int[] arrayAnswer = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            arrayAnswer[i] = Integer.parseInt(stringArray[i]);
        }
        return arrayAnswer;
    }

}

