package effectivejava.chapter2.item3.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用静态域实现单例模式
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();;

    private Elvis() {

    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis1 = Elvis.INSTANCE;
        System.out.println(elvis1);
        elvis1.leaveTheBuilding();

        System.out.println("--------");

        /**
         * 反射可以破坏单例性
         */
        Class<?> clazz = Class.forName("effectivejava.chapter2.item3.field.Elvis");
        Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Elvis elvis2 = (Elvis) constructor.newInstance(null);
        System.out.println(elvis2);
        elvis2.leaveTheBuilding();

    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}