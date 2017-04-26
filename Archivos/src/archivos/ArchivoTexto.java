package archivos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Archivos
 *
 * @author jose - 21.04.2017
 * @Title: ArchivoTexto
 * @Description: description
 *
 * Changes History
 */
public class ArchivoTexto {

	private File primerArchivo = new File("/home/jose/primerArchivo.txt");

	public void verificarInfoArchivo() {
		System.out.println("============= Existe: " + primerArchivo.exists());
	}

	public void escribirEnArchivo() {
		FileOutputStream salida = null;
		String textoSalida = "Hola mndo desde archivo!!";
		try {
			salida = new FileOutputStream(primerArchivo);
			salida.write(textoSalida.getBytes());
		} catch (IOException ex) {
			System.out.println("=========== error al escribir");
		} finally {
			try {
				salida.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}

	}

	public void lecturaBasica(String path) {
		FileInputStream entrada = null;
		File contenedor = new File(path);
		if (contenedor.exists()) {//validacion si existe archivo
			try {
				entrada = new FileInputStream(contenedor);
				int byteEntrada = entrada.read();
				while (byteEntrada != -1) {
					
					//System.out.write(byteEntrada);
					System.out.println(byteEntrada);
					byteEntrada = entrada.read();
				}

			} catch (IOException ex) {
				System.out.println("No se puede leer archivo");
			} finally {
				try {
					entrada.close();
				} catch (IOException ex) {
					System.out.println("========no se pudo cerrar archivo");
				}
			}
		} else {
			System.out.println("========ARCHIVO NO EXISTE!!");
		}
	}

	public void lecturaDataBasica(String path) {
		FileInputStream entradaBase = null;
		DataInputStream entrada = null;
		try {
			entradaBase = new FileInputStream(new File(path));
			entrada = new DataInputStream(entradaBase);
			String cadenaTotal = "";
			int total = 0;
			String data = entrada.readLine();
			//Integer data = entrada.readInt();
			while (data != null) {
				cadenaTotal = cadenaTotal + data;
				//total += data;
				data = entrada.readLine();
				//data = entrada.readInt();

			}
			System.out.print(cadenaTotal);
			//System.out.print(total);

		} catch (EOFException ex) {
			System.out.println("Lectura finalizada");
		} catch (IOException ex) {
			System.out.println("No se puede leer archivo");
		} finally {
			try {
				entrada.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}
	}
	
	public void escribirData() {
		int entero = 10;
		boolean booleano = true;
		String cadena = "Cadena";
		double doble = 125.25;
		DataOutputStream salidaData = null;
		try {
			FileOutputStream salida = new FileOutputStream(new File("/home/jose/binariotest.txt"));
			salidaData = new DataOutputStream(salida);
			salidaData.writeInt(entero);
			salidaData.writeBoolean(booleano);
			salidaData.writeUTF(cadena);
			salidaData.writeDouble(doble);
		} catch (Exception e) {
			System.out.println("=========== error");
		} finally {
			try {
				salidaData.close();
			} catch (IOException ex) {
				Logger.getLogger(ArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		
	}

	public void lecturaParaCaracteres(String path) {
		FileReader lector = null;
		BufferedReader buffer = null;
		try {
			lector = new FileReader(new File(path));
			buffer = new BufferedReader(lector);
			String data = buffer.readLine();
			while (data != null) {
				System.out.println(data);
				data = buffer.readLine();

			}

		} catch (EOFException ex) {
			System.out.println("Lectura finalizada");
		} catch (IOException ex) {
			System.out.println("No se puede leer archivo");
		} finally {
			try {
				buffer.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}
	}

	public void escrituraParaCaracteres(String textoAEscribir, String pathArchivo) {
		FileWriter escritor = null;
		try {
			escritor = new FileWriter(new File(pathArchivo));
			escritor.write(textoAEscribir);
		} catch (IOException e) {
			System.out.println("============== error escribiendo en archivo");
		} finally {
			try {
				escritor.close();
			} catch (IOException ex) {
				System.out.println("========no se pudo cerrar archivo");
			}
		}

	}
}
