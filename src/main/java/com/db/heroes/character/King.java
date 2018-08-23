package com.db.heroes.character;

import com.db.heroes.KickResult;
import com.db.heroes.factory.RandomFactory;
import com.db.heroes.strategy.Weapon;
import com.db.heroes.strategy.Sword;
import lombok.AccessLevel;
import lombok.Setter;

public class King extends Character {

    @Setter(AccessLevel.PROTECTED)
    private Weapon weapon = new Sword();

    @Override
    protected void initState() {
        hp = RandomFactory.getInstance().getRandomBetween(5, 15);
        power = RandomFactory.getInstance().getRandomBetween(5, 15);
    }

    public KickResult kick(Character enemy) {
        return weapon.kick(this, enemy);
    }

}
