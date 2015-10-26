package _20151016_1st_week;

import TreeUtils.TreeNode;
/**This is the 1st question from Hacking a Google interview practice questions: Person B.*/
public class _20151016_BinarySearchTreeValidity {

	private boolean isValid(TreeNode root){
//		return isValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//		return dfs(root, null, null);
		return dfsAgain(root, null, null);
	}

	/**This is the solution I used from leetcode.*/
	private boolean dfs(TreeNode root, Integer min, Integer max) {
		printRoot(root);
		printMin(min);
		printMax(max);
		System.out.println();
		if (root == null) {
			return true;
		} else if ((min != null && root.val <= min)
				|| (max != null && root.val >= max)) {
			return false;
		} else {
			return dfs(root.left, min, root.val)
					&& dfs(root.right, root.val, max);
		}
	}

	private void printMin(Integer min) {
		if(null != min){
			System.out.println("min is " + min);
		} else {
			System.out.println("min is null!");
		}
	}
	
	private void printMax(Integer max) {
		if(null != max){
			System.out.println("max is " + max);
		} else {
			System.out.println("max is null!");
		}
	}

	private void printRoot(TreeNode root) {
		if(null != root){
			System.out.println("root is " + root.val);
		} else {
			System.out.println("root is null!");
		}
	}

	public static void main(String... args){
		TreeNode root = null;
		//construct a valid BST
//		root = new TreeNode(10);
//		root.left = new TreeNode(8);
//		root.right = new TreeNode(12);
//		root.left.left = new TreeNode(5);
//		root.left.right = new TreeNode(9);
//		root.right.left = new TreeNode(11);
//		root.right.right = new TreeNode(14);
		
		//construct an invalid BST
		root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(14);
		
		_20151016_BinarySearchTreeValidity test = new _20151016_BinarySearchTreeValidity();
		
		System.out.print(test.isValid(root));
	}
	
	/**This is the same program as the above dfs algorithm, it's just that I tried to write it out by myself.*/
	private boolean dfsAgain(TreeNode root, Integer min, Integer max){
		if(root == null){
			return true;
		} else if ((min != null && min >= root.val) || (max != null && max <= root.val)) {
			return false;
		} else {
			return dfsAgain(root.left, min, root.val) &&
					dfsAgain(root.right, root.val, max);
		}
	}
	
	/**This is the solution from Google handout, but I don't think it actually work!
	 * One simple test case just fails it!*/
	private boolean isValidHelper(TreeNode curr, int min, int max) {
		if(curr.left != null){
			if((curr.left.val < min) || !isValidHelper(curr.left, min, curr.val)){
				return false;
			}
		}
		if(curr.right != null){
			if((curr.right.val > max) || !isValidHelper(curr.right, curr.val, max)){
				return false;
			}
		}
		return true;
	}
	
}
