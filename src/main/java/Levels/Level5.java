package Levels;

import Characters.Wizard;
import Game.Game;

public class Level5 extends Level{
    Wizard player;
    final String place = "Chamber of Secrets";
    Game game;

    public Level5(Game game) {
        super(game);
    }

    public void start() {
        introduce(player);

    }

    @Override
    public void conclude(Wizard wizard) {
        game.congratulate("Well done, you have defeated Dolores Ombrage!");
        askForUpgrade();
    }

    @Override
    public void introduce(Wizard wizard) {
        game.displayInfo("You have to fight ");
        game.displayInfo("In order to do that, you have to use the spell Accio.");
        if (player.getHouse().toString().equals("Gryffindor")) {
            game.announceReward("You have been given the spell Accio.");
            //player.addSpell();
        }
        game.displayInfo("Good luck!");
    }

    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
