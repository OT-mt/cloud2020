import java.time.ZonedDateTime;

public class T1 {
    public static void main(String[] args) {
        ZonedDateTime z = ZonedDateTime.now();// 默认时区
        System.out.println(z);
    }
}
