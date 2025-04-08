import java.util.*;
import java.io.*;
		//Aquí vamos poniendo nuestro codigo principal a partir de los codigos secundarios que hemos hecho.

public class Main
{
	public static char[][] CreadorDeMatriz(){
		
		String VocabuPapu1 = "⊡abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // la cantidad de caracteres puede cambiar, de nada papus (-> VocabuPapu.length())
		String VocabuPapu = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; 

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
	
	public static void main(String[] args) {
    
  }

	
}
