package com.zhl.learn.arithmetic.huffman;

import java.util.Map;

/**
 * Created by zhuhailong-dc on 2018/5/11.
 * 对字符串编码后的结果：包括编码后的字符串和字符/编码对
 */
public class EncodeResult {

    // 字符串编码后的结果
    private String encode;

    // 字符编码对
    private Map<Character, String> letterCode;


    public EncodeResult(String encode, Map<Character, String> letterCode) {
        super();
        this.encode = encode;
        this.letterCode = letterCode;
    }
    
    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public Map<Character, String> getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(Map<Character, String> letterCode) {
        this.letterCode = letterCode;
    }

}
