package data;
/**
 * ��������в���
 * @author luochp3
 * @param <E>
 */
public class OperationLinkNode <E>{
	LinkNode<E> head = null;
	LinkNode<E> tail = null;
	
	//��ʼ������
	public void init(){
		LinkNode<E> head = null;
		LinkNode<E> tail = null;
	}
	
	//�������Ԫ��
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
	
	//��������
	public void readLink(){
		LinkNode<E> current = head;
		while (current != null) {
		    System.out.println(current.item);
		    current = current.next;
		}
	}
	
	//�������������Ҫ���˵ݹ��˼��
	static void printListRev(LinkNode<String> head) {
	    if (head != null) {
	        printListRev(head.next);
	        System.out.println(head.item);
	    }
	}
	
	//������ת
	static void RevList(LinkNode<String> current,LinkNode<String> prev) {
		if(current!=null){
			RevList(current.next,current);
			current.next=prev;
		}
	}
}
