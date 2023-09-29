package main;

public class Main {

	public static void main(String[] args) {
		final int[] array1 = new int[10];
		final int[] array2 = new int[10];
		final int[] array3 = new int[10];
		
		Thread hilo1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < array1.length; i++) {
					array1[i] = (int)(Math.random() * (201-30) + 30);
				}
			}
		});
		
		Thread hilo2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < array2.length; i++) {
					array2[i] = (int)(Math.random() * (201-30) + 30);
				}
			}
		});
		
		Thread hilo3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < array3.length; i++) {
					array3[i] = (int)(Math.random() * (201-30) + 30);
				}
			}
		});
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int[] arrayFinal = new int[30];
		System.arraycopy(array1, 0, arrayFinal, 0, array1.length);
		System.arraycopy(array2, 0, arrayFinal, array1.length, array2.length);
		System.arraycopy(array3, 0, arrayFinal, array1.length + array2.length, array3.length);
		
		Resultado.clasificarResultados(arrayFinal);
	}
}
