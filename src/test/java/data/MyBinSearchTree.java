package data;
/**
 * �����������ʵ��
 * 
 * @author luochp3
 *
 * @param <E>
 */
public class MyBinSearchTree<E extends Comparable<E>> {

    // ��
    private TreeNode2<E> root;

    // Ĭ�Ϲ��캯��
    public MyBinSearchTree() {
    }

    // ���������������
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

    // ����������Ĳ���
    public boolean insert(E e) {

        // ���֮ǰ�ǿն����� �����Ԫ�ؾ���Ϊ���ڵ�
        if (root == null) {
            root = createNewNode(e);
        } else {
            // ����ʹӸ��ڵ㿪ʼ���� ֱ���ҵ����ʵĸ��ڵ�
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
            // ����
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }
        return true;
    }

    // �����µĽڵ�
    protected TreeNode2<E> createNewNode(E e) {
        return new TreeNode2(e);
    }

}

// �������Ľڵ�
class TreeNode2<E extends Comparable<E>> {

    E element;
    TreeNode2<E> left;
    TreeNode2<E> right;

    public TreeNode2(E e) {
        element = e;
    }
}

