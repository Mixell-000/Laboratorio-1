import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {

		
		Scanner Poto = new Scanner(System.in);
	    System.out.println("dime una letra");
	    
	    String x = Poto.nextLine();
	    
	    int[] entrega = new int [x.length()];
	    
	    for(int i = 0; i < x.length(); i++){
	
	    if(x.charAt(i) == 241){
	        
	        entrega[i] = x.charAt(i)- 177;
	        
	    }else if(x.charAt(i) == 209){
	        
	        entrega[i] = x.charAt(i)- 146;
	        
	    }else if(x.charAt(i) > 91){ //en caso de minusculas
	    
	        entrega[i] = x.charAt(i)- 96;
	        
	    }else if(x.charAt(i) > 64){//en caso de mayusculas
	    
	        entrega[i] = x.charAt(i)- 38;
	        
	    }else if(x.charAt(i) > 47){
	        
	        entrega[i] = x.charAt(i) + 5;
	        
	    }else if(x.charAt(i) == 32){
	        entrega[i] = x.charAt(i) + 1000;

	    }
	    }
	    
        	    for(int i = 0; i < x.length(); i++){
        	    
        	        System.out.println(entrega[i]);
        	    }

	}
}
