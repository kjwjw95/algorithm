package com.programmers.kakao;

import java.util.Arrays;
import java.util.Comparator;

public class 길찾기게임 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		int[][] ans = s.solution(nodeinfo);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}

class Solution3 {
	static int[] preorder;
	static int[] postorder;
	static int a = 0;

	public class Node {
		int num, level, loc;
		Node left, right;

		public Node(int num, int level, int loc) {
			super();
			this.num = num;
			this.level = level;
			this.loc = loc;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", level=" + level + ", loc=" + loc + ", left=" + left + ", right=" + right + "]";
		}
		
	}

	public class Tree {
		Node root;

		public void addNode(int n, int level, int loc) {
			if (root == null) {
				Node node = new Node(n, level, loc);
				root = node;
			} else {
				addNode(n, level, loc, root);
			}
		}

		public void addNode(int n, int level, int loc, Node root) {
			if (loc < root.loc) {
				if (root.left == null) {
					Node node = new Node(n, level, loc);
					root.left = node;
				} else {
					addNode(n, level, loc, root.left);
				}
			} else {
				if (root.right == null) {
					Node node = new Node(n, level, loc);
					root.right = node;
				} else {
					addNode(n, level, loc, root.right);
				}
			}
		}

	}

	public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][];
		int N = nodeinfo.length;
		Tree tree = new Tree();
		preorder = new int[N];
		postorder = new int[N];
		Node[] nodes = new Node[N];
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes[i] = new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]);
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.level - o1.level;
			}
		});
		for (int i = 0; i < nodeinfo.length; i++) {
			tree.addNode(nodes[i].num, nodes[i].level, nodes[i].loc);
		}
		String[] s = new String[10];
		PreOrder(tree.root);
		a=0;
		PostOrder(tree.root);
		answer[0]=preorder;
		answer[1]=postorder;
		return answer;
		
	}

	private void PostOrder(Node root) {
		if (root == null)
			return;
		PostOrder(root.left);
		PostOrder(root.right);
		postorder[a++]=root.num;
		
	}

	private void PreOrder(Node root) {
		if (root == null)
			return;
		preorder[a++]=root.num;
		PreOrder(root.left);
		PreOrder(root.right);
	}


}