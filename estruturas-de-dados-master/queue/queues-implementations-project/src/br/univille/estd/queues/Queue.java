package br.univille.estd.queues;

public interface Queue<E> {
	
	long size();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E front();
	E viewlast();
	E dequeueCat();
	E dequeueDog();
	E dequeueAny();
}
