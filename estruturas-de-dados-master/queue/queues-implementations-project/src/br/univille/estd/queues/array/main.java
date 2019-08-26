package br.univille.estd.queues.array;

import br.univille.estd.queues.Queue;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int guarda = 0;
		String hold;
		String valor = "dog";
		String valor1 = "cat";
		// String valor3=("javali"); Isso foi teste, rs

		ArrayQueue<String> fila = new ArrayQueue<>();
		// Animais disponíveis
		fila.enqueue(valor1); // d
		fila.enqueue(valor);// c
		fila.enqueue(valor1);// d
		fila.enqueue(valor);// d
		fila.enqueue(valor1);// c
		fila.enqueue(valor1);// d
		fila.enqueue(valor);// d

		// fila.dequeue();
		if (fila.size() == 0) {
			System.out.println("Desculpe, não temos animais para adoção");
		} else {
			System.out.println("Deseja adotar um gato ou um cachorro?");
			System.out.println("Para gato digite cat");
			System.out.println("Para cachorro digite dog");
			System.out.println("Para indiferente digite outro");
			Scanner scan = new Scanner(System.in); // Create a Scanner object
			String animal = scan.next();
			// System.out.println(animal);
			//System.out.println(fila.front()); // TESTE PARA VERIFICAR PRIMEIRO ANIMAL DA FILA ANTES DO DEQUEUE
			// while(guarda <= 0) {
			hold = fila.front();
			if (animal.equals("cat")) { // por algum motivo o input nao entra aqui
				fila.dequeueCat();
				// System.out.println("Parabéns, você adotou um gato!!");
				// guarda++;
			} else {
				if (animal.equals("dog")) { // por algum motivo o input nao entra aqui
					fila.dequeueDog();
					System.out.println("Parabéns, você adotou um cachorro!!");
					// guarda++;
				} else {
					if (animal.equals("outro")) {
						fila.dequeueAny();
						System.out.println("Parabéns, você adotou seu animal!!");
					} else {
						System.out.println("Valor inválido, favor digitar cat para gato ou dog para cachorro.");
						// break;
					}
				}
			}
			// guarda=0;
		} // System.out.println(fila.front()); //TESTE PARA VERIFICAR PRIMEIRO ANIMAL DA
			// FILA DEPOIS DO DEQUEUE
	}

}
//}
