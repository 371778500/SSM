package data;
/**
 * 二叉查找树的实现
 * 
 * @author luochp3
 *
 * @param <E>
 */
public class MyBinSearchTree<E extends Comparable<E>> {

    // 根
    private TreeNode2<E> root;

    // 默认构造函数
    public MyBinSearchTree() {
    }

    // 二叉查找树的搜索
    public boolean search(E e) {

        TreeNode2<E> current = root;

        while (current != null) {

            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    // 二叉查找树的插入
    public boolean insert(E e) {

        // 如果之前是空二叉树 插入的元素就作为根节点
        if (root == null) {
            root = createNewNode(e);
        } else {
            // 否则就从根节点开始遍历 直到找到合适的父节点
        	TreeNode2<E> parent = null;
        	TreeNode2<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            // 插入
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }
        return true;
    }

    // 创建新的节点
    protected TreeNode2<E> createNewNode(E e) {
        return new TreeNode2(e);
    }

}

// 二叉树的节点
class TreeNode2<E extends Comparable<E>> {

    E element;
    TreeNode2<E> left;
    TreeNode2<E> right;

    public TreeNode2(E e) {
        element = e;
    }
}

