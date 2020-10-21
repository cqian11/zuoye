package moduleThree.task4;

import java.util.ArrayList;
import java.util.Scanner;


public class operation {

    //1、输入学号
    public static String inID(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        String sid = scanner.nextLine();
        return sid;
    }

    //2、增加、删除、修改、查找操作方法

    public static void addStudent(ArrayList<student> arryList){

        //判断学号是否存在，存在返回添加失败，不存在添加信息到集合
        if(arryList.size()==0){
            String sid = inID();
            //获取输入的学生id
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生姓名：");
            String name = scanner.nextLine();
            System.out.println("请输入学生年龄：");
            String age = scanner.nextLine();
            student sd = new student();
            sd.setId(sid);
            sd.setName(name);
            sd.setAge(age);
            arryList.add(sd);
            System.out.println("添加学生信息成功，添加信息为："+sd.getId()+"\t"+sd.getName()+"\t"+sd.getAge());
        }else {
            String sid = inID();
            //获取输入的学生id
            for (student element:arryList) {
                if(element.getId().equals(sid)){
                    System.out.println("学号重复，学生信息添加失败");
                    break;
                }else {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.println("请输入学生年龄：");
                    String age = scanner.nextLine();
                    student sd = new student();
                    sd.setId(sid);
                    sd.setName(name);
                    sd.setAge(age);
                    arryList.add(sd);
                    System.out.println("添加学生信息成功，添加后信息为："+element.getId()+"\t"+element.getName()+"\t"+element.getAge());
                    break;
                }
            }
        }


    }


    public static void removeStudent(ArrayList<student> arryList){

        if(arryList.size()==0){
            System.out.println("信息系统无数据可删除");
        }else{
            String sid = inID();
            //获取输入的学生id
            int q = 1;
            //判断学号是否存在，存在的删除，不存在的返回删除失败
            for (student element:arryList) {

                if(element.getId().equals(sid)){
                    arryList.remove(element);
                    System.out.println("删除学生信息成功");
                    System.out.println("目前的学生信息为：学号"+"\t"+"姓名"+"\t"+"年龄");
                    for (student elementSub:arryList) {
                        System.out.println(elementSub.getId()+"\t"+elementSub.getName()+"\t"+elementSub.getAge());
                    }
                    break;
                }
                else {
                    q++;
                    if (q==arryList.size()){
                        System.out.println("学生信息中无此学号");
                    }
                }

            }
        }

    }

    public static void changeStudent(ArrayList<student> arryList){

        if(arryList.size()==0){
            System.out.println("信息系统无可修改数据");
        }else {
            String sid = inID();
            //获取输入的学生id
            //学号存在的更新学生信息，学号不存在的更新失败
            int q = 1;
            for (student element:arryList) {
//                System.out.println("查询的学号："+element.getId());

                if(element.getId().equals(sid)){
                    System.out.println("请输入学生要修改的信息");
                    System.out.println("1 学号");
                    System.out.println("2 姓名");
                    System.out.println("3 年龄");
                    Scanner scanner = new Scanner(System.in);
                    String num = scanner.nextLine();
                    System.out.println("请输入修改后的内容：");
                    String studentData = scanner.nextLine();
                    switch (num){
                        case "1":
                            element.setId(studentData);
                            System.out.println("修改成功！修改后信息为："+element.getId()+"\t"+element.getName()+"\t"+element.getAge());
                            break;
                        case "2":
                            element.setName(studentData);
                            System.out.println("修改成功！修改后信息为："+element.getId()+"\t"+element.getName()+"\t"+element.getAge());
                            break;
                        case "3":
                            element.setAge(studentData);
                            System.out.println("修改成功！修改后信息为："+element.getId()+"\t"+element.getName()+"\t"+element.getAge());
                            break;
                        default:
                            break;
                    }
                }
                else {
                    q++;
                    if (q==arryList.size()){
                        System.out.println("学生信息中无此学号");
                    }
                }


            }
        }



    }


    public static void findStudent(ArrayList<student> arryList){
        //1、如果长度为空
        if(arryList.size()==0){
            System.out.println("学生信息系统无数据");
        }else {
            System.out.println("学生信息为：学号"+"\t"+"姓名"+"\t"+"年龄");
            for (student element:arryList) {
                System.out.println(element.getId()+"\t"+element.getName()+"\t"+element.getAge());
            }
        }
    }
}
