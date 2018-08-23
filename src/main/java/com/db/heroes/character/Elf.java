package com.db.heroes.character;

import com.db.heroes.KickResult;

public class Elf extends Character {

    @Override
    protected void initState() {
        hp = 10;
        power = 10;
    }

    public KickResult kick(Character enemy) {
        KickResult.KickResultBuilder builder = KickResult.builder();
        if (enemy.getPower() < this.getPower()) {
            int damage = enemy.getHp();
            enemy.decreaseHp(damage);
            builder.hpDamage(damage);
        } else {
            enemy.decreasePower(1);
            builder.powerDamage(1);
        }
        return builder.build();
    }

}
