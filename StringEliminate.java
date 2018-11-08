package com.example.demo.test;

import java.util.*;

/**
 * 给定一个字符串,剔除子串后返回
 */
public class StringEliminate {

    public static String function1(String origin,String sub){
        // 获取char数组用于后续运算
        char[] originChars = origin.toCharArray();
        char[] subChars = sub.toCharArray();
        // 使用map作为辅助, 初始化大小设置为子串的2倍 参考公式 元素个数/0.75 + 1
        int originCharsSize = originChars.length;
        int subCharsSize = subChars.length;
        Map<Character,Object> map = new HashMap<>(subCharsSize * 2);
        // 哨兵角色,用于map.get() 判断
        Object o = new Object();
        // 对于数组采用传统的数组循环
        for (int i = 0; i < subCharsSize; i++){
            map.put(subChars[i],o);
        }
        // 由于不涉及线程安全使用StringBuilder拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < originCharsSize; i++){
            char c = originChars[i];
            // map.get 时间复杂度是O(1) 优于map.contain,set.contain类的方法
            if (map.get(c) == null){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.print(function1("ammmimiib","mi"));
    }
}
