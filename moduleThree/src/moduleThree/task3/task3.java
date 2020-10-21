package moduleThree.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class task3 {
    /*
    3. 编程题
 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 如：
        123 出现了 2 次
        456 出现了 2 次
        789 出现了 1 次
    * */
    public static void main(String[] args) {
        System.out.println("3、编程题 准备一个 HashMap 集合，统计字符串\"123,456,789,123,456\"中每个数字字符串出现的次数并打印出来。");
        getNumtoMap("123,456,789,123,456");

    }
    public static void getNumtoMap(String s1){

        //1、准备一个HashMap集合
        Map<String,Integer> numMap = new HashMap<>();
        //2、split方法对原始字符串按照字符串中的，拆分字符串，并在集合中查找
        String[] arr = s1.split(",");
        for(int i=0;i<arr.length;i++){
            //3、若集合中没有该字符串，则将该字符串和1组成键值对放入集合中
            if(!numMap.containsKey(arr[i])){
                numMap.put(arr[i],1);
            }else {
                //4、若集合中已有该字符，取出该字符的value，加1后放入
                numMap.put(arr[i],numMap.get(arr[i])+1);
            }

        }
        System.out.println("转换成的HashMap= "+numMap);
        //5、获取map集合中所有的映射关系组成set集合并遍历
        Set<Map.Entry<String,Integer>> set1 = numMap.entrySet();
        for(Map.Entry<String,Integer> element:set1){
//            System.out.println(element);
            System.out.println(element.getKey() + "出现次数："+ element.getValue());
        }


    }



}
