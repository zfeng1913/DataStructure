import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
   private List<T> preordertrans(TreeNode<T> root, List<T> list) {
       // 若根结点都为空，无需进行下列操作，直接返回一个空集合
       if (root == null) return;
       // 前序遍历:根结点-左子结点-右子结点
       // 因为之前已经判断过根结点不为空，所以先直接添加
       list.add(root.getData());
       // 进行左树递归
       preordertrans(root.getLeft(), list);
       // 进行右树递归
       preordertrans(root.getRight(), list);
       // 结束递归，返回结果集
       return list;
   }


    public List<T> preorder(TreeNode<T> root) {
        return preordertrans(root, new ArrayList<T>());
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    private List<T> inordertrans(TreeNode<T> root, List<T> list) {
       // 若根结点都为空，无需进行下列操作，直接返回一个空集合
       if (root == null) return;
       // 前序遍历:根结点-左子结点-右子结点
       // 因为之前已经判断过根结点不为空，所以先直接添加

       // 进行左树递归
       inordertrans(root.getLeft(), list);
       list.add(root.getData());
       // 进行右树递归
       inordertrans(root.getRight(), list);
       // 结束递归，返回结果集
       return list;
    }


    public List<T> inorder(TreeNode<T> root) {
      return inordertrans(root, new ArrayList<T>());
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    private List<T> postordertrans(TreeNode<T> root, List<T> list) {
        // 若根结点都为空，无需进行下列操作，直接返回一个空集合
        if (root != null)
        // 前序遍历:根结点-左子结点-右子结点
        // 因为之前已经判断过根结点不为空，所以先直接添加

        // 进行左树递归
        postordertrans(root.getLeft(), list);

        // 进行右树递归
        postordertrans(root.getRight(), list);
        list.add(root.getData());
        // 结束递归，返回结果集
        return list;
     }

    public List<T> postorder(TreeNode<T> root) {
      return postordertrans(root, new ArrayList<T>());
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    public static void main(String[] args) {
        Traversals<Integer> tree = new Traversals<>(); // don't omit generic parameter

        TreeNode<Integer> root = new TreeNode<>(50);
        TreeNode<Integer> a = new TreeNode<>(25);
        TreeNode<Integer> b = new TreeNode<>(10);
        TreeNode<Integer> c = new TreeNode<>(100);
        TreeNode<Integer> d = new TreeNode<>(75);
        TreeNode<Integer> e = new TreeNode<>(125);
        TreeNode<Integer> f = new TreeNode<>(110);

        root.setLeft(a);
        a.setLeft(b);
        root.setRight(c);
        c.setLeft(d);
        c.setRight(e);
        e.setLeft(f);

        List<Integer> preorderNodes = tree.preorder(root);

        for (Integer node : preorderNodes) {
            System.out.println(node);
        }
    }
}
