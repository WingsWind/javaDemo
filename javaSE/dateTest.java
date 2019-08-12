package javaSE;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by futuration on 2019/8/5.
 */
public class dateTest {
    public static void main(String[] args) {
        /**
         * 获取当前显示时间
         */
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toString());

        /**
         * 格式化日期
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E D");
        System.out.println("当前时间："+ simpleDateFormat.format(date));
        System.out.println("当前时间："+ simpleDateFormat2.format(date));

    }
}
