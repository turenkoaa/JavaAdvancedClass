package com.db.reflection;

public class DBService {

    private int z;

    @RunThisMethod(repeat = 3)
    public void doX(){
        System.out.println("XXXXXXXX");
    }

    public void runABC() {
        System.out.println("ABC");
    }

    public void runZ() {
        System.out.println(z);
    }

}
