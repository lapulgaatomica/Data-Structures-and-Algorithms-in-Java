package trees.inttree;

import java.util.*;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}

class main{
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        left.setLeft(new BinaryTreeNode(4));
        left.setRight(new BinaryTreeNode(5));
        BinaryTreeNode right = new BinaryTreeNode(3);
        right.setLeft(new BinaryTreeNode(6));
        right.setRight(new BinaryTreeNode(7));
        root.setLeft(left);
        root.setRight(right);
        preOrder(root);
        inOrder(root);
        postOrder(root);
        System.out.println(levelOrder(root));
        System.out.println(maxInBinaryTree(root));
        System.out.println(findInBT(root, 7));
    }

    public static void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void inOrder(BinaryTreeNode root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public static void postOrder(BinaryTreeNode root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while (!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.getData());
                if(tmp.getLeft() != null){
                    q.offer(tmp.getLeft());
                }

                if(tmp.getRight() != null){
                    q.offer(tmp.getRight());
                }
            }else{
                ArrayList<Integer> c_curr = new ArrayList<>(curr);
                res.add(c_curr);
                curr.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return res;
    }

    public static int maxInBinaryTree(BinaryTreeNode root){
        int maxValue = Integer.MIN_VALUE;
        if(root != null){
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());

            if(leftMax > rightMax){
                maxValue = leftMax;
            }else{
                maxValue = rightMax;
            }

            if(root.getData() > maxValue){
                maxValue = root.getData();
            }
        }
        return maxValue;
    }

    public static boolean findInBT(BinaryTreeNode root, int data){
        if(root == null){
            return false;
        }
        if(root.getData() == data){
            return true;
        }

        return findInBT(root.getLeft(), data) || findInBT(root.getRight(), data);
    }
}
