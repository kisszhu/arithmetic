package com.zhl.leetcode.binarySearch;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/01/17 10:36
 */
public class LeetCode704 {

	/**
	 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
	 * <p>
	 * 二分查找是一种基于比较目标值和数组中间元素的教科书式算法
	 * 如果目标值等于中间元素，则找到目标值
	 * 如果目标值较小，继续在左侧搜索
	 * 如果目标值较大，继续在右侧检索
	 * <p>
	 * 二分查找的结束条件是 left与right的大小判断，如果left超过了right，则表示二分查找结束
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/binary-search
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param array
	 * @param target
	 * @return
	 */

	public int search(int[] array, int target) {
		int mid, left = 0;
		int right = array.length - 1;
		while (left <= right) {
			/**
			 * 需要注意二分查找的溢出问题：
			 * 若low+high > Integer.MAX_VALUE时，此时会导致数据溢出，则导致mid错误
			 * 所以mid应该改为： low + (high -low)/2
			 * 或者采用位运算：low + ((high-low) >> 1)：数学意义，右移一位相当于除2，右移n位相当于除以2的n次方
			 */
			mid = left + ((right - left) / 2);
			if (array[mid] == target) {
				return mid;
			}
			if (array[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		LeetCode704 test = new LeetCode704();
		int res = test.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
		System.out.println(res);
	}
}
