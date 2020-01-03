package leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
@Deprecated
public class LeetCode_0146 {

    class LRUCache {

        int mCapacity = 0;
        int mSize = 0;
        int[] mIndexs;
        int[] mKeys;
        int[] mValues;
        int mHead;

        public LRUCache(int capacity) {
            mCapacity = capacity;
            mIndexs = new int[capacity];
            mKeys = new int[capacity];
            mValues = new int[capacity];
            mHead = -1;
        }

        public int get(int key) {
            int value = -1;
            int pre = -1;
            int cur = mHead;
            while (cur >= 0) {
                if (key == mKeys[cur]) {
                    value = mValues[cur];
                    if (cur != mHead) {
                        mIndexs[pre] = mIndexs[cur];
                        mIndexs[cur] = mHead;
                        mHead = cur;
                    }
                    return value;
                } else {
                    pre = cur;
                    cur = mIndexs[cur];
                }
            }

            return value;
        }

        public void put(int key, int value) {
            int pre = -1;
            int cur = mHead;

            if (cur >= 0) {
                while (true) {
                    if (key == mKeys[cur]) {
                        mValues[cur] = value;
                        if (cur != mHead) {
                            mIndexs[pre] = mIndexs[cur];
                            mIndexs[cur] = mHead;
                            mHead = cur;
                        }
                        return;
                    } else {
                        if (mIndexs[cur] < 0) {
                            break;
                        }
                        pre = cur;
                        cur = mIndexs[cur];
                    }
                }
            }

            if (mSize < mCapacity) {
                pre = cur;
                cur = mSize;
                mIndexs[cur] = -1;
                mSize ++;
            }
            mKeys[cur] = key;
            mValues[cur] = value;
            if (cur != mHead) {
                if (pre >= 0) {
                    mIndexs[pre] = mIndexs[cur];
                }
                mIndexs[cur] = mHead;
                mHead = cur;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
