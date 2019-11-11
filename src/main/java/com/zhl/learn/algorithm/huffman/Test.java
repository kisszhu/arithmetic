package com.zhl.learn.algorithm.huffman;

/**
 * Created by zhuhailong-dc on 2018/5/11.
 * -
 */
public class Test {

    public static void main(String[] args) {
        HuffmanAlgorithmImpl impl = new HuffmanAlgorithmImpl();
        EncodeResult result = impl.encode("测试中文的压缩效率");
        System.out.println(result.getEncode());

        String decode = impl.decode(result);
        System.out.println(decode);

        System.out.println("测试中文的压缩效率".getBytes().length);
        System.out.println(result.getEncode().getBytes().length);

    }

}
