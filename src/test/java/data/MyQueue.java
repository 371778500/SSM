package data;

import java.util.LinkedList;
/**
 * ʹ��LinkedListʵ�ֶ���
 * @author luochp3
 *
 * @param <E>
 */

public class MyQueue<E> {
		
	private LinkedList<E> queue=new LinkedList<>();
	
	//���
	public void enQueue(E e){
		queue.add(e);
	}
	
	//����
	public E deQueue(){
		return queue.removeFirst();
	}
}
