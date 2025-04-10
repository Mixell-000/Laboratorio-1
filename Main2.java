import java.util.*;
import java.io.*;

//me olvide de mandar el avance anteriormente, aqui esta

class BigVigenere {
    
    int[] key;
    char[][] alfabeto;
    String caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 ";
    int Tamanno = caracteres.length();
    
    // Método para generar la matriz del alfabeto
    public static char[][] CreadorDeMatriz(){
    	
		String VocabuPapu1 = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890 "; // la cantidad de caracteres puede cambiar, de nada papus (-> VocabuPapu.length())
		String VocabuPapu = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890 "; 

		char[] arr =new char [VocabuPapu.length()];
		
		char[][] PAPUGENERADOR = new char [VocabuPapu1.length()] [VocabuPapu1.length()];
		
		for(int i = 0; i < VocabuPapu.length();i++){ //En este for se chanta todo VocabuPapu en el array "arr" xD
			arr[i] = VocabuPapu.charAt(i);
			}

        for(int i = 0; i < VocabuPapu.length(); i++){
            PAPUGENERADOR[i][0] = VocabuPapu1.charAt(i); //Es una fila con diferentes caracteres porque está el cuadradito
        }
        
		for(int a = 0; a < VocabuPapu.length()-1; a++){ //a en este caso es el numero de la linea en la que están~
		    for(int i = 0; i<VocabuPapu.length(); i++){ //esta cagada recorre la fila de derecha a izquierda
		                
		                    
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

    key = new int[MiKey.length()]; // <-- inicializar arreglo con el tamaño adecuado

    for (int n = 0; n < MiKey.length(); n++) {
        key[n] = caracteres.indexOf(MiKey.charAt(n));
    }

    this.alfabeto = CreadorDeMatriz();
}

    public String encrypt(String message) {
        
        
        
             StringBuilder encryptedMessage = new StringBuilder();
    int LargoKey = key.length;

    // Recorrer cada carácter del mensaje
    for (int k = 0; k < message.length(); k++) {
        char mensajeChar = message.charAt(k);

        // Buscar la posición del carácter del mensaje en la matriz alfabeto
        int messagePos = -1;
        for (int m = 0; m < Tamanno; m++) {
            for (int n = 0; n < Tamanno; n++) {
                if (alfabeto[m][n] == mensajeChar) {
                    messagePos = n;
                    break;
                }
            }
            if (messagePos != -1) break; // Salir si encontramos la posición
        }

        // Buscar la posición correspondiente de la clave
        int keyPos = key[k % LargoKey]; // La clave se repite si es más corta que el mensaje
        keyPos = keyPos % Tamanno; // Ajustamos la posición de la clave para que no se salga del tamaño del alfabeto

        // Cifrar el carácter usando la matriz alfabeto
        int encryptedPos = (messagePos + keyPos) % Tamanno;
        encryptedMessage.append(alfabeto[0][encryptedPos]); // Asumimos que usamos la primera fila para obtener el carácter cifrado
    }

    return encryptedMessage.toString();
}

    
    public String decrypt(String encryptedMessage) {
    StringBuilder decryptedMessage = new StringBuilder();
    int LargoKey = key.length;

    for (int k = 0; k < encryptedMessage.length(); k++) {
        char mensajeChar = encryptedMessage.charAt(k);

        // Encontrar la posición del carácter cifrado en la primera fila del alfabeto
        int encryptedPos = -1;
        for (int i = 0; i < Tamanno; i++) {
            if (alfabeto[0][i] == mensajeChar) {
                encryptedPos = i;
                break;
            }
        }

        // Obtener la posición de la clave
        int keyPos = key[k % LargoKey];
        keyPos = keyPos % Tamanno;

        // Calcular posición original
        int originalPos = (encryptedPos - keyPos + Tamanno) % Tamanno;

        // Buscar en la primera columna de la matriz para obtener el carácter original
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
    int[] claveAntigua = key; // opcional, por si quieres volver atrás
    key = nuevaKey; // se reemplaza la clave actual

    String mensajeNuevoCifrado = encrypt(mensajeOriginal);

    // Paso 6: Imprimir mensaje re-encriptado
    System.out.println("Mensaje re-encriptado con nueva clave: " + mensajeNuevoCifrado);
}


}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Ingrese el mensaje a encriptar: ");
        String message = in.nextLine();  // Leer el mensaje primero
        
        
        BigVigenere Matriz = new BigVigenere();  // El constructor pedirá la clave

        String mensajeCifrado = Matriz.encrypt(message);
        String mensajedesCifrado = Matriz.decrypt(mensajeCifrado);

        System.out.println("Mensaje Original: " + message);
        System.out.println("Mensaje Cifrado: " + mensajeCifrado);
        System.out.println("Mensaje desCifrado: " + mensajedesCifrado);


        System.out.println("._____. RE - ENCRIPTACION._____. :");
        Matriz.reEncrypt();        

        in.close(); // <-- cerrar al final, cuando ya no se necesita
    }
}
