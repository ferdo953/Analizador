/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author f-er9
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner f = new Scanner(System.in);
        String ruta = "C:/Users/f-er9/OneDrive/Documents/Triangulo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        BufferedReader br;
        int n=2;
        int cont=0,total=0;
         try{
            while(cont < 15){
            FileReader fa = new FileReader(archivo);
            br = new BufferedReader(new BufferedReader(fa));
            String palabra ="";
            int contador=0;
            int contando=1,contando2=1,auxiliar=0;
            while((palabra = br.readLine()) !=null){
               
                StringTokenizer tokens =  new StringTokenizer(palabra);
                    int ntoken=tokens.countTokens();
                    for (int i = 0; i < ntoken ; i++) {
                        if(contando >= 1 && contando <= n){
                            
                            contador+=Integer.parseInt(tokens.nextToken());
                            contando++;
                            break;
                        }else{
                            if(auxiliar==contando2){
                                contador+=Integer.parseInt(tokens.nextToken());
                            }else{
                                tokens.nextToken();
                            }
                            auxiliar++;
                        }
                        
                        
                        if(!tokens.hasMoreTokens()){
                            break;
                        }
                    } 
                    
                    if(contando==n){
                        contando++;
                    }else if(contando>n){
                        contando2++;
                    }
                     auxiliar=0;
                   
        } 
           if(contador>total){
               total=contador;
           }
           
           n++; 
           cont++;
         }     
         }catch(Exception e){ e.printStackTrace();} 
         System.out.println("La suma total mas grande es: "+total);
         
            
         
    }
    
}
