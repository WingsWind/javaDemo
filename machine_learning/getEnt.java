package machine_learning;

import java.util.*;

/**
 * Created by futuration on 2019/8/6.
 * 计算连续值增益
 */
public class getEnt {
    static Map<Double,Boolean> positiveMap = new TreeMap<>();//正数集合的数量
    static Map<Double,Boolean> negativeMap = new TreeMap<>();//负数集合的数量

    public static void main(String[] args) {
        double[] goodData = new double[]{0.679,0.774,0.634,0.608,0.556,0.403,0.481,0.437};
        double[] badData = new double[]{0.666,0.243,0.245,0.343,0.639,0.657,0.360,0.593,0.719};
        Map<Double,Boolean> map = new TreeMap<>();//TreeMap默认按照升序排列
        int sum;//总数据的长度
        /**
         * 将好瓜的数据读取到map中
         */
        for (int i = 0; i < goodData.length; i++) {
            map.put(goodData[i],true);
        }
        /**
         * 将坏瓜的数据读取到map中
         */
        for (int i = 0; i < badData.length; i++) {
            map.put(badData[i],false);
        }
        /**
         * 计算出划分点Ta 数组
         */
        sum = map.size();
        double[] Ta = new double[16];
        Set<Double> keySet = map.keySet();
        Object[] objects = keySet.toArray();
        for (int i = 0; i < objects.length - 1; i++) {
            double tmp = ((double)objects[i] + (double)objects[i+1]) / 2;
            Ta[i] = Math.floor(tmp*1000)/1000;
        }
//        System.out.println(Arrays.toString(T));
//        System.out.println(Arrays.toString(objects));
        for (int i = 0; i  < Ta.length ; i++) {
            /**
             * 计算每个划分点的信息增益
             */
            for (int j = 0; j < objects.length; j++) {
                if (((double)objects[j] - Ta[i]) < 0){
                    negativeMap.put((double)objects[j],map.get(objects[j]));
                }else {
                    positiveMap.put((double)objects[j],map.get(objects[j]));
                }
            }

            System.out.println("第" + (i+1) + "分割点," + "分割点值为："+Ta[i]);
            System.out.print("负组分组情况：");
            getEnt.printMap(negativeMap);
            System.out.println();
            System.out.print("正组分组情况：");
            getEnt.printMap(positiveMap);
            System.out.println();
            System.out.println();
            System.out.println("负组信息熵：" + getEnt.calcEnt(negativeMap));
            System.out.println("正组信息熵：" + getEnt.calcEnt(positiveMap));
            System.out.println("总信息熵：" + getEnt.calcEnt(map));
            System.out.println();

            double gain = getEnt.calcEnt(map)-1.0*(i+1)/sum*getEnt.calcEnt(negativeMap)-1.0*(sum-1-i)/sum*getEnt.calcEnt(positiveMap);
            System.out.println("信息增益："+gain);
            System.out.println("=============================================================================================");

            negativeMap.clear();
            positiveMap.clear();
        }


//        getEnt.printMap(map);
    }

    /**
     * 打印map中的数据
     */
    public static void printMap(Map map){
        Set set = map.keySet();
        for (Object s :
                set) {
            System.out.print("{"+s+":"+map.get(s)+"} ");
        }
    }
    /**
     * 计算增益Ent
     */
    public static double calcEnt(Map map){
        int m = 0;//好瓜数量
        int n = 0;//坏瓜的数量
        double answer = 0;
        for (Object b :
                map.values()) {
            if ((boolean)b == true){
                m++;
            }else {
                n++;
            }
        }
        double posi =  1.0*m/(m+n);
        double nega = 1.0*n/(m+n);
        if (posi != 0 && nega != 0){
            answer = posi * Math.log(posi)/Math.log(2) + nega * Math.log(nega)/Math.log(2);
        }else if (posi == 0){
            answer = nega * Math.log(nega)/Math.log(2);
        }else {
            answer = posi * Math.log(posi)/Math.log(2);
        }

        if (answer < 0){
            return (-1)*answer;
        }else {
            return answer;
        }
    }
}
