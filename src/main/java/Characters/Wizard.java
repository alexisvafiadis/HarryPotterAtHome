package Characters;

import Extras.Pet;
import Game.Game;
import Houses.Gryffindor;
import Houses.House;
import Houses.Slytherin;
import Potions.Potion;
import Spells.Spell;
import Wands.Wand;

import java.util.List;

public class Wizard extends Character{
    Pet pet;
    Wand wand;
    House house;
    List<Spell> knownSpells;
    List<Potion> potions;
    double HP;
    Game game;
    double DEFAULT_DAMAGE = 10;
    double MAX_HP = 100;
    double DEFAULT_ACCURACY;

    double DEFAULT_DAMAGE_RESISTANCE;
    String name;

    public Wizard(Game game) {
        this.game = game;
    }

    public void attack(Character character, Spell spell) {
        double damage = 0;
        if (house instanceof Slytherin) {
            damage = damage * ((Slytherin) house).getDamageMultiplier();
        }
        character.damage(damage);
    }

    public double defend(double damage) {
        if (house instanceof Gryffindor) {
            return damage * ((Gryffindor) house).getDamageResistance();
        }
        else {
            return damage;
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void addSpell(Spell spell) {
        this.knownSpells.add(spell);
    }

    public void addPotion(Potion potion) { this.potions.add(potion); }

    public void addPotions(Potion potion, int amount) {
        for (int i = 0; i < amount; i++) {
            this.potions.add(potion);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void upgradeDamage(double upgrade) {
        game.announceReward("Your damage has been upgraded!");
        DEFAULT_DAMAGE += upgrade;
    }

    public void upgradeHP(double upgrade) {
        game.announceReward("Your HP has been upgraded!");
        MAX_HP += upgrade;
    }

    public void upgradeAccuracy(double upgrade) {
        game.announceReward("Your accuracy has been upgraded!");
        DEFAULT_ACCURACY += upgrade;
    }

    public void upgradeResistance(double upgrade) {
        game.announceReward("Your resistance has been upgraded!");
        DEFAULT_DAMAGE_RESISTANCE += upgrade;
    }

    public double getDamage() {
        return DEFAULT_DAMAGE;
    }

    public double getAccuracy() {
        return DEFAULT_ACCURACY;
    }

    public double getResistance() {
        return DEFAULT_DAMAGE_RESISTANCE;
    }

    public void consumePotion(Potion potion) {
        int potionIndex = potions.indexOf(potion);
        potions.get(potionIndex).use();
        potions.remove(potion);
    }

    public void heal(double hp_restore) {
        HP = HP + hp_restore;
    }

    @Override
    public void attack(Character victim) {

    }

    @Override
    public void die() {
        game.getCurrentLevel().fail();
        game.getCurrentLevel().start();
    }

    @Override
    public double getMAX_HP() {
        return MAX_HP;
    }
}
