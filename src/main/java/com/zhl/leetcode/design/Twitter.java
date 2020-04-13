package com.zhl.leetcode.design;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @program arithmetic
 * @description:
 * @author: meilong
 * @create: 2020/04/13 09:10
 */
public class Twitter {

    /**
     * 设计一个简化版的推特，可以让用户实现发送推文，关注/取消关注其他用户
     * 能够看见关注人（包括自己）的最近十条推文
     */
    /**
     * 用户与关注者的对应关系 哈希表 + HashSet
     */
    Map<Integer, HashSet<Integer>> userFollow;

    /**
     * 用户与推文的对应关系 哈希表 + 链表（这里的链表，也可以换成栈）
     */
    Map<Integer, TwitterNews> userNews;

    /**
     * 本来是要用LocalDateTime，但是LeetCode居然不支持
     */
    Integer count;

    /**
     * 优先队列 合并K组推文使用的数据结构
     * PriorityQueue是一个基于优先级的无界优先级队列，优先级队列的元素按照自然顺序进行排序，或者根据构造队列时提供的Comparator进行排序
     * 具体取决于所使用的构造方法。该队列不允许使用null元素也不允许插入不可比较的对象（没有实现Comparable接口的对象）
     * 随着不断向优先级队列添加元素，其容量会自动扩容
     * PriorityQueue使用跟普通队列一样，唯一区别是PriorityQueue会根据排序规则决定谁在队头，谁在队尾
     */
    PriorityQueue<TwitterNews> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        count = 0;
        userFollow = new HashMap<>();
        userNews = new HashMap<>();

        /**
         * 1、添加元素自身实现了Comparable接口，确保元素是可排序的对象
         * 2、如果添加元素没有实现Comparable接口，可以在创建PriorityQueue队列时直接指定比较器
         */
        maxHeap = new PriorityQueue<>(new Comparator<TwitterNews>() {
            @Override
            public int compare(TwitterNews o1, TwitterNews o2) {
                return o2.time - o1.time;
            }
        });
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (userNews.containsKey(userId)) {
            TwitterNews news = new TwitterNews(tweetId);
            TwitterNews olds = userNews.get(userId);
            // 采用单向链表，保证最新的消息在最上面，也可以采用数组，在数据的末尾添加消息，也可以采用栈
            news.next = olds;
            userNews.put(userId, news);
        } else {
            TwitterNews news = new TwitterNews(tweetId);
            userNews.put(userId, news);
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        HashSet<Integer> set = userFollow.get(followerId);
        if (set == null) {
            set = new HashSet<>();
            set.add(followeeId);
            userFollow.put(followerId, set);
        } else {
            if (set.contains(followeeId)) {
                return;
            }
            set.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        HashSet<Integer> set = userFollow.get(followerId);
        if (set == null) {
            return;
        }
        set.remove(followeeId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();

        if (userNews.containsKey(userId)) {
            maxHeap.offer(userNews.get(userId));
        }

        HashSet<Integer> follow = userFollow.get(userId);
        if (follow != null && follow.size() > 0) {
            for (Integer follower : follow) {
                TwitterNews news = userNews.get(follower);
                if (news != null) {
                    maxHeap.offer(news);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        for (int i = 0; i < 10 && !maxHeap.isEmpty(); i++) {
            TwitterNews head = maxHeap.poll();
            res.add(head.newsId);

            if (head.next != null) {
                maxHeap.offer(head.next);
            }
        }
        return res;
    }

    class TwitterNews {
        /**
         * 消息ID
         */
        Integer newsId;

        /**
         * 消息时间
         */
        Integer time;

        /**
         * 消息内容
         */
        String content;

        /**
         * 下一条推文
         */
        TwitterNews next;

        public TwitterNews(Integer twittId) {
            this.newsId = twittId;
            this.time = count++;
            this.content = "";
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);
    }
}
