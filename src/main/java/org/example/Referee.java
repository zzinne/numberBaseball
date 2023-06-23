package org.example;

public class Referee {
    Rule rule = new Rule();
    Player player = new Player();

    public void playGame(){
        rule.makeResult();
        while(true){
            rule.countAdd();
            player.registAnswer(askAnswer());
            boolean success = rule.resultCheck(player.getAnswer());
            System.out.println(rule.getPrintValue());
            if(success){
                break;
            }else if (rule.getCount() >= 7){
                System.out.println("게임 횟수를 초과 하였습니다.");
                break;
            }
        }
    }
    public String askAnswer(){
        System.out.println("1 ~ 9까지의 자연수 3개를 입력하세요");
        String answer = player.sayAnwser();
        while (rule.answerCheck(answer)){
            System.out.println("다시 1 ~ 9까지의 자연수 3개를 입력하세요");
            answer = player.sayAnwser();
        }
        return answer;
    }

}
