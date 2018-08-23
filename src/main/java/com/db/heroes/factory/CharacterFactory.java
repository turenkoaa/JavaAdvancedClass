package com.db.heroes.factory;

import com.db.heroes.character.Character;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CharacterFactory {

        private List<Class<? extends Character>> characterClasses = new ArrayList<>();

        public CharacterFactory() {
                Reflections scanner = new Reflections("com.db.heroes");
                Set<Class<? extends Character>> set = scanner.getSubTypesOf(Character.class);
                for (Class<? extends Character> clazz : set) {
                        if (!Modifier.isAbstract(clazz.getModifiers())) {
                                characterClasses.add(clazz);
                        }
                }
        }

        @SneakyThrows
        public  Character createCharacter() {
                int index = RandomFactory.getInstance().getRandomBetween(0, characterClasses.size() - 1);
                return characterClasses.get(index).newInstance();
        }
}
