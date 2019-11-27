package com.zhl.leetcode;


import java.util.*;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2019/11/26 09:02
 */
public class LeetCode_1122 {

    /**
     * 给你两个数组，arr1 和 arr2，
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/relative-sort-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        /**
         * 拆分思路：
         * 先找到在arr2中重复的项
         * 在排序不在arr2中的项
         */
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> kv = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    flag = 1;
                    System.out.println(kv.get(arr2[j]));
                    if (kv.get(arr2[j]) != null) {
                        int value = kv.get(arr2[j]).intValue() + 1;
                        kv.put(arr2[j], value);
                    } else {
                        kv.put(arr2[j], 1);
                    }
                }
            }
            if (flag == 0) {
                list.add(arr1[i]);
            }
        }
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            int num = kv.get(key);
            for (int j = 0; j < num; j++) {
                result[index] = key;
                index++;
            }
        }
        // 处理不在arr2中的项 list中数据排序
        Collections.sort(list);
        for (Integer num : list) {
            result[index] = num;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode_1122 test = new LeetCode_1122();
        test.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        // 2,2,2,1,4,3,3,9,6,7,19
    }
}