/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosalrevez;

import java.util.Scanner;

/**
 *
 * @author f-er9
 */
public class NumerosAlrevez {

    
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        String numero = "0";
        int activar = 0;
      
            System.out.println("Digita un numero de 3 digitos entre el rango -2^31 a 2^31");
            numero = f.nextLine();
            if(Double.parseDouble(numero)>=-2147483648  && Double.parseDouble(numero)<=2147483647){
                 
            }else{
                System.out.println("0");
                numero="";
            }
        
        String guardar = "";
        for (int i = numero.length()-1; i >= 0; i--) {
            if(String.valueOf(numero.charAt(i)).equals("-")){
                activar = 1;
            }else{
                guardar = guardar + String.valueOf(numero.charAt(i)) ;
            }
        }
        
        if(activar==1){
            System.out.println("-"+guardar);
        }else{
            System.out.println(guardar);
        }
        
        
    }
    
}
