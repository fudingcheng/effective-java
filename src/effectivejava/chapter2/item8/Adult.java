package effectivejava.chapter2.item8;

// Well-behaved client of resource with cleaner safety-net (Page 33)
public class Adult {
    public static void main(String[] args) {
        /**
         * 使用try-with-resources方式,会调用api的close方法
         */
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
