package com.example.deneme;

import android.app.Activity;

public class fight {

    public String War(WarriorStat warrior, Object enemy, int level) {
        if (enemy.getClass() == goblin.class) {
            return "Goblin";
        }
        if (enemy.getClass() == skeleton.class) {
            return "Skeleton";
        }
        if (enemy.getClass() == orc.class) {
            return "Orc";
        }
        return  null;
    }
}