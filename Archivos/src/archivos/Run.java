/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author jose
 */
public class Run {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String textoAEscribir = "Este es un nuevo texto a escribir,\n"
			   + "y contiene saltos de linea\n"
			   + "y mas texto.\n"
			   + "\n"
			   + "por cierto, Hola Mundo usando git!!";
		
		ArchivoTexto archivo = new ArchivoTexto();
		//archivo.verificarInfoArchivo();
		//archivo.lecturaBasica("/home/jose/test.txt");
		//archivo.lecturaDataBasica("/home/jose/test.txt");
		//archivo.escribirData();
		//archivo.escribirData();
		//archivo.leerData();
		
		//archivo.escrituraParaCaracteres(textoAEscribir, "/home/jose/test2.txt");
		archivo.lecturaParaCaracteres("/home/jose/lectura.txt");
		
		
	}
	
}
