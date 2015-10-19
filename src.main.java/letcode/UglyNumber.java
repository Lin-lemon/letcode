package letcode;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/16
 * Time: 19:31
 * <p/>
 * fixme 题目描述：
 * Write a program to check whether a given number is an ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 * <p/>
 * fixme 题目大意：
 * 编写程序判断一个给定的数字是否为“丑陋数” ugly number
 * <p/>
 * 丑陋数是指只包含质因子2, 3, 5的正整数。例如，6, 8是丑陋数而14不是，因为它包含额外的质因子7
 * <p/>
 * 注意，数字1也被视为丑陋数
 * <p/>
 * fixme 解题思路：
 * 将输入数重复除2, 3, 5，判断得数是否为1即可
 * <p/>
 * fixme 时间复杂度：
 * <p/>
 * 记num = 2^a * 3^b * 5^c * t，程序执行次数为 a + b + c，换言之，最坏情况为O(log num)
 */
public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) {
                num /= factor;
            }
        }
        return num == 1;
    }
}
