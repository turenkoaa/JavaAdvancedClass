package com.db.heroes.character;

import com.db.heroes.KickResult;

public class Hobbit extends Character {

    @Override
    protected void initState() {
        hp = 3;
        power = 0;
    }

    public KickResult kick(Character enemy) {
        enemy.toCty();
        return KickResult.builder().build();
    }

}
