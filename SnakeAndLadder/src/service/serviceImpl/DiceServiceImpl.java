package service.serviceImpl;

import module.Dice;
import service.DiceService;

import java.util.concurrent.ThreadLocalRandom;

public class DiceServiceImpl implements DiceService {

    Dice dice;

    public DiceServiceImpl(Dice dice){
        this.dice = dice;
    }

    @Override
    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(dice.getMinValue(),dice.getMaxValue()+1);
    }
}
