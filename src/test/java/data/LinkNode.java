package data;
/**
 * ���������ݽṹ
 * @author luochp3
 *
 * @param <E>
 */
public class LinkNode<E>{
	E item;
	LinkNode<E> next;

    //���캯��
	LinkNode(E element) {
       this.item = element;
       this.next = null;
   }
	//�ж��Ƿ�����һ��
	public boolean hasNext(){
		if(this.next==null){
			return false;
		}
		return true;
	}
}
