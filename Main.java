import java.util.*;
import java.io.*;
		//Tamos casi listos, ahora solo nos queda cambiar los system out a Array y estamos al otro lado!

public class Main
{
	public static void main(String[] args) {
		
		String VocabuPapu = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // la cantidad de caracteres puede cambiar, de nada papus (-> VocabuPapu.length())
		char[] arr =new char [VocabuPapu.length()];
		
		for(int i = 0; i < VocabuPapu.length();i++){ //En este for se chanta todo VocabuPapu en el array "arr" xD
		arr[i] = VocabuPapu.charAt(i);
		}
		
		int counter = 0; //PapuContador, se asegura que solo haya "VocabuPapu.length()" caracteres en cada cola
		
		for(int a = 0; a < VocabuPapu.length(); a++){ //a en este caso es el numero de la linea en la que están~
		
		              counter = 0; //Se reinicia el papucontador
		              
		    for(int i = 0; i<VocabuPapu.length(); i++){ //esta cagada recorre el array de derecha a izquierda
		        
		       int PapuReiniciador = (i+a) % VocabuPapu.length(); //esto hace que cuando se exceda del limite no empiece de cero el arary
		                        
		                        System.out.print(arr[PapuReiniciador] + " ");
		                        counter ++;
                }
                System.out.println();
		}
		
		
	}
}