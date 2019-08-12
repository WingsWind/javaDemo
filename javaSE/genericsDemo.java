package javaSE;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于泛型的练习
 * Created by futuration on 2019/8/7.
 */
public class genericsDemo {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{1,2,3,4};
        String[] strArray = new String[]{"xiao","ming","zhong","guo"};
        Double[] douArray = new Double[]{1.2, 2.444, 4.4223};
        printArray(intArray);
        printArray(strArray);
        printArray(douArray);
        System.out.println("==============================");
        System.out.println(getMaxElement("string","zabdcdef","mark"));
        System.out.println("==============================");
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<>();
        integerBox.add(666);
        stringBox.add("我爱中国");
        System.out.println(integerBox.get());
        System.out.println(stringBox.get());
        System.out.println("==============================");
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        integers.add(222);
        strings.add("我是中国人，我爱我的祖国");
        doubles.add(333.222);
        getData(integers);
        getData(strings);
        getData(doubles);


    }


    /**
     * 泛型方法
     * 泛型当作方法的形式参数
     * @param <E> 必须声明在方法返回值之前
     */
    public static <E> void printArray(E[] imputArray){
        for (E element :
                imputArray) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
    /**
     * extends 可以用来限制泛型的上届
     *          也可以用来实现接口
     */
    public static <T extends Comparable<T>> T getMaxElement(T x, T y, T z){
        T max = x;
        if (max.compareTo(y) < 0){
            max = y;
        }
        if(max.compareTo(z) < 0){
            max = z;
        }
        return max;
    }

    /**
     * 通配符？的使用
     * @param data
     */
    public static void getData(List<?> data){
        System.out.println("data: "+data.get(0));
    }

}

/**
 * 泛型类
 * @param <T> 这里的T 就像String , Integer等类型一样
 */
class Box<T> {
    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return this.t;
    }

}