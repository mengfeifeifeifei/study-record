package com.study.collectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Doudizhu {

    /**
     * 静态集合存储牌
     * @param args
     */
    public static List<Cards> allCards = new ArrayList<>();

    /**
     * 做牌
     * @param args
     */
    static {
        String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♣", "♥", "♦"};
        int index = 0;
        // 组合
        for (String size : sizes) {
            index++;
            for (String color : colors) {
                Cards cards = new Cards(size, color, index);
                allCards.add(cards);
            }
        }
        allCards.add(new Cards("小王", "", ++index));
        allCards.add(new Cards("大王", "", ++index));
    }


    public static void main(String[] args) {
        // 打乱牌顺序
        Collections.shuffle(allCards);
        System.out.println(allCards);

        // 发牌 三个玩家
        List<Cards> z = new ArrayList<>();
        List<Cards> m = new ArrayList<>();
        List<Cards> f = new ArrayList<>();

        for (int i = 0; i < allCards.size() - 3; i++) {
            Cards c = allCards.get(i);
            if (i % 3 == 0) {
                z.add(c);
            } else if (i % 3 == 1) {
                m.add(c);
            } else {
                f.add(c);
            }
        }

        // 截取斗地主的剩余三张牌
        List<Cards> lastThreeCards = allCards.subList(allCards.size()-3, allCards.size());

        // 给玩家的牌排序
        sortCards(z);
        sortCards(m);
        sortCards(f);

        // 输出玩家的牌
        System.out.println("z: " + z);
        System.out.println("m: " + m);
        System.out.println("f: " + f);
        System.out.println("底牌: " + lastThreeCards);
    }

    /**
     * 给牌排序
     * @param z, m, f
     */
    private static void sortCards(List<Cards> z) {
//        Collections.sort(z, (Cards o1, Cards o2) -> o1.getIndex() - o2.getIndex());
        // List类型自带的排序
        z.sort((Cards o1, Cards o2) -> o1.getIndex() - o2.getIndex());
    }
}
