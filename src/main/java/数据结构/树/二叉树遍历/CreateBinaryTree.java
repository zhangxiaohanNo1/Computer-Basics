package 数据结构.树.二叉树遍历;
import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangxiaohan
 * @date 2019/10/22 23:13
 * @description: 二叉树的深度优先遍历  广度优先遍历
 */
public class CreateBinaryTree {
    /**
     * 二叉树结点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode(int data){
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList == null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键，如果元素是空，则不再进一步递归
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树根节点
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //添加一个元素
        queue.offer(root);
        while (!queue.isEmpty()){
            //返回第一个元素并在队列中删除
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild !=null){
                queue.offer(node.rightChild);
            }
        }
    }
    /**
     * 二叉树前序遍历
     * @param node 二叉树节点
     */
    public static  void preOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历  用栈实现
     * @param root 二叉树根节点
     */
    public static void preOrderTraversalWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    public static  void inOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node 二叉树节点
     */
    public static  void postOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.print("前序遍历：");
        preOrderTraversal(treeNode);
        System.out.print("中序遍历：");
        inOrderTraversal(treeNode);
        System.out.print("后序遍历：");
        postOrderTraversal(treeNode);
    }
}
