package com.db.serialize;

import lombok.SneakyThrows;

import java.io.*;

public class MainToWrite {

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("C:\\Users\\JavaStudent\\Desktop\\file.txt");
        if (file.exists()){
            file.delete();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new Human("Oleg", 21));

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Human o = (Human) ois.readObject();

        System.out.println(o);


    }
}
