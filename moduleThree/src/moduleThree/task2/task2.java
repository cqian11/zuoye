package moduleThree.task2;

public class task2 {
    public static void main(String[] args) {
        /*2. 编程题
        编程获取两个指定字符串中的最大相同子串并打印出来。
        如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
        提示： 将短的那个串进行长度依次递减的子串与较长的串比较。*/
        System.out.println("2. 编程题 编程获取两个指定字符串中的最大相同子串并打印出来。");
        System.out.println("【比较结果】最大相同子串结果是："+compareString("asdafghjka","aaasdfg"));


    }

    public static String compareString(String s1,String s2){
        //1、判断两个字符串谁长，谁短；
        String max = "";
        String min = "";
        max = (s1.length()>s2.length())?s1:s2;
        min = (max==s1)?s2:s1;

        //2、循环获取短串中的子串，并和长串做比较

        System.out.println("【打印中间过程】");

        for(int x=0;x<min.length();x++){
            //2.1短串长度的偏移量
            System.out.println(" 子串长度："+(min.length()-x));

            for(int y=0,z=min.length()-x;z!=min.length()+1;y++,z++){
                System.out.println("  子串起始坐标："+y);
                //2.2从短串起始位置开始累加，按偏移量获取子串
                String temp = min.substring(y,z);
                System.out.println("  当前子串："+temp);
                //2.3、判断长串是否包含子串
                if(max.contains(temp)) return temp;
            }

        }
        return null;
    }
}
