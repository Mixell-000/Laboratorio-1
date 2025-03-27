import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
	    char A = 'A';
	    char B = 'B';
	    char a = 'a';
	    int potA = A;
	    int potB = B;
	    int pota = a;
	    
	    
		//System.out.print(potA - 65 + " (" + potA + ")");
		//System.out.print(" ");
		//System.out.print(potB - 65);
		//System.out.print(" ");
		//System.out.print(pota - 97);
		
		
		Scanner Poto = new Scanner(System.in);
	    System.out.println("dime una letra");
	    
	    String Letra = Poto.nextLine();
	    
	    for(int i = 0; i < Letra.length(); i++){
	        int xD = Letra.charAt(i);
	    
	    if(xD > 91){
	        System.out.println(xD - 97 + "<- Se va pa la matriz de minusculas");
	    }else{
	        System.out.println(xD - 65 + "<- Se va pa la matriz de Mayusculas");
	    }
	    }
	    
        
	}
}
