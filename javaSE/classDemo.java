package javaSE;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by futuration on 2019/8/1.
 */
public class classDemo {
    public static void main(String[] args) {
        Class stuClass = Student.class;
        try {
            Object stu = new Student();
            Field f = stuClass.getField("name");
           System.out.println("获取字段名称: "+f.getName());
           System.out.println("获取字段值: "+f.get(stu));
            System.out.println(stuClass.getDeclaredField("id"));
            Method m = stuClass.getMethod("acceptName");
            m.invoke(stu);
           System.out.println(""+m.getName());
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
class Student{
    private int id;
    public String name = "xiao ming";

    public String acceptName(){
        System.out.print(this.name + "正在学习中...\n");
        return this.name;
    }
    private void setNum(int i){
        this.id = i;
    }
}