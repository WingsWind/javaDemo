package javaSE;

import java.io.*;

/**
 * Created by futuration on 2019/8/8.
 */
public class serializeDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "xiao wang";
        employee.address = "shang hai";
        employee.SSN = 222333;
        employee.number = 1001;

        try {
            /**
             * 序列化
             */
            FileOutputStream fileOutputStream = new
                    FileOutputStream("C:\\Users\\futuration\\Desktop\\employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in Desktop");
            System.out.println("===============================");
            /**
             * 反序列化
             */
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\futuration\\Desktop\\employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Employee e = (Employee)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("name: "+e.name);
            System.out.println("address: "+e.address);
            System.out.println("SSN: "+e.SSN);
            System.out.println("number: "+e.number);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Employee implements Serializable{
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck(){
        System.out.println("Mail a check to "+name+" "+address);
    }
}