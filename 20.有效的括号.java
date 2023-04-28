import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> deque = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                deque.push(s.charAt(i));
            }else{
                if(map.get(s.charAt(i)) != deque.peek()){
                    return false;
                }
                deque.pop();
            }
        }
        if (deque.size()>0){
            return false;
        }
        return true;
    }
}
// @lc code=end

