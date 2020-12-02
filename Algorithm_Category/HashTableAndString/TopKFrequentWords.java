package HashTableAndString;

import java.util.*;

/**
 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

 示例 1：
     输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     输出: ["i", "love"]
     解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     注意，按字母顺序 "i" 在 "love" 之前。


 示例 2：
     输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     输出: ["the", "is", "sunny", "day"]
     解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     出现次数依次为 4, 3, 2 和 1 次。

 注意：
     假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
     输入的单词均由小写字母组成。
 */

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < combo.length; i++) {
            int count = 1 + wordCountMap.getOrDefault(combo[i], 0);
            wordCountMap.put(combo[i], count);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (s1, s2) -> wordCountMap.get(s1).equals(wordCountMap.get(s2)) ?
                        s2.compareTo(s1) : wordCountMap.get(s1) - wordCountMap.get(s2)
        );

        for (String s : wordCountMap.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        String[] result = new String[minHeap.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
