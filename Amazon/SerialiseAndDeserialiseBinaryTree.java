// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void deletetree( Node root)
{
    if(root == null)
    return;
    deletetree(root.left);
    deletetree(root.right);
    root.left=null;
    root.right=null;
}
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            deletetree(root);
	            root = null;
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    Queue<Node> que = new ArrayDeque<>();
	    A.add(root.data);
	    que.add(root);
	    while(que.size()>0){
	        int size = que.size();
	       // A.add(root.data);
	        Node rem = que.remove();
	       // A.add(rem.data);
	        if(rem.left==null){
	            A.add(-1);
	        }else{
	            A.add(rem.left.data);
	            que.add(rem.left);
	        }
	        if(rem.right==null){
	            A.add(-1);
	        }else{
	            A.add(rem.right.data);
	            que.add(rem.right);
	        }
	    }
	   //  System.out.println(A);   
	        
	    
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        Node root = new Node(A.get(0));
        // Node node = root;
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        for(int i = 1;i<A.size();i++){
            Node rem = que.remove();
            if(A.get(i)!=-1){
                Node left = new Node(A.get(i));
                rem.left = left;
                que.add(left);
            }
            if(A.get(++i)!=-1){
                Node right = new Node(A.get(i));
                rem.right = right;
                que.add(right);
            }
        }
        return root;
    }
};
/*Serialization is to store a tree in an array so that it can be later restored and 
Deserialization is reading tree back from the array. Now your task is to complete the 
function serialize which stores the tree into an array A[ ] and deSerialize which 
deserializes the array to the tree and returns it.
Note: The structure of the tree must be maintained. Multiple nodes can have the same data.

Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30
Your Task:
The task is to complete two function serialize which takes the root node of the tree
as input and stores the tree into an array and deSerialize which deserializes the 
array to the original tree and returns the root of it.*/