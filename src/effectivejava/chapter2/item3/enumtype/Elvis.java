package effectivejava.chapter2.item3.enumtype;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用枚举是创建单例最好的方式
 */
// Enum singleton - the preferred approach (Page 18)
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        /**
         * 枚举不支持反射, 此种方式会报错.
         * 所以,枚举是实现单例最好的方式
         */
//        System.out.println("-----------------");
//        Class<?> clazz = Class.forName("effectivejava.chapter2.item3.enumtype.Elvis");
//        Constructor<?> constructor = clazz.getDeclaredConstructors()[0];
//        constructor.setAccessible(true);
//        Elvis elvis2 = (Elvis) constructor.newInstance(null);
//        System.out.println(elvis2);
//        elvis2.leaveTheBuilding();

    }


}
