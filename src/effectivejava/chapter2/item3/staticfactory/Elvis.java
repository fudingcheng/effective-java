package effectivejava.chapter2.item3.staticfactory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用静态工厂实现单例
 */
public class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        /**
         * 通过反射可以破坏单例的唯一性
         */
        System.out.println("-----------------");
        Class<?> clazz = Class.forName("effectivejava.chapter2.item3.staticfactory.Elvis");
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
