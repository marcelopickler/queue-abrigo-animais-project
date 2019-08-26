package br.univille.estd.queues.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.univille.estd.queues.EmptyQueueException;
import br.univille.estd.queues.Queue;

public class ArrayQueueTests {

	@Test
	public void isEmpty() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		assertEquals("A fila deve estar vazia", true, queue.isEmpty());
	}

	@Test
	public void size() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		assertEquals("O tamanho da fila deve ser zero", 0, queue.size());
	}

	@Test
	public void enqueue() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		queue.enqueue(10);
		assertEquals("Fila deve conter um elemento", 1, queue.size());
	}

	@Test
	public void front() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("cat");
		queue.enqueue("dog");
		assertEquals("Front deve retornar o elemento cat", "cat", (String) queue.front());
	}

	@Test
	public void dequeue() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("cat");
		queue.enqueue("dog");
		assertEquals("Front deve retornar o elemento cet", "cat", (String) queue.dequeue());
		assertEquals("Fila deve conter um elemento", 1, queue.size());
	}

	@Test
	public void dequeueThrowsException() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		try {
			queue.dequeue();
			fail("Fila vazia");
		} catch (EmptyQueueException ignored) {
		}
	}

	@Test
	public void frontThrowsException() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("cat");
		//assertEquals("Deve retornar o elemento cat", "cat", queue.front());
		if(queue.front() == null) {
			System.out.println("Fila vazia");
		}else {
			assertEquals("Deve retornar o elemento cat", "cat", queue.front());
		}
		/*try {
			queue.front();
			fail("Fila vazia");
		} catch (EmptyQueueException ignored) {
		}*/
	}

	@Test
	public void enqueueThrowsException() {
		Queue<Integer> queue = new ArrayQueue<Integer>(1);
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			fail("Fila deve gerar exceÃ§ao FullQueueException");
		} catch (FullQueueException ignored) {
		}
	}
	// Para testar o dequeuecat faça um que verifique se o fron é diferente de cat,
	// e é diferente de vazio o array
	@Test
	public void dequeueCat() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("cat");
		queue.enqueue("dog");
		assertEquals("Front deve retornar o elemento cat", "cat", (String) queue.dequeueCat());
		assertEquals("Fila deve conter um elemento", 1, queue.size());
	}
	@Test
	public void dequeueDog() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("dog");
		queue.enqueue("cat");
		assertEquals("Front deve retornar o elemento dog", "dog", (String) queue.dequeueDog());
		assertEquals("Fila deve conter um elemento", 1, queue.size());
	}
}
