package leetcode

/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 */

// @lc code=start
// s[i] 可以取string中的byte出来
func isValid(s string) bool {
	m := make(map[byte]byte)
	m[')'] = '('
	m[']'] = '['
	m['}'] = '{'
	var stack []byte
	for i := 0; i < len(s); i++ {
		if len(stack) > 0 && m[s[i]] > 0 {
			if stack[len(stack)-1] != m[s[i]] {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	if len(stack) > 0 {
		return false
	}
	return true
}

// @lc code=end
