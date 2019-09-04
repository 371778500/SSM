package data;
/**
 * 对链表进行操作
 * @author luochp3
 * @param <E>
 */
public class OperationLinkNode <E>{
	LinkNode<E> head = null;
	LinkNode<E> tail = null;
	
	//初始化链表
	public void init(){
		LinkNode<E> head = null;
		LinkNode<E> tail = null;
	}
	
	//链表添加元素
	public void addNode(){
		LinkNode node=new LinkNode("test");
		if(head==null){
			head=node;
		}
		if(tail==null){
			tail=node;
		}else{
			tail.next=node;
			tail=node;
		}
	}
	
	//遍历链表
	public void readLink(){
		LinkNode<E> current = head;
		while (current != null) {
		    System.out.println(current.item);
		    current = current.next;
		}
	}
	
	//倒序遍历链表主要用了递归的思想
	static void printListRev(LinkNode<String> head) {
	    if (head != null) {
	        printListRev(head.next);
	        System.out.println(head.item);
	    }
	}
	
	//单链表反转
	static void RevList(LinkNode<String> current,LinkNode<String> prev) {
		if(current!=null){
			RevList(current.next,current);
			current.next=prev;
		}
	}
}
