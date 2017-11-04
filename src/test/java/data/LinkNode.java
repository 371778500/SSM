package data;
/**
 * 单链表数据结构
 * @author luochp3
 *
 * @param <E>
 */
public class LinkNode<E>{
	E item;
	LinkNode<E> next;

    //构造函数
	LinkNode(E element) {
       this.item = element;
       this.next = null;
   }
	//判断是否有下一个
	public boolean hasNext(){
		if(this.next==null){
			return false;
		}
		return true;
	}
}
