package main;

import java.text.DecimalFormat;

public class Resultado {
	private static int normal = 0;
	private static int prediabetes = 0;
	private static int diabetes = 0;
	
	private static DecimalFormat df = new DecimalFormat("#.0");

	public static void clasificarResultados(int[] resultados) {		
		for (int r : resultados) {
			if (r<100) { normal++; }
			else if (r<126) { prediabetes++; }
			else { diabetes++; }
		}
		
		System.out.println("Clasificacion de resultados: ");
		System.out.println("Normal: "+ df.format(resultPorcentual(normal, resultados.length)) +"%");
		System.out.println("Prediabetes: "+ df.format(resultPorcentual(prediabetes, resultados.length)) +"%");
		System.out.println("Diabetes: "+ df.format(resultPorcentual(diabetes, resultados.length)) +"%");
	}
	
	public static double resultPorcentual(int valor, int total) {
		return (valor*100.0)/total;
	}
}
