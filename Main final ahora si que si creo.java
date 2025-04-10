import java.util.*;
import java.io.*;

//creo q me deje algo de codigo suelto en el discrod igual, para que le den un ojo
//me olvide de mandar el avance anteriormente, aqui esta

class BigVigenere {

	int[] key;
	char[][] alfabeto;
	String caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 ";
	int Tamanno = caracteres.length();

	// MC)todo para generar la matriz del alfabeto
	public static char[][] CreadorDeMatriz() {

		String VocabuPapu1 = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890 "; // la cantidad de caracteres puede cambiar, de nada papus (-> VocabuPapu.length())
		String VocabuPapu = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890 ";

		char[] arr =new char [VocabuPapu.length()];

		char[][] PAPUGENERADOR = new char [VocabuPapu1.length()] [VocabuPapu1.length()];

		for(int i = 0; i < VocabuPapu.length(); i++) { //En este for se chanta todo VocabuPapu en el array "arr" xD
			arr[i] = VocabuPapu.charAt(i);
		}

		for(int i = 0; i < VocabuPapu.length(); i++) {
			PAPUGENERADOR[i][0] = VocabuPapu1.charAt(i); //Es una fila con diferentes caracteres porque estC! el cuadradito
		}

		for(int a = 0; a < VocabuPapu.length()-1; a++) { //a en este caso es el numero de la linea en la que estC!n~
			for(int i = 0; i<VocabuPapu.length(); i++) { //esta cagada recorre la fila de derecha a izquierda


				PAPUGENERADOR[i][a+1] = arr[(i+a) % VocabuPapu.length()];
			}                   // i = fila, a = columna

		}

		return PAPUGENERADOR;


	}

	//aqui dejo que el usuario cree la key y se registre en "key[]", ala vez creo una matriz como se me pide
	public BigVigenere() {
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese clave por utilizar:");
		String MiKey = in.nextLine();

		key = new int[MiKey.length()]; // <-- inicializar arreglo con el tamaC1o adecuado

		for (int n = 0; n < MiKey.length(); n++) {
			key[n] = caracteres.indexOf(MiKey.charAt(n));
		}

		this.alfabeto = CreadorDeMatriz();
	}

	public String encrypt(String message) {



		StringBuilder encryptedMessage = new StringBuilder();
		int LargoKey = key.length;

		// Recorrer cada carC!cter del mensaje
		for (int k = 0; k < message.length(); k++) {
			char mensajeChar = message.charAt(k);

			// Buscar la posiciC3n del carC!cter del mensaje en la matriz alfabeto
			int messagePos = -1;
			for (int m = 0; m < Tamanno; m++) {
				for (int n = 0; n < Tamanno; n++) {
					if (alfabeto[m][n] == mensajeChar) {
						messagePos = n;
						break;
					}
				}
				if (messagePos != -1) break; // Salir si encontramos la posiciC3n
			}

			// Buscar la posiciC3n correspondiente de la clave
			int keyPos = key[k % LargoKey]; // La clave se repite si es mC!s corta que el mensaje
			keyPos = keyPos % Tamanno; // Ajustamos la posiciC3n de la clave para que no se salga del tamaC1o del alfabeto

			// Cifrar el carC!cter usando la matriz alfabeto
			int encryptedPos = (messagePos + keyPos) % Tamanno;
			encryptedMessage.append(alfabeto[0][encryptedPos]); // Asumimos que usamos la primera fila para obtener el carC!cter cifrado
		}

		return encryptedMessage.toString();
	}


	public String decrypt(String encryptedMessage) {
		StringBuilder decryptedMessage = new StringBuilder();
		int LargoKey = key.length;

		for (int k = 0; k < encryptedMessage.length(); k++) {
			char mensajeChar = encryptedMessage.charAt(k);

			// Encontrar la posiciC3n del carC!cter cifrado en la primera fila del alfabeto
			int encryptedPos = -1;
			for (int i = 0; i < Tamanno; i++) {
				if (alfabeto[0][i] == mensajeChar) {
					encryptedPos = i;
					break;
				}
			}

			// Obtener la posiciC3n de la clave
			int keyPos = key[k % LargoKey];
			keyPos = keyPos % Tamanno;

			// Calcular posiciC3n original
			int originalPos = (encryptedPos - keyPos + Tamanno) % Tamanno;

			// Buscar en la primera columna de la matriz para obtener el carC!cter original
			decryptedMessage.append(alfabeto[0][originalPos]);
		}

		return decryptedMessage.toString();
	}



	public void reEncrypt() {
		Scanner in = new Scanner(System.in);

		// Paso 1: Pedir mensaje cifrado actual
		System.out.println("Ingrese el mensaje encriptado actual:");
		String mensajeCifrado = in.nextLine();

		// Paso 2: Desencriptar con la clave actual
		String mensajeOriginal = decrypt(mensajeCifrado);

		// Paso 3: Pedir nueva clave
		System.out.println("Ingrese nueva clave:");
		String nuevaClave = in.nextLine();

		// Paso 4: Generar nuevo arreglo de clave
		int[] nuevaKey = new int[nuevaClave.length()];
		for (int i = 0; i < nuevaClave.length(); i++) {
			nuevaKey[i] = caracteres.indexOf(nuevaClave.charAt(i));
		}

		// Paso 5: Cifrar el mensaje original con la nueva clave
		int[] claveAntigua = key; // opcional, por si quieres volver atrC!s
		key = nuevaKey; // se reemplaza la clave actual

		String mensajeNuevoCifrado = encrypt(mensajeOriginal);

		// Paso 6: Imprimir mensaje re-encriptado
		System.out.println("Mensaje re-encriptado con nueva clave: " + mensajeNuevoCifrado);
	}

	public char search(int position) {
		int filas = alfabeto.length;
		int columnas = alfabeto[0].length;

		// BC:squeda iterativa de izquierda a derecha y de arriba hacia abajo
		int contador = 0;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (contador == position) {
					return alfabeto[i][j];
				}
				contador++;
			}
		}

		// Si no se encuentra la posiciC3n, retornamos un valor por defecto o lanzamos una excepciC3n
		System.out.println("PosiciC3n no vC!lida.");
		return '\0'; // o puedes lanzar una excepciC3n, dependiendo de lo que prefieras
	}

	public char optimalSearch(int position) {
		// Verificar que la posiciC3n sea vC!lida
		if (position < 0 || position >= Tamanno * Tamanno) {
			System.out.println("PosiciC3n no vC!lida.");
			return '\0';  // Retornamos un valor nulo si la posiciC3n no es vC!lida
		}

		// Calcular la fila y la columna de la matriz directamente
		int fila = position / Tamanno;  // DivisiC3n entera para obtener la fila
		int columna = position % Tamanno;  // MC3dulo para obtener la columna

		// Retornar el carC!cter correspondiente en la matriz
		return alfabeto[fila][columna];
	}


}



public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigVigenere Matriz = new BigVigenere();

		while (true) {
			System.out.println("\n.______. MENUwU .______.");
			System.out.println("1. Encriptar un mensaje");
			System.out.println("2. Desencriptar un mensaje");
			System.out.println("3. Re-encriptar mensaje con nueva clave");
			System.out.println("4. Buscar carácter en la matriz (búsqueda normal)");
			System.out.println("5. Buscar carácter en la matriz (búsqueda optima)");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = -1;

			// Será necesario una validación? como soy masoquista igual la pondré.
			try {
				opcion = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Porfa pon un número válido uwu");
				continue;
			}

			switch (opcion) {
				case 1: //encriptar un mensaje
					System.out.print("Ingrese el mensaje a encriptar: ");
					String mensajeAEncriptar = in.nextLine();
					String mensajeCifrado = Matriz.encrypt(mensajeAEncriptar);
					System.out.println("Mensaje Cifrado: " + mensajeCifrado);
					break;

				case 2: //desencriptar un mensaje
					System.out.print("Ingrese el mensaje a desencriptar: ");
					String mensajeADesencriptar = in.nextLine();
					String mensajeDesCifrado = Matriz.decrypt(mensajeADesencriptar);
					System.out.println("Mensaje Desencriptado: " + mensajeDesCifrado);
					break;

				case 3: //Re encriptar un mensaje con nueva key
					Matriz.reEncrypt();
					break;

				case 4://Busqueda Normal
					System.out.print("Ingrese la posición que desea buscar (modo normal): ");
					int pos1 = Integer.parseInt(in.nextLine());
					char caracter1 = Matriz.search(pos1);
					System.out.println("Carácter encontrado: " + caracter1);
					break;

				case 5://Busqueda Pro
					System.out.print("Ingrese la posición que desea buscar (modo optimo): ");
					int pos2 = Integer.parseInt(in.nextLine());
					char caracter2 = Matriz.optimalSearch(pos2);
					if (caracter2 != '\0') {
						System.out.println("Carácter encontrado: " + caracter2);
					}
					break;

				case 6:
					System.out.println("Que tengas buen día! UwU");
					in.close();
					return;

				default:
					System.out.println("Opción inválida, intenta otra vez :3");
			}
		}
	}
}
