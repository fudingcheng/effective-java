package effectivejava.chapter2.item4;

// Noninstantiable utility class (Page 19)
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    // 如果要避免调用者创建构造器,那就要显示的把构造器私有化
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
