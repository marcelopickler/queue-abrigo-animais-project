package br.univille.estd.queues.array;

import br.univille.estd.queues.EmptyQueueException;
import br.univille.estd.queues.Queue;

public class ArrayQueue<E> implements Queue<E> {

	protected int f = 0;
	protected int r = 0;
	public static final int CAPACITY = 1000;
	protected int capacity;
	protected E Q[];

	public ArrayQueue() {
		this(CAPACITY);
	}

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		Q = (E[]) new Object[this.capacity];
	}

	@Override
	public long size() {
		return (capacity - f + r) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return (f == r);
	}

	@Override
	public void enqueue(E e) {
		if (size() == (capacity - 1)) {
			throw new FullQueueException("Fila cheia!");
		} else {
			Q[r] = e;
			r = (r + 1) % capacity;
		}
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		}
		E temp = Q[f];
		Q[f] = null;
		f = (f + 1) % capacity;
		return temp;
	}

	@Override
	public E front() {

		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		}
		return Q[f];
	}

	public E viewlast() {

		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		}
		return Q[((capacity - f + r) % capacity) - 1];
		// Acontece algo errado quando é feito um dequeue
	}

	@Override
	public E dequeueCat() {
		String value = "cat";
		long i = 0;
		E temp = null;
		// System.out.println();
		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		} else {
			if (Q[(int) i] != value) /* verifica se o valor é igual a gato */ {
				i++; // se não for, passa para o proximo índice
			} else {
				f = (int) i;
				temp = Q[f]; // variavel temp recebe o valor que estava na posição i, f = i
				Q[f] = null; // posição f da fila se torna vazia
				f = (f + 1) % capacity;
				// System.out.println("passou aqui");

			}
		}
		// System.out.println("passou aqui");
		return temp;

	}

	@Override
	public E dequeueDog() {
		String value = "dog";
		long i = 0;
		E temp = null;
		// System.out.println();
		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		} else {
			if (Q[(int) i] != value) /* verifica se o valor é igual a cachorro */ {
				i++; // se não for, passa para o proximo índice
			} else {
				f = (int) i;
				temp = Q[f]; // variavel temp recebe o valor que estava na posição i, f = i
				Q[f] = null; // posição f da fila se torna vazia
				f = (f + 1) % capacity;
				// return temp;

			}
		}
		// System.out.println("passou aqui");
		return temp;

	}

	@Override
	public E dequeueAny() {
		if (isEmpty()) {
			throw new EmptyQueueException("Fila vazia!");
		}
		E temp = Q[f];
		Q[f] = null;
		f = (f + 1) % capacity;
		return temp;
	}

}
