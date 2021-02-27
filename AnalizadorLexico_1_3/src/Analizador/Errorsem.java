/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Errorsem {
    ArrayList<String> guardar3 = new ArrayList<String>();
    ArrayList<String> guardar2 = new ArrayList<String>();
    ArrayList<String> guardar4 = new ArrayList<String>();
    ArrayList<String> guardar5 = new ArrayList<String>();
    ArrayList<String> guardar7 = new ArrayList<String>();
    String[] datos3 = new String[2];
    Boolean verdad=true;
    String a,j;
    String TD2 = "(&Flotante&|&Doble&|&Largo&)";
    int b,p,h,k=0,u=0,errsem,l,as;
    String[] datos2 = new String[4];
  
            
            
    
     public Errorsem(ArrayList<String> guardar2,ArrayList<String> guardar4,ArrayList<String> guardar5,int p,String a,int h,int b){
        this.guardar2=guardar2;
        this.guardar4=guardar4;
        this.guardar5=guardar5;
        this.p=p;
        this.errsem=errsem;
        this.a=a;
        this.h=h;
        this.b=b;
    }
    
    public Errorsem(ArrayList<String> guardar3, String a){
        this.guardar3=guardar3;
        this.a=a;
        
    }   
    
    public Errorsem(ArrayList<String> guardar2,ArrayList<String> guardar5, String a,int l,int b){
        this.guardar2=guardar2;
        this.guardar5=guardar5;
        this.a=a;
        this.l=l;
        this.b=b;
    } 
    
    public Errorsem(ArrayList<String> guardar3,ArrayList<String> guardar7, String j){
        this.guardar3=guardar3;
        this.guardar7=guardar7;
        this.j=j;
    } 
   
    
    public Errorsem vardeclaradas(){
        for (int i = 0; i < guardar3.size() ; i++) {
            if(i>0){
                if(guardar3.get(i).equals(a)){ 
                            if(verdad==this.guardar3.get(i-1).matches(TD2)){
                               datos3[1]=this.guardar3.get(i-1);                               
                               this.b=0;
                               break;
                            }else{  
                                if(guardar3.get(i-1).equals(",")){
                                    if(verdad==this.guardar3.get(i-3).matches(TD2)){
                                        datos3[1]=this.guardar3.get(i-3);                               
                                        this.b=0;
                                        break;
                                    }else{
                                        this.b=5; 
                                    }
                                }
                                this.b=5; 
                            }        
                    }
            }else{
                this.b=5;
            }
        }  
        return new Errorsem(guardar3,a);
    }
    
    public Errorsem Nodeclarados(){
       
       if(b==5){
                        k=0;

                        for (int i = 0; i < guardar2.size(); i++) {
                          if((a+p).equals(guardar2.get(i))){
                              
                                if(h>0){ //bandera para que unicamente no entre la primera vez que no tiene nada
                                    for (int j = 0; j < guardar4.size(); j++) {
                                    if((a+p).equals(guardar4.get(j))){                                      
                                       k=3; //si entra quiere decir que hubo algun otro id error que se repitio
                                    }
                                }
                                }
                                
                                if(k==3){
                                    break;
                                }else{  
                                    
                                     break;
                                }
                                
                            }
                        }
                       
                    }
        
        return new Errorsem(guardar2,guardar4,guardar5,p,a,h,b);
    }
    
    public Errorsem declarados2(){ 

       if(b==0){
                        k=0;

                        for (int i = 0; i < guardar2.size(); i++) {
                          if((a+p).equals(guardar2.get(i))){
                                
                                if(h>0){ //bandera para que unicamente no entre la primera vez que no tiene nada
                                    for (int j = 0; j < guardar4.size(); j++) {
                                    if(guardar7.size()>0 && (a+p).equals(guardar7.get(j)+p) ){
                                                k=3;
                                    }else if((a+p).equals(guardar4.get(j))){                                        
                                             k=3;
                                             
  //si entra quiere decir que hubo algun otro id error que se repitio
                                    }
                                }
                                }
                                
                                if(k==3){
                                    break;
                                }else{  
                                    
                                     break;
                                }
                                
                            }
                        }
                       
                    }
        
        return new Errorsem(guardar2,guardar4,guardar5,p,a,h,b);
    }
    
    public Errorsem Declarados(){
     
        if(b==0){
                        u=0; 
                        for (int i = 0; i < guardar2.size(); i++) {
                        if(l>0){ //bandera para que unicamente no entre la primera vez que no tiene nada  
                                    for (int j = 0; j < guardar5.size(); j++) {
                                    if((a).equals(guardar5.get(j))){
                                       u=3; //si entra quiere decir que hubo algun otro id que se repitio
                                    }
                                }
                                }                              
                                if(u==3){
                                 
                                    break;
                                }else{    
                                     
                                    break;
                                }
                            }
                        }
        return new Errorsem(guardar2,guardar5,a,l,b);
    }
    
    public Errorsem Igualacion(){
        guardar7.clear();
        as=5;
        for (int i = 0; i < guardar3.size() ; i++) {
                        
                       
                         if(guardar3.get(i).equals(j)){
                             if(i>0){
                                 if(verdad==guardar3.get(i-1).matches(TD2)){
                                    guardar7.add(guardar3.get(i-1));   
                                    guardar7.add(guardar3.get(i));
                                    as=0;
                                    break;
                               }else{
                                   if(guardar3.get(i-1).equals(",")){
                                       System.out.println("sasaos");
                                        if(verdad==this.guardar3.get(i-3).matches(TD2)){
                                            guardar7.add(guardar3.get(i-3));   
                                            guardar7.add(guardar3.get(i));                             
                                            this.as=0;
                                            break;
                                        }else{
                                            this.as=5; 
                                        }
                                    } 
                                   as=5; 
                               }
                             }else{
                                 as=5;
                             }
                                    
                    }}
        return new Errorsem(guardar3,guardar7,j);
    }
    
    public Errorsem Aritmetico(){
        guardar7.clear();
        as=5;
        for (int i = 0; i < guardar3.size() ; i++) {
                        
                       
                         if(guardar3.get(i).equals(j)){
                            if(i>0){
                                if(verdad==guardar3.get(i-1).matches(TD2)){
                                    guardar7.add(guardar3.get(i-1));      
                                    as=0;
                                    break;
                                }else{
                                    System.out.println("fsaso");
                                   if(guardar3.get(i-1).equals(",")){
                                        if(verdad==this.guardar3.get(i-3).matches(TD2)){
                                            System.out.println("hika");
                                            guardar7.add(guardar3.get(i-3));   
                                            guardar7.add(guardar3.get(i));                              
                                            this.as=0;
                                            break;
                                        }else{
                                            this.as=5; 
                                        }
                                    } 
                                   as=5; 
                               } 
                            }else{
                                as=5;
                            }
                                  
                    }}
        return new Errorsem(guardar3,guardar7,j);
    }
    
}
