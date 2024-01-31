package effectivejava.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineWithDefault {
    /**
     * try-with-resources中依然可以使用catch,通常用catch处理默认值
     *
     * @param path
     * @param defaultVal
     * @return
     */
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
    }
}
