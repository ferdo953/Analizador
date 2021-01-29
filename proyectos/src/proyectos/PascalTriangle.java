/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author f-er9
 */
/* Programa para imprimir el triángulo de Pascal en Java */

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        String ruta = "C:/Users/Public/archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        BufferedReader br;
        try{
            if(archivo.exists()) {
                 bw = new BufferedWriter(new FileWriter(archivo));
            }else {           
                 bw = new BufferedWriter(new FileWriter(archivo)); 
            }
            int rows = 10; //Aquí establecemos número de filas Integer.parseInt(args[0]);
            System.out.println("¿De cuantos pisos quiere la torre?");
            rows = f.nextInt();
            int otro=rows;
            int guardar4[]=new int[1]; 
            for (int i = 0; i < rows; i++) {
                
                int guardar3[]=new int[15]; 
                System.out.format("%"+otro+"s","");
                 for (int k = 0; k < otro; k++) {
                        bw.write(" ");
                 }
                otro--;
                for (int j = 0; j <= i; j++) {
                     if(j==0 || j==(i)){
                         guardar3[j]=1;
                     }else{
                         guardar3[j]=guardar4[j]+guardar4[j-1];

                     } 
                     System.out.print(guardar3[j]+" ");
                    
                     bw.write(guardar3[j]+" ");
                 } 
                 bw.write("\n");
                 System.out.println();
                 guardar4=guardar3;

            }
        bw.close();    
            
        FileReader fa = new FileReader(archivo);
        br = new BufferedReader(new BufferedReader(fa));
        
        
        System.out.println("¿Cuantas filas quiere contar?");
        int filas=f.nextInt();
        int contar=0,contarfila=0,numero=1; 
        String palabra="";
        while((palabra = br.readLine()) !=null){
            if(filas==0){
                break;
            }
            StringTokenizer tokens =  new StringTokenizer(palabra);
                int ntoken=tokens.countTokens();
                for (int i = 0; i < ntoken ; i++) {
                    contarfila=contarfila+Integer.parseInt(tokens.nextToken());
                    if(!tokens.hasMoreTokens()){
                        break;
                    }
                }
                System.out.println("La fila "+numero+" suma: "+ contarfila);
                contar+=contarfila;
                contarfila=0; filas--; numero++;
        }
            System.out.println("La suma del numero de filas indicadas es: "+contar);
        br.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
}