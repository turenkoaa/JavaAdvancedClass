package com.db.heroes.character;

import com.db.heroes.KickResult;
import lombok.Data;

@Data
public abstract class Character {
    protected int power;
    protected int hp;

    public Character(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    public Character() {
        initState();
    }

    protected abstract void initState();

    public void decreasePower(int i){
        power-=i;
    }

    public void decreaseHp(int i){
        hp-=i;
    }

    public void toCty() {
        System.out.println(this.getClass().getSimpleName() + " cry: aaa");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public abstract KickResult kick(Character enemy);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{power=" + power +
                ", hp=" + hp +
                '}';
    }
}