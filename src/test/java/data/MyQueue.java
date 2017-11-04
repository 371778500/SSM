package data;

import java.util.LinkedList;
/**
 * 使用LinkedList实现队列
 * @author luochp3
 *
 * @param <E>
 */

public class MyQueue<E> {
		
	private LinkedList<E> queue=new LinkedList<>();
	
	//入队
	public void enQueue(E e){
		queue.add(e);
	}
	
	//出队
	public E deQueue(){
		return queue.removeFirst();
	}
}
