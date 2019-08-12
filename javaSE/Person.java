package javaSE;

/**
 * Created by futuration on 2019/7/31.
 */
public class Person {
    public static int count = 0;
    public Person(){
        count++;
    }
    public static int getCount(){
       return count;
    }

}
