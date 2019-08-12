package javaSE;

import java.io.*;

/**
 * Created by futuration on 2019/8/5.
 */
public class streamDemo {
    public static void main(String[] args) {
        System.out.write('A');
        System.out.write('\n');

        /**
         * 从控制台读取字符串
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        System.out.println("请输入一行文字");
        System.out.println("输入end结束输入");
        do {
            try {
                s = bf.readLine();
                System.out.println(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (!s.equals("end"));

    }
}

/**
 * 文件的写入和读取
 */
class  fileTest{
    public static void main(String[] args) {
        File f = new File("C:\\Users\\futuration\\Desktop\\a.txt");
        try {
            /**
             * 文件的输出
             */
            FileOutputStream fos = new FileOutputStream(f);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write("我是中国人\r\n");
            osw.write("我骄傲\n\r");
            osw.write("祖国");
            osw.close();
            fos.close();

            /**
             * 文件的读取
             */
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            StringBuilder sb = new StringBuilder();
            while (isr.ready()){
                sb.append((char)isr.read());
            }
            System.out.print(sb.toString());
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
