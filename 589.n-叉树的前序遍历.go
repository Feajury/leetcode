package aaa

/*
 * @lc app=leetcode.cn id=589 lang=golang
 *
 * [589] N 叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */
// type Node struct {
// 	Val      int
// 	Children []*Node
// }
//写法1
// func preorder(root *Node) []int {
// 	res := make([]int, 0)
// 	// 递归调用append方法，需要传入切片的指针，否则返回以前的内存地址
// 	run(root, &res)
// 	return res
// }
// func run(root *Node, res *[]int) {
// 	if root == nil {
// 		return
// 	}
// 	*res = append(*res, root.Val)
// 	if root.Children != nil {
// 		for _, ch := range root.Children {
// 			run(ch, res)
// 		}
// 	}
// }
//写法2 闭包
// func preorder(root *Node) []int {
// 	var res []int
// 	var des func(*Node)
// 	des = func(node *Node) {
// 		if node == nil {
// 			return
// 		}
// 		res = append(res, node.Val)
// 		for _, ch := range node.Children {
// 			des(ch)
// 		}
// 	}
// 	des(root)
// 	return res
// }
//写法3 可变参数
func preorder(root *Node) []int {
	var res []int
	if root == nil {
		return nil
	}
	res = append(res, root.Val)
	for i := 0; i < len(root.Children); i++ {
		res = append(res, preorder(root.Children[i])...)
	}
	return res
}

// @lc code=end
