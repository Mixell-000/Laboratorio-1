import java.util.*;
import java.io.*;
		//Tamos casi listos, ahora solo nos queda cambiar los system out a Array y estamos al otro lado!

public class Main
{
	public static void main(String[] args) {
		
		String VocabuPapu = "⊡abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // la cantidad de caracteres puede cambiar, de nada papus (-> VocabuPapu.length())
		char LAWEAITA = '⊡' ;

		char[] arr =new char [VocabuPapu.length()];
		
		char[][] PAPUGENERADOR = new char [VocabuPapu.length()] [VocabuPapu.length()];
		
		for(int i = 0; i < VocabuPapu.length();i++){ //En este for se chanta todo VocabuPapu en el array "arr" xD
		
		arr[i] = VocabuPapu.charAt(i);
		
		}
		
        
		for(int a = 0; a < VocabuPapu.length(); a++){ //a en este caso es el numero de la linea en la que están~
		

		    for(int i = 0; i<VocabuPapu.length(); i++){ //esta cagada recorre el array de derecha a izquierda
		                
		                if(i!=0 && a !=0 && arr[(i+a) % VocabuPapu.length()] == LAWEAITA)  {
		                    System.out.print(". ");
		                }else{
		                    PAPUGENERADOR[i][a] = arr[(i+a) % VocabuPapu.length()];
		                        System.out.print(PAPUGENERADOR[i][a] + " ");
		                
		                }
		                        
                }
                System.out.println();
		}
		
		
	}
}