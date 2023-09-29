package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class ArchivoService {
	int contador = 0;
	String rutaFolder = "";
	
	public ArchivoService(String rutaF) {
		rutaFolder = rutaF;
	}
	
	public String crearArchivo(double saldo, String banco, int cuenta) {
		contador++;
		String nombre = "Cuenta"+contador+".txt";
		String ruta = rutaFolder + nombre;
		File archivo = new File(ruta);
		try {
			FileWriter writer = new FileWriter(ruta);
			if (saldo<=5000) {
				writer.write("Banco de origen: "+banco+"\nLa cuenta con el nro de cuenta: "+cuenta+" no tiene un saldo superior a 5000.00.\nLamentablemente no podrá acceder al concurso de la SBS por 10000.00 soles.\nGracias");
				writer.close();
				return ruta;
			} else {
				writer.write("Banco de origen: "+banco+"\nLa cuenta con el nro de cuenta: "+cuenta+" tiene un saldo de "+saldo+"\nUsted es apto a participar en el concurso de la SBS por 10000.00 soles.\nSuerte!");
				writer.close();
				return ruta;
			}
		} catch (IOException e) {
			System.out.println("Error en la creacion del archivo: "+ e.getMessage());
			return "";
		}
	}
	
	public String readJSONFile(String jsonFilePath) {
		try {
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
			JSONArray jsonArray = new JSONArray(jsonContent);
			
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				if (jsonObject.getBoolean("estado")) {
					crearArchivo(jsonObject.getDouble("saldo"), jsonObject.getString("banco"), jsonObject.getInt("nro_cuenta"));
				}
			}
			return jsonContent;
		} catch (Exception e) {
			System.out.println("Ocurrió un error al procesar el archivo JSON: "+e.getMessage());
			return null;
		}
	}
}
