package letcode;

import util.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/16
 * Time: 18:10
 * <p/>
 * fixme 题目描述：
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p/>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p/>
 * Note:
 * <p/>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * fixme 题目大意：
 * 给定一个数组nums，编写函数将数组内所有0元素移至数组末尾，并保持非0元素相对顺序不变。
 * <p/>
 * 例如，给定nums = [0, 1, 0, 3, 12]，调用函数完毕后， nums应该是 [1, 3, 12, 0, 0]。
 * <p/>
 * 注意：
 * <p/>
 * 你应该“就地”完成此操作，不要复制数组。
 * 最小化操作总数。
 * fixme 解题思路：
 * 题目可以在O(n)时间复杂度内求解
 * <p/>
 * fixme 算法步骤：
 * <p/>
 * 使用两个"指针"x和y，初始令y = 0
 * <p/>
 * 利用x遍历数组nums：
 * <p/>
 * 若nums[x]非0，则交换nums[x]与nums[y]，并令y+1
 * <p/>
 * fixme 算法简析：
 * <p/>
 * y指针指向首个0元素可能存在的位置
 * <p/>
 * 遍历过程中，算法确保[y, x)范围内的元素均为0
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) {
            return;
        }
        int tmp = -1;
        boolean findFirstZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !findFirstZero) {
                findFirstZero = true;
                tmp = i;
                continue;
            }
            if (nums[i] != 0 && findFirstZero) {
                nums[tmp] = nums[i];
                nums[i] = 0;
                tmp++;
            }
        }
        System.out.println(JsonUtil.writeObjectToJson(nums));
    }


    public static void main(String[] args) throws Exception {
        moveZeroes(new int[]{0, 1, 1, 0, 0, 2, 4, 0});
        moveZeroes(new int[]{4, 1, 1, 0, 0, 2, 4, 0});
        moveZeroes(new int[]{0, 0, 0, 0, 0, 0, 4, 0});
    }
}
