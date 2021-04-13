package com.zhl.leetcode.math;


import java.util.HashMap;
import java.util.Map;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/12/18 11:18
 */
public class LeetCode_535 {

	Map<Integer, String> kv = new HashMap<>();

	int i = 0;

	public String encode(String longUrl) {
		kv.put(i, longUrl);
		return "http://tinyurl.com/" + i++;
	}

	public String decode(String shortUrl) {
		return kv.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	}

	public static void main(String[] args) {
		LeetCode_535 test = new LeetCode_535();
		System.out.println(test.decode(test.encode("https://")));
	}
}



