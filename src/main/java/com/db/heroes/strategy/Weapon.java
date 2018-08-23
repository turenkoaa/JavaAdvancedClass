package com.db.heroes.strategy;

import com.db.heroes.KickResult;
import com.db.heroes.character.Character;

public interface Weapon {
    KickResult kick(Character character1, Character character2);
}
