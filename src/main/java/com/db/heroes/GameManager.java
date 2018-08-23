package com.db.heroes;

import com.db.heroes.character.Character;
import com.db.heroes.factory.*;

public class GameManager {

    public void fight() {
        CharacterFactory characterFactory = new CharacterFactory();
        Character character1 = characterFactory.createCharacter();
        Character character2 = characterFactory.createCharacter();

        while (character1.isAlive() && character2.isAlive()) {
            System.out.println("Fight:");
            System.out.println("Start: " + character1.toString() + " vs " + character2.toString());
            character1.kick(character2);
        }

        Character winner = character1.isAlive() ? character1 : character2;
        System.out.println("\nResult: " + character1.toString() + " vs " + character2.toString());
        System.out.println("Winner: " + winner);
    }

    public static void main(String[] args) {
        new GameManager().fight();
    }
}