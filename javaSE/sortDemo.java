package javaSE;

import java.util.Arrays;

/**
 * Created by futuration on 2019/8/5.
 */
public class sortDemo {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog("xiaoming",22),new Dog("alan",11),new Dog("zex",99)};
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));

    }
}

class Dog implements Comparable<Dog>{
    String name;
    int age;

    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return this.name + "," + this.age;
    }
    @Override
    public int compareTo(Dog dog) {
        return this.age - dog.age;
    }

}