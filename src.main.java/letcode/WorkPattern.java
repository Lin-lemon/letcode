package letcode;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Date: 15/10/15
 * Time: 15:32
 * <p/>
 * fixme 题目大意：
 * 给定一个模式pattern和一个字符串str，判断str是否满足相同的pattern。
 * <p/>
 * 测试用例如题目描述。
 * <p/>
 * 注意：
 * <p/>
 * pattern和str都只包含小写字母。
 * pattern和str不包含前导或者后缀空格。
 * str中的每一个单词之间都由一个空格分开。
 * pattern中的每一个字母都对应一个长度至少为1的单词。
 * <p/>
 * fixme 解题思路：
 * 使用字典dict分别记录pattern到word的映射以及word到pattern的映射
 */
public class WorkPattern {

    public static boolean wordPattern(String pattern, String str) {
        if (StringUtils.isBlank(pattern) || StringUtils.isBlank(str)) {
            return false;
        }

        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }

        Map<Object, Integer> map = Maps.newHashMap();
        for (int i = 0; i < strArr.length; i++) {
            if (ObjectUtils.notEqual(map.put(strArr[i], i), map.put(pattern.charAt(i), i))) {
                return false;
            }
        }
        return true;
    }


    public static boolean wordPatternOrg(String pattern, String str) {
        Map<Object, Integer> map = new HashMap();
        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < strArr.length; i++) {
            // todo 注意这里 两个key的value需是同一个
            Integer tmp = new Integer(i);
            if (map.put(strArr[i], tmp) != map.put(pattern.charAt(i), tmp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("itwasthebestoftimesitwastheworstoftimesitwastheageofwisdomitwastheageoffoolishnessitwastheepochofbeliefitwastheepochofincredulityitwastheseasonoflightitwastheseasonofdarknessitwasthespringofhopeitwasthewinterofdespair", "i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee bbbbbbbbbbbbbbbbbb eeeeeeeeeee sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww oo rrrrrrrrrrrrrr sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff wwww i sssss ddddddddddd oo mmm i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff fffffffff oo oo llllllll i sssss hhhhhhhhhhhhhhhhhhhhhhh nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff bbbbbbbbbbbbbbbbbb eeeeeeeeeee llllllll i eeeeeeeeeee fffffffff i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff i nnnnnn cccccccccccc rrrrrrrrrrrrrr eeeeeeeeeee ddddddddddd uuuuuuuuuu llllllll i tttttttttttttttt yyyyyyyyyyy i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff llllllll i gggggggggggggg hhhhhhhhhhhhhhhhhhhhhhh tttttttttttttttt i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff ddddddddddd aa rrrrrrrrrrrrrr kkkkkkkkk nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss pppp rrrrrrrrrrrrrr i nnnnnn gggggggggggggg oo fffffffff hhhhhhhhhhhhhhhhhhhhhhh oo pppp eeeeeeeeeee i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww i nnnnnn tttttttttttttttt eeeeeeeeeee rrrrrrrrrrrrrr oo fffffffff ddddddddddd eeeeeeeeeee sssss pppp aa i rrrrrrrrrrrrrr"));
        System.out.println(wordPatternOrg("itwasthebestoftimesitwastheworstoftimesitwastheageofwisdomitwastheageoffoolishnessitwastheepochofbeliefitwastheepochofincredulityitwastheseasonoflightitwastheseasonofdarknessitwasthespringofhopeitwasthewinterofdespair", "i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee bbbbbbbbbbbbbbbbbb eeeeeeeeeee sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww oo rrrrrrrrrrrrrr sssss tttttttttttttttt oo fffffffff tttttttttttttttt i mmm eeeeeeeeeee sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff wwww i sssss ddddddddddd oo mmm i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee aa gggggggggggggg eeeeeeeeeee oo fffffffff fffffffff oo oo llllllll i sssss hhhhhhhhhhhhhhhhhhhhhhh nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff bbbbbbbbbbbbbbbbbb eeeeeeeeeee llllllll i eeeeeeeeeee fffffffff i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee eeeeeeeeeee pppp oo cccccccccccc hhhhhhhhhhhhhhhhhhhhhhh oo fffffffff i nnnnnn cccccccccccc rrrrrrrrrrrrrr eeeeeeeeeee ddddddddddd uuuuuuuuuu llllllll i tttttttttttttttt yyyyyyyyyyy i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff llllllll i gggggggggggggg hhhhhhhhhhhhhhhhhhhhhhh tttttttttttttttt i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss eeeeeeeeeee aa sssss oo nnnnnn oo fffffffff ddddddddddd aa rrrrrrrrrrrrrr kkkkkkkkk nnnnnn eeeeeeeeeee sssss sssss i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee sssss pppp rrrrrrrrrrrrrr i nnnnnn gggggggggggggg oo fffffffff hhhhhhhhhhhhhhhhhhhhhhh oo pppp eeeeeeeeeee i tttttttttttttttt wwww aa sssss tttttttttttttttt hhhhhhhhhhhhhhhhhhhhhhh eeeeeeeeeee wwww i nnnnnn tttttttttttttttt eeeeeeeeeee rrrrrrrrrrrrrr oo fffffffff ddddddddddd eeeeeeeeeee sssss pppp aa i rrrrrrrrrrrrrr"));
    }


}
