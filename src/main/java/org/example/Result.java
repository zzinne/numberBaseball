package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Result {
    public static int[] makeResult(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.shuffle(list);
        return new int[]{list.get(0),list.get(1), list.get(2)};

    }
}
