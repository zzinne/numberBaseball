package org.example;

public class Referee {
    public Referee(Rule rule) {
        this.rule = rule;
    }

    Rule rule ;
    private int[] result;

    private int[] answer;
    RefereeResult refereeResult = new RefereeResult();
    public void setResult(int[] result) {
        this.result = result;
    }

    public void playGame(Count count, Player player){
        while(this.refereeResult.getStatus() == Status.CONTINUED){
            player.sayAnwser();
            checkResult(count, player.getAnswer());
            count.countAdd();
        }
    }
    public void checkResult(Count count, int[] answer){
        if (count.isCountOver()){
            this.refereeResult.setStatus(Status.OUT);
        }
        this.refereeResult = rule.resultCheck(this.result, answer, refereeResult);
    }



}
