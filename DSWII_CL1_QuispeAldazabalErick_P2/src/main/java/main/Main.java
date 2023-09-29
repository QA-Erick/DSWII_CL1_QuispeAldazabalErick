package main;

import services.ArchivoService;

public class Main {

	public static void main(String[] args) {
		String rutaFolder = "A:\\TestP2\\";
		ArchivoService service = new ArchivoService(rutaFolder);
		service.readJSONFile(rutaFolder+"/cuentas.json");
		System.out.println("Operacion finalizada exitosamente!");
	}

}
