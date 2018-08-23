package com.db.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Human implements Serializable {
    private String name;
    private transient int age;
}
