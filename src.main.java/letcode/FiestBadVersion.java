package letcode;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/16
 * Time: 18:48
 * <p/>
 * fixme 题目描述：
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p/>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p/>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p/>
 * fixme 题目大意：
 * 你是一名产品经理，正在领导团队开发一个新产品。不幸的是，产品的最新版本没有通过质量检测。由于每一个版本都是基于上一个版本开发的，某一个损坏的版本之后的所有版本全都是坏的。
 * <p/>
 * 假设有n个版本[1, 2, ..., n]，你想要找出第一个损坏的版本，它导致所有后面的版本都坏掉了。
 * <p/>
 * 给你一个API bool isBadVersion(version)，返回某一个版本是否损坏。实现一个函数找出第一个损坏的版本。你应该最小化调用API的次数。
 * <p/>
 * fixme 解题思路：
 * 二分法（Binary Search）
 */
public class FiestBadVersion {

    static boolean isBadVersion(int n) {
        return n == 7;
    }

    public static int firstBadVersion(int n) {
        if (n == 0) {
            return -1;
        }

        int left = 1;
        int right = n;
        int middlen;

        while (left <= right) {
            middlen = left + (right - left) / 2;
            if (isBadVersion(middlen)) {
                right = middlen - 1;
            } else {
                left = middlen + 1;
            }
        }
        return left;
    }

    public static int firstBadVersion(int[] n, int des) {
        int left = 0;
        int right = n.length - 1;
        int num = 0;

        while (left <= right) {
            num++;
            int middlen = left + (right - left) / 2;
            if (n[middlen] > des) {
                right = middlen - 1;
            } else if (n[middlen] < des) {
                left = middlen + 1;
            } else {
                System.out.println("num = " + num);
                return middlen;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(firstBadVersion(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(firstBadVersion(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }
}
