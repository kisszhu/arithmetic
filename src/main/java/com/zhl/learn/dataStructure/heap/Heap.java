package com.zhl.learn.dataStructure.heap;

import java.util.Arrays;

/**
 * Created by zhuhailong-dc on 2018/3/16.
 * 设父节点的编号为 i, 则其左孩子节点的编号为2*i+1, 右孩子节点的编号为2*i+2
 * 设孩子节点的编号为i, 则其父节点的编号为(i-1)/2
 * <p>
 * 由于二叉树良好的形态已经包含了父节点和孩子节点的关系信息，因为就可以不使用链表而简单的使用数组来存储堆。
 */
public class Heap {
    private final static int N = 100;
    private int[] nums;
    private int size;

    public Heap(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        heapify(this.nums);
    }

    public Heap() {
        this.nums = new int[N];
    }

    /**
     * heapify an array, O(n)
     *
     * @param nums an array to be heapified
     */
    private void heapify(int[] nums) {
        for (int j = (size - 1) >> 1; j >= 0; j--)
            siftDown(j);
    }

    /**
     * append x to heap
     *
     * @param x
     * @return
     */
    public int insert(int x) {
        if (size >= this.nums.length)
            expandSpace();
        size += 1;
        nums[size - 1] = x;
        siftUp(size - 1);
        return x;
    }

    /**
     * delete an element located in i position
     *
     * @param i
     * @return
     */
    public int delete(int i) {
        rangeCheck(i);
        int key = nums[i];
        // 将last元素覆盖过来，先siftDown，在视情况考虑是否siftup
        int last = nums[i] = nums[size - 1];
        size--;
        siftDown(i);
        // check #i的node的键值是否确实发生改变,若发生改变，则ok,否则为确保堆性质，则需要siftUp;
        if (i < size && nums[i] == last)
            siftUp(i);
        return key;
    }

    /**
     * remove the root of heap, return it's value, and adjust heap to maintain the heap's property.
     *
     * @return
     */
    public int extractMin() {
        rangeCheck(0);
        int key = nums[0], last = nums[size - 1];
        nums[0] = last;
        size--;
        siftDown(0);
        return key;
    }

    /**
     * return an element's index, if not exists, return -1
     *
     * @param x
     * @return
     */
    public int search(int x) {
        for (int i = 0; i < size; i++)
            if (nums[i] == x)
                return i;
        return -1;
    }

    /**
     * return but does not remove the root of heap.
     *
     * @return
     */
    public int peek() {
        rangeCheck(0);
        return nums[0];
    }

    /**
     * 将位置i的元素x向上调整，以满足堆的性质，常常是用于insert后，用于调整堆；
     *
     * @param i
     */
    private void siftUp(int i) {
        int key = nums[i];
        for (; i > 0; ) {
            int p = (i - 1) >>> 1;
            if (nums[p] <= key)
                break;
            nums[i] = nums[p];
            i = p;
        }
        nums[i] = key;
    }

    /**
     * 同siftUp，常常是用于delete(i)后，用于调整堆
     *
     * @param i
     */
    private void siftDown(int i) {
        int key = nums[i];
        for (; i < size / 2; ) {
            int child = (i << 1) + 1;
            if (child + 1 < size && nums[child] > nums[child + 1])
                child++;
            if (key <= nums[child])
                break;
            nums[i] = nums[child];
            i = child;
        }
        nums[i] = key;
    }

    //

    private void rangeCheck(int i) {
        if (!(0 <= i && i < size))
            throw new RuntimeException("index is out of boundary");
    }

    private void expandSpace() {
        this.nums = Arrays.copyOf(this.nums, size * 2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++)
            sb.append(String.format((i != 0 ? ", " : "") + "%d", nums[i]));
        sb.append("]");
        return sb.toString();
    }

}
