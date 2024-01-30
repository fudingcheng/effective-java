package effectivejava.chapter2.item6;

import java.util.Comparator;

/**
 * 不要创建不必要的对象
 */
public class Sum {
    private static long sum() {
        // 如果用Long,则每次都创建一个新的Long对象,这是没有必要的,大大影响了性能
        // 数字运算时,能用基本类型就尽量用基本类型
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = 6;
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}