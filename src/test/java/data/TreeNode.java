package data;

/**
 * 
 * ������
 * @author luochp3
 *
 * @param <E>
 */
public class TreeNode<E> {

	E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
}
