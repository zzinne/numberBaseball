package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validater {

    public int[] validationAnswer(String answer) throws Exception {
        if (numberCheck(answer) && lengthAndDupCheck(answer)){
            return stringToNumberArray(answer);
        }
        throw new IllegalArgumentException();
    }
    public boolean numberCheck(String answer) throws Exception {
        if(!(answer!= null && answer.matches("[0-9]+"))) {
            Printer.printMessage("숫자만 입력 하세요.");
            throw new Exception();
        }
        return true;

    }

    public String[] stringToArray(String answer){
        return answer.split("");

    }
    public Boolean lengthAndDupCheck(String answer) throws Exception {
        String[] stringArray = stringToArray(answer);
        if(stringArray.length == 3){
            Set<String> set = new HashSet<>(Arrays.asList(stringArray));
            return set.size() == stringArray.length;
        }
        Printer.printMessage("숫자를 총 3개 입력하세요.");
        throw new Exception();
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

