// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        while(que.size()>0){
            Node rem = que.remove();
            if(rem.left!=null){
                map.put(rem.left,rem);
                que.add(rem.left);
            }if(rem.right!=null){
                map.put(rem.right,rem);
                que.add(rem.right);
            }
        }
        Node node = find(root, target);
        // System.out.println(node.data);
        // if(node==null) return 0;
        que = new ArrayDeque<>();
        int level = -1;
        HashMap<Node,Integer> visited = new HashMap<>();
        que.add(node);
        while(que.size()>0){
            int size = que.size();
            while(size-->0){
                Node rem = que.remove();
                if(map.containsKey(rem)){
                    if(!visited.containsKey(map.get(rem))){
                        que.add(map.get(rem));
                        visited.put(map.get(rem),1);
                    }
                }
                if(rem.left!=null){
                    if(!visited.containsKey(rem.left)){
                        que.add(rem.left);
                        visited.put(rem.left,1);
                    }
                }
                if(rem.right!=null){
                    if(!visited.containsKey(rem.right)){
                        que.add(rem.right);
                        visited.put(rem.right,1);
                    }
                }
            }
            level++;
        }
        return level;
        
        
    }
    public static Node find(Node node, int data){
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while(que.size()>0){
            Node rem = que.remove();
            if(rem.data==data) return rem;
            if(rem.left!=null){
                que.add(rem.left);
            }
             if(rem.right!=null){
                que.add(rem.right);
            }
        }
        return null;
    }
}
/*Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.


Example 1:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Example 2:

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5*/