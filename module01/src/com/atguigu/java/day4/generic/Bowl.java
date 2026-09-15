package com.atguigu.java.day4.generic;

/**
 * 泛型：针对主类型进行辅助、补充描述的泛类型
 * 基本语法：先声明再使用
 * 泛型的声明：Bowl<Food> 在<>中就是我们声明的泛型；在类上声明的泛型，在类范围内可用
 * @param <Food>
 */
public class Bowl<Food> {

    // 上面声明了泛型类型，这里就可以使用了
    private Food food;

    public Bowl(Food food) {
        this.food = food;
    }

    public void contain(Food food) {
        System.out.println("碗里装的是：" + food);
    }

    /**
     * 泛型方法：在方法声明的位置声明泛型
     * 声明之后，就可以在方法范围内使用这个泛型类型
     * 泛型类型是一个不确定的类型，方法实际调用时才知道具体是什么类型
     * @param tool
     * @return
     * @param <Tool>
     */
    public <Tool> boolean foodTool(Tool tool) {

        if (this.food instanceof Rice && tool instanceof Chopsticks) return true;

        if (this.food instanceof Noodle && tool instanceof KnifeAndFork) return true;

        if (this.food instanceof Soup && tool instanceof Spoon) return true;

        return false;
    }
}
