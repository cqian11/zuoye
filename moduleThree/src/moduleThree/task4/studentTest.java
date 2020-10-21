package moduleThree.task4;

import java.util.ArrayList;
import java.util.Scanner;

public class studentTest {
    /*4. 编程题
 使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
    * */
    public static void main(String[] args) {
        //1、定义一个集合存放学生信息
        ArrayList<student> arryList = new ArrayList<>();

        //2、定义界面操作
        while(true){
            System.out.println("----欢迎使用学生管理系统----");
            System.out.println("1、添加学生信息");
            System.out.println("2、删除学生信息");
            System.out.println("3、修改学生信息");
            System.out.println("4、查找学生信息");
            System.out.println("5、退出");
            System.out.println("请输入选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line){
                case "1":
                    System.out.println("操作添加学生信息");
                    operation.addStudent(arryList);
                    break;
                case "2":
                    System.out.println("操作删除学生信息");
                    operation.removeStudent(arryList);
                    break;
                case "3":
                    System.out.println("操作修改学生信息");
                    operation.changeStudent(arryList);
                    break;
                case "4":
                    System.out.println("操作查找学生信息");
                    operation.findStudent(arryList);
                    break;
                case "5":
                    System.out.println("将退出操作");
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}
