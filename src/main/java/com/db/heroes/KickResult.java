package com.db.heroes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KickResult {
    private int hpDamage;
    private int powerDamage;
}