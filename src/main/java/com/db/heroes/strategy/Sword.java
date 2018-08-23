package com.db.heroes.strategy;

import com.db.heroes.KickResult;
import com.db.heroes.factory.RandomFactory;
import com.db.heroes.character.Character;

public class Sword implements Weapon {
    @Override
    public KickResult kick(Character character1, Character character2) {
        int hdDamage = RandomFactory.getInstance().getRandomBetween(0, character1.getPower());
        character2.decreaseHp(hdDamage);
        return KickResult.builder()
                .hpDamage(hdDamage)
                .build();
    }
}
