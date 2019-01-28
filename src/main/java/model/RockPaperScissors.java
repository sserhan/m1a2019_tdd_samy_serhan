package main.java.model;

public class RockPaperScissors {

    public RockPaperScissors() {
    }

    public Result play(RPSEnum p1, RPSEnum p2){
        if(p1.equals(RPSEnum.PAPER)){
            if(p2.equals(RPSEnum.ROCK))
                return Result.WIN;
            if(p2.equals(RPSEnum.SCISSORS))
                return Result.LOST;
            else
                return Result.TIE;
        }
        if(p1.equals(RPSEnum.ROCK)){
            if(p2.equals(RPSEnum.ROCK))
                return Result.TIE;
            if(p2.equals(RPSEnum.SCISSORS))
                return Result.WIN;
            else
                return Result.LOST;
        }
        if(p2.equals(RPSEnum.ROCK))
            return Result.LOST;
        if(p2.equals(RPSEnum.SCISSORS))
            return Result.TIE;
        else
            return Result.WIN;
    }

    public Result play(Joueur j1, Joueur j2){
        return Result.LOST;
    }
}
