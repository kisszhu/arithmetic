package com.qihoo.zhuhailong.arithmetic.huffman;

/**
 * Created by zhuhailong-dc on 2018/5/11.
 * -
 */
public interface HuffmanAlgorithm {

    /**
     * 编码字符串
     */
    public EncodeResult encode(String str);


    /**
     * 根据编码结果返回原来的字符串
     */
    public String decode(EncodeResult encodeResult);
}
