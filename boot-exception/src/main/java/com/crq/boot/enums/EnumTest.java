package com.crq.boot.enums;

/**
 * @Author: crq
 * @Description: values() 、ordinal() 、value0f() 方法
 * enum 定义的枚举类默认继承了 java. lang. Enum类，并实现了 java. Lang. Serializable 和 java. Lang. Comparable 两个接口
 * values(),ordinal()和value0f()方法位于java.lang.Enum类中：
 * values()返回枚举类中所有的值。
 * ordinal()方法可以找到每个枚举常量的索引，就像数组索引一样。
 * value0f()方法返回指定字符串值的枚举常量。
 * @Date: create in 2022/4/11
 */
public class EnumTest {
    public static void main(String[] args) {
        //调用values()
        Color[] arr = Color.values();
        //枚举迭代
        for (Color col : arr) {
            //查看索引
            System.out.println(col + "at index " + col.ordinal());
        }
        //使用 valueOf() 返回枚举常量，不存在的会报错 ILLegaLArgumentException
        System.out.println(Color.valueOf("BLUE"));
    }
}
