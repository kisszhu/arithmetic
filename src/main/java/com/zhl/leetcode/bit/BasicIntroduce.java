package com.zhl.leetcode.bit;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/20 09:25
 */
public class BasicIntroduce {

    public static void main(String[] args) {
        binaryToDecimal(5);
        binaryToDecimal2(5);
        binaryToDecimal3(-5);
    }

    /**
     * 除基倒取余法
     * 这是最符合我们平时的数学逻辑思维的，即输入一个十进制n，每次用n除以2，把余数记下来，在用商去除以2...依次循环，直到商为0结束。
     * 把余数倒着依次排列，就构成了转换后的二进制数
     */
    public static void binaryToDecimal(int n) {
        // 用来记录位数
        int t = 0;
        // 用来记录最后的二进制数
        int bin = 0;
        // 用来存储余数
        int r = 0;
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            // 用于控制进位
            bin += r * Math.pow(10, t);
            t++;
        }
        System.out.println(bin);
    }

    /**
     * 但是int型最大只能表示2^31-1的正数，所以，存储的二进制数位数有限；
     */
    public static void binaryToDecimal2(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        System.out.println(str);
    }

    public static void binaryToDecimal3(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append(n >>> i & 1);
        }
        // 5
        /// 0000 0000 0000 0000 0000 0000 0000 0101
        // -5
        /// 1111 1111 1111 1111 1111 1111 1111 1011
        System.out.println(sb.toString());
    }
    /**
     * 位移操作
     */

}


//        第二种：利用“移位”操作实现
//
//        我们可以直接利用移位操作对一个十进制数进行移位操作，即：将最高位的数移至最低位（移31位），除过最低位其余位置清零，使用& 操作，
//        可以使用和1相与（&），由于1在内存中除过最低位是1，其余31位都是零，然后把这个数按十进制输出；再移次高位，做相同的操作，直到最后一位 ，
//        代码如下。可以说，这是我到目前为止见到的最简单的实现方式了。
//
//public void binaryToDecimal(int n){
//        for(int i = 31;i >= 0; i--)
//        System.out.print(n >>> i & 1);
//        }
//
//
//        说明：由于计算机中存储的都是数的补码，正数的原码、反码、补码都是相同的；而负数的原码、反码、补码是不一样的，补码=原码取反+1（符号位不变）。
//        所以，负数是按照它的补码输出的。
//
//        >>>为逻辑移位符，向右移n位，高位补0
//        >> 算数移位符，也是向右移n位，不同的是：正数高位补0，负数高位补1
//        << 移位符，向左移n位，低位补0
//
//



