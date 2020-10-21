package moduleThree.task1;

public class StringTest
{
    public static void main(String[] args) {
        System.out.println("一、编程统计字符串\"ABCD123!@#$%ab\"中大写字母、小写字母、数字、其它字符的个数并打 印出来。");
//        1、定义一个字符串
        String s1 = "ABCD123!@#$%ab";
//        2、定义统计变量、和存储StringBuilder
        Integer bigCount = 0;
        Integer samllCount = 0;
        Integer numberCount = 0;
        Integer otherCount = 0;

        StringBuilder bigChars = new StringBuilder();
        StringBuilder smallChars = new StringBuilder();
        StringBuilder numberChars = new StringBuilder();
        StringBuilder otherChars = new StringBuilder();
//        3、将字符串转到字符数组
        char[] chars = s1.toCharArray();

//        4、循环统计大写字母、小写字母、数字、其它字符的个数并打 印出来
        for (int x=0;x<s1.length();x++) {
            if (Character.isUpperCase(chars[x])){
                bigCount++;
                bigChars.append(chars[x]);
                System.out.println("发现大写字母"+chars[x]+"，目前大写字母已有"+bigCount+"个");
            }else if(Character.isLowerCase(chars[x])){
                samllCount++;
                smallChars.append(chars[x]);
                System.out.println("发现大写字母"+chars[x]+"，目前小写字母已有"+samllCount+"个");
            }else if(Character.isDigit(chars[x])){
                numberCount++;
                numberChars.append(chars[x]);
                System.out.println("发现大写字母"+chars[x]+"，目前数字已有"+numberCount+"个");
            }else {
                otherCount++;
                otherChars.append(chars[x]);
                System.out.println("发现大写字母"+chars[x]+"，目前其他字符已有"+otherCount+"个");
            }
        }
        System.out.println("--循环结束--，最终结果：");
        System.out.println("大写字母个数:"+bigCount+" ，大写字母分别是："+bigChars);
        System.out.println("大写字母个数:"+samllCount+" ，大写字母分别是："+smallChars);
        System.out.println("大写字母个数:"+numberCount+" ，大写字母分别是："+numberChars);
        System.out.println("大写字母个数:"+otherCount+" ，大写字母分别是："+otherChars);

    }
}
