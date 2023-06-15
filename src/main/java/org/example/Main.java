package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game Start");
        Game game = new Game();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        game.makeResult();
        while (game.countCheck()){
            game.countAdd();
            System.out.println("1 ~ 9까지의 자연수 3개를 입력하세요");
            String answer = scanner.nextLine();
            if (answer.length()<2){
                System.out.println("다시 1 ~ 9까지의 자연수 3개를 입력하세요");
                answer = scanner.nextLine();
            }
            player.check(answer);
            System.out.println(game.answerCheck(player.getAnswer()));
        }

        System.out.println("입력 횟수가 초과하였습니다.");

    }
}