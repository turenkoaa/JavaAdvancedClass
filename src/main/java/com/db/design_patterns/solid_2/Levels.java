package com.db.design_patterns.solid_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Autowired
public @interface Levels {
    Level level();
}
