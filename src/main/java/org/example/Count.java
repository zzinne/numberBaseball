package org.example;

import java.util.Scanner;

public class Count {
    public int count = 0;
    public int overCount;

    public void askCountOver(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("최종 응답 횟수를 지정하세요");
        setOverCount(scanner.nextInt());
    }
    public void setOverCount(int overCount) {
        this.overCount = overCount;
    }

    public void countAdd(){
        this.count++;
    }
    public boolean isCountOver(){
        return this.count > this.overCount;
    }
}
