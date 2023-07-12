package org.example;

public class Referee {


    Rule rule ;
    private int[] result;
    Validater validater = new Validater();
    RefereeResult refereeResult = new RefereeResult();
    public Referee(Rule rule) {
        this.rule = rule;
    }
    public void setResult(int[] result) {
        this.result = result;
    }

    public void playGame(Count count, Player player){
        while(this.refereeResult.getStatus() == Status.CONTINUED){
            playerSayAnswer(player);
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
    public void playerSayAnswer(Player player){
        while(validater.validationAnswer(player.sayAnwser(), player)){
            break;
        }

    }

}
