package com.atguigu.test.day4.generic;

import com.atguigu.java.day4.generic.Chopsticks;
import com.atguigu.java.day4.generic.KnifeAndFork;
import com.atguigu.java.day4.generic.Noodle;
import com.atguigu.java.day4.generic.Rice;
import com.atguigu.java.day4.generic.Soup;
import com.atguigu.java.day4.generic.Spoon;

public class Bowl<Food> {
    private Food food;

    public Bowl(Food food) {
        this.food = food;
    }

    public void contain(Food food) {
        System.out.println("碗里装的是：" + food);
    }

    public <Tool> boolean foodTool(Tool tool) {

        if (this.food instanceof Rice && tool instanceof Chopsticks) return true;

        if (this.food instanceof Noodle && tool instanceof KnifeAndFork) return true;

        if (this.food instanceof Soup && tool instanceof Spoon) return true;

        return false;
    }
}
