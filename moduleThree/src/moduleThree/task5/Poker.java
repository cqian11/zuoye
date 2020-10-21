package moduleThree.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

//斗地主游戏
public class Poker {

    //创建一个HashMap集合，键对应牌的编号Integer类型，值对应牌的大小String类型
    private HashMap<Integer,String> hashmap;
    //创建一个ArrayList集合，存储牌的编号
    private ArrayList<Integer> pokerList;
    //创建牌的花色数组
    private String[] colors;

    //创建牌的大小数组
    private String[] numbers;


    public Poker(ArrayList<Integer> pokerList, String[] colors, String[] numbers, HashMap<Integer, String> hashmap) {
        this.pokerList = pokerList;
        this.colors = colors;
        this.numbers = numbers;
        this.hashmap = hashmap;
    }

    public void fiftyfive(){
        //索引从0开始向hashmap集合中存储牌的编号的大小，向arraylist集合中存储牌的编号
        int index=0;
        //我们玩的是斗地主，所以别忘了还有大小王哦！！！
        hashmap.put(index,"大王");//存入大王
        pokerList.add(index);//大王对应的编号
        index++;//编号加1
        hashmap.put(index,"小王");//存入小王
        pokerList.add(index);//小王对应的编号
        index++;//编号加1

        for(String number : numbers) {
            for(String color : colors) {
                //使用String类的concat()方法连接字符串，显然是将牌的大小连接到花色后面
                String poker=color.concat(number);//例如：color 红桃 + number 5
                hashmap.put(index,poker);//将每张牌对应的编号存储在hashmap集合的键中
                pokerList.add(index);//将每张牌的编号同样存储在arraylist集合中
                index++;//每存储一张牌，编号加1
            }
        }

        //使用Collections工具类的shuffle()方法将获取到的54张牌的顺序打乱，也就是“洗牌”
        Collections.shuffle(pokerList);

        /* 获取三位玩家以及底牌
         * k=1，2，3分别代表三位玩家的牌
         * k=其他数字（在这里，我定义为4）代表底牌
         */
        //三位玩家和底牌需要创建成相应的集合来存储各自的牌
        //发牌：为了保证发出的牌类似欢乐斗地主那样是排好序的，所以这里我们使用TreeSet集合接收
        TreeSet<Integer> player1=new TreeSet<Integer>();//玩家1
        TreeSet<Integer> player2=new TreeSet<Integer>();//玩家2
        TreeSet<Integer> player3=new TreeSet<Integer>();//玩家3
        TreeSet<Integer> basepoker=new TreeSet<Integer>();//底牌
        for(int i=0;i<pokerList.size();i++) {//arraylist集合的长度为54，下标则是从0到53
            if(i<51) {//前51张牌按顺序依次发给3位玩家
                if(i%3==0) {
                    //这里通过ArrayList集合中的get(index)方法获取索引i对应的牌的编号
                    player1.add(pokerList.get(i));
                    licensingPrint("player1当前发牌",player1,hashmap);
                }else if(i%3==1) {
                    player2.add(pokerList.get(i));
                    licensingPrint("player2当前发牌",player2,hashmap);
                }else {
                    player3.add(pokerList.get(i));
                    licensingPrint("player3当前发牌",player2,hashmap);
                    System.out.println("");
                }
            }else {
                basepoker.add(pokerList.get(i));
                licensingPrint("底牌当前发牌",basepoker,hashmap);
            }
        }

        //通过遍历TreeSet集合，获取牌的编号，进而到HashMap集合中找到对应牌的花色大小
        licensingPrint("player1最终发牌：",player1,hashmap);
        licensingPrint("player2最终发牌：",player2,hashmap);
        licensingPrint("player3最终发牌：",player3,hashmap);
        licensingPrint("basepoker最终发牌：",basepoker,hashmap);

}
    public  void licensingPrint(String name,TreeSet<Integer> ts,HashMap<Integer,String> hashmap) {
        System.out.print(name + "[");
        int num=0;
        for(Integer key : ts) {//遍历形参中的每一个TreeSet集合
            //通过HashMap集合中的get(key)方法获取键对应的值（也就是牌的编号对应牌的花色大小）
            String value=hashmap.get(key);
            //这里的if-else是控制一下输出格式，保证最后一张牌的后面没有多余的逗号
            if(num<ts.size()-1) {
                System.out.print(value + " , ");
            }else {
                System.out.print(value);
            }
            num++;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        //创建牌的花色数组
        String[] colors={"♠","♥","♦","♣"};

        //创建牌的大小数组（必须按大小顺序排列）
        String[] numbers={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        //创建一个HashMap集合，键对应牌的编号Integer类型，值对应牌的大小String类型
        HashMap<Integer,String> hashmap = new HashMap<>();
        //创建一个ArrayList集合，存储牌的编号
        ArrayList<Integer> pokerList = new ArrayList<>();

        Poker poker= new Poker(pokerList,colors,numbers,hashmap);
        //再创建一个ArrayList集合去接收54张牌
        poker.fiftyfive();



    }
}
