package org.example;

public class Referee {
    Rule rule ;
    private int[] result;

    RefereeResult refereeResult = new RefereeResult();
    public Referee(Rule rule) {
        this.rule = rule;
    }
    public void setResult(int[] result) {
        this.result = result;
    }

    public void playGame(Count count, Player player){
        while(this.refereeResult.getStatus() == Status.CONTINUED){
//            player.playerSayAnswer();
            checkResult(count, player.getAnswer());
            count.countAdd();
        }
    }
    public String playGame(Player player){
            return checkResult(player.getAnswer());
    }
    public String playGame(int[] answer){
            return checkResult(answer);
    }
    public void checkResult(Count count, int[] answer){
        if (count.isCountOver()){
            this.refereeResult.setStatus(Status.OUT);
        }
        this.refereeResult = rule.resultCheck(this.result, answer, refereeResult);
    }
    public String checkResult(int[] answer){
        return rule.resultCheck(this.result, answer);
    }

}
