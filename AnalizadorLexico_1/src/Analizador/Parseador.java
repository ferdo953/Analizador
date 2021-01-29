package Analizador;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class Parseador {
        String ruta = "C:/Users/Public/archivo.txt";
        String ruta2 = "C:/Users/Public/archivo2.txt";
        File archivo = new File(ruta);
        File archivo2 = new File(ruta2);
        BufferedWriter bw;
        BufferedWriter bwr;
        Stack pila = new Stack();
        Stack pila2 = new Stack();
        int bandera=0,jerarsuma=0,h=1,bandera2=0,noentro=0,contador=0,entro=0,p=0,k=0,conrel=0,contando,contwh=0,sientra=0,paren=1,relacional=1,contando2=1,vacio=1,tr=1,numtr=1,trs=1;
        DefaultTableModel model = new DefaultTableModel();
        
        String expresion,otro="",otropre="",ultimaParseada,ID = "[A-Z]([A-Za-z]|_|-|(\\d))*",letra;
        ArrayList<String> guardar = new ArrayList<String>();
        ArrayList<String> array = new ArrayList<String>();
        ArrayList<String> guardar2 = new ArrayList<String>();
        ArrayList<String> operadores = new ArrayList<String>();
        ArrayList<String> triplo1 = new ArrayList<String>();
        ArrayList<String> triplo2 = new ArrayList<String>();
        ArrayList<String> triplo3 = new ArrayList<String>();
        ArrayList<String> triplo4 = new ArrayList<String>();
        String[] datos = new String[3];  
        String CNE = "((\\d)+)";
        String OA = "(\\+|\\-|\\*|\\/|\\=)";
        String IGN = "while|==|!=|<=|>=|<|>|&&|\\|";
        public Parseador( ){
     
        }
        public Parseador(String expresion){
            this.expresion=expresion;
         
        }
        public Parseador(String expresion,int contando,int contando3){
            this.expresion=expresion;
            this.contando2=contando;
            this.contwh=contando3;
        }
        
        public Parseador(String letra,String expresion,int contando){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
        }
        
        public Parseador(String letra,String expresion,int contando,int contando2){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.contando2=contando2;
        }
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            
        }
        
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,int entro){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            this.entro=entro;
        }
        
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,int entro,ArrayList<String> array,int trs){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            this.entro=entro;
            this.array=array;
            this.trs=trs;
        }
        
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,int entro,ArrayList<String> array,int trs,int contando2,int contwh,int conrel){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            this.entro=entro;
            this.array=array;
            this.trs=trs;
            this.contando2=contando2;
            this.contwh=contwh;
            this.conrel=conrel;
        }
        
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,ArrayList<String> array){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            this.entro=entro;
            this.array=array;
        }
        
        public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,ArrayList<String> array,int contando2){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            this.entro=entro;
            this.array=array;
            this.contando2=contando2;
        }
        
         public Parseador(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
           
        }
         
         
        public Parseador convirtiendo(){
            StringTokenizer tokens=new StringTokenizer(expresion);
            while(true){
                  
                if(tokens.hasMoreTokens()){
                    guardar.add(tokens.nextToken());  
                }else{
                    break;
                }
            }
            int j=0;
            for(int i=0;i<guardar.size();i++){
                if(isNumeric(guardar.get(i))==true || true==guardar.get(i).matches(ID)){                   
                        otro+=guardar.get(i);                    
                        if(i==guardar.size()-1){                          
                            while(!pila.empty()){                              
                                otro+=pila.pop();                                
                            }       
                        }else if(!pila.empty() || !pila2.empty()){
                            if(bandera==0){
                                if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                                   
                                    while(!pila.empty()){                               
                                        otro+=pila.pop(); 
                                    }
                                }
                            }else if(bandera==1){
                                if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                                    while(!pila2.empty()){                               
                                        otro+=pila2.pop(); 
                                    }
                                }else if(guardar.get(i-1).equals("+") || guardar.get(i-1).equals("-")){
                                    if(operadores.size()>1)
                                    otro+=pila2.pop(); 
                                }
                            }
                            
                        }
                    }else if(guardar.get(i).equals("+") || guardar.get(i).equals("-")){                        
                        if(operadores.size()>0 && bandera==0){   
                                if(operadores.get(operadores.size()-1).equals("+") || operadores.get(operadores.size()-1).equals("-")){
                                     otro+=pila.pop();
                                }    
                                pila.push(guardar.get(i));
                                operadores.add(guardar.get(i));                                
                        }else if(bandera==1){
                             pila2.push(guardar.get(i)); 
                             operadores.add(guardar.get(i));
                        }else{
                             pila.push(guardar.get(i)); 
                             operadores.add(guardar.get(i));
                        }                        
                    }else if(guardar.get(i).equals("*") || guardar.get(i).equals("/")){ 
                        if(bandera==0){
                            pila.push(guardar.get(i));
                            operadores.add(guardar.get(i));
                        }else{
                           
                            pila2.push(guardar.get(i));
                            operadores.add(guardar.get(i));
                        }      
                    }else if(guardar.get(i).equals(")") || guardar.get(i).equals("(")){
                        if(guardar.get(i).equals("(")){
                            bandera=1;
                            operadores.clear();
                        }else{  
                        while(!pila2.empty()){                               
                                otro+=pila2.pop();        
                            }
                        while(!pila.empty()){                               
                                otro+=pila.pop();        
                            }
                            bandera=0;
                            operadores.add(guardar.get(i));
                        }
                    }
            }
            return new Parseador(otro,contando,contando2);
        }
        
       
        public Parseador convirtiendopre(){
            StringTokenizer tokens=new StringTokenizer(expresion);
            while(true){      
                if(tokens.hasMoreTokens()){
                    guardar.add(tokens.nextToken());  
                }else{
                    break;
                }
            }
            
            for (int i = 0; i < guardar.size(); i++) {
                if(guardar.get(guardar.size()-i-1).equals("(")){
                    guardar2.add(i, ")");
                }else if(guardar.get(guardar.size()-i-1).equals(")")){
                    guardar2.add(i, "(");
                }else{
                    guardar2.add(i, guardar.get(guardar.size()-i-1));
                }
                
            }
          
            guardar.clear();
            int j=0;
           
            for(int i=0;i<guardar2.size();i++){
                if(isNumeric(guardar2.get(i))==true || true==guardar2.get(i).matches(ID)){                   
                        guardar.add(guardar2.get(i));
                        if(i==guardar2.size()-1){             
                            while(!pila.empty()){ 
                                guardar.add(pila.pop().toString());                              
                            }                  
                        }else if(i>0){
                            if(bandera==0){
                                if(guardar2.get(i-1).equals("*") || guardar2.get(i-1).equals("/")){                                 
                                    guardar.add(pila.pop().toString());
                                }
                            }else if(bandera==1){
                              
                                if(guardar2.get(i-1).equals("*") || guardar2.get(i-1).equals("/")){      
                                  
                                    guardar.add(pila2.pop().toString());
                                }
                            }
                            
                            
                        }
                    }else if(guardar2.get(i).equals("+") || guardar2.get(i).equals("-")){
                        if(bandera==0){                          
                            pila.push(guardar2.get(i)); 
                            operadores.add(guardar2.get(i));
                        }else if(bandera==1){
                            pila2.push(guardar2.get(i)); 
                            operadores.add(guardar2.get(i));
                        }                                                   
                    }else if(guardar2.get(i).equals("*") || guardar2.get(i).equals("/")){       
                        if(bandera==0){
                            pila.push(guardar2.get(i)); 
                            operadores.add(guardar2.get(i));                 
                        }else if(bandera==1){
                            
                            pila2.push(guardar2.get(i));                          
                            operadores.add(guardar2.get(i));
                        }
                    }else if(guardar2.get(i).equals(")") || guardar2.get(i).equals("(")){
                        if(guardar2.get(i).equals("(")){
                            bandera=1;
                            operadores.add(guardar2.get(i));
                        }else{ 
                        
                        while(!pila2.empty()){                          
                                guardar.add(pila2.pop().toString());   
                            }
                            bandera=0;
                        }
                    }
            }
            
            if(!pila.empty()){
                while(!pila.empty()){                          
                      guardar.add(pila.pop().toString());   
                }
            }
          
            for (int i = 0; i < guardar.size(); i++) {
                otro+=guardar.get(guardar.size()-i-1);
            }
         
            return new Parseador(otro,contando,contando2);
        }
       
  //----------------------------------------------------------------------------------------------------------------      
 //-----------------------------------------------------------------------------------------------------------------
        public Parseador triplo(){
            
            try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo,true));
           
        }else {           
            bw = new BufferedWriter(new FileWriter(archivo));         
            bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
        }
        
        if(archivo2.exists()) {
            bwr = new BufferedWriter(new FileWriter(archivo2,true));
           
        }else {           
            bwr = new BufferedWriter(new FileWriter(archivo2));         
            
        }
              
            StringTokenizer tokens=new StringTokenizer(expresion);
            while(true){
                  
                if(tokens.hasMoreTokens()){
                    guardar.add(tokens.nextToken());  
                }else{
                    break;
                }
            }
            
            if(guardar.size()==1){
                if(guardar.get(0).equals("while")){
                    bwr.write(contando2+"   CICLO"+contwh+":\n");
                    contando2++;
                    bwr.close();
                    guardar.clear();
                }else if(guardar.get(0).equals("}")){
                    System.out.println(guardar);
                    bwr.write(contando2+"   JMP CICLO"+contwh+"\n");
                    contando2++;
                    bwr.write(contando2+"   afuera"+contwh+":\n");
                    contando2++;
                    bwr.close();
                    guardar.clear();
                }
            }
            
            // String IGN = "while|==|!=|<=|>=|<|>|&&|\\|";
            for(int i=0;i<guardar.size();i++){               
                   if(i>0){                            
                       if(guardar.get(i).matches(IGN)){
                           if(entro==1 | entro==3){
                               if(guardar.get(i).equals("==")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JE adentro"+(conrel)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("!=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JNE adentro"+(conrel)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("<=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JlE adentro"+(conrel)+"\n");
                                contando2++;
                                
                            }else if(guardar.get(i).equals(">=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JGE adentro"+(conrel)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("<")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JL adentro"+(conrel)+"\n");
                                contando2++;
                                
                            }else if(guardar.get(i).equals(">")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JG adentro"+(conrel)+"\n");
                                contando2++;
                               
                            }
                           }else if(entro==2){
                                if(guardar.get(i).equals("==")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JE adentro"+(conrel+1)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("!=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JNE adentro"+(conrel+1)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("<=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JlE adentro"+(conrel+1)+"\n");
                                contando2++;
                                
                            }else if(guardar.get(i).equals(">=")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JGE adentro"+(conrel+1)+"\n");
                                contando2++;
                               
                            }else if(guardar.get(i).equals("<")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JL adentro"+(conrel+1)+"\n");
                                contando2++;
                                
                            }else if(guardar.get(i).equals(">")){
                                bwr.write(contando2+"   mov AX, "+guardar.get(i-1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   CMP AX, "+guardar.get(i+1)+"\n");
                                contando2++;
                                bwr.write(contando2+"   JG adentro"+(conrel+1)+"\n");
                                contando2++;
                               
                            }
                           }
                            
                            
                            datos[0]="=";
                            datos[1]="T1";
                            datos[2]=guardar.get(i-1);
                            model.addRow(datos);
                            bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                            contando++;
                            datos[0]=guardar.get(i);
                            datos[1]="T1";
                            datos[2]=guardar.get(i+1);
                            model.addRow(datos);
                            bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                            contando++;
                       }
                   }
            }
                     if(entro==1 | entro==3){
                                bwr.write(contando2+"   JMP afuera"+(contwh)+"\n");
                                contando2++;
                                bwr.write(contando2+"   adentro"+(conrel)+":\n");
                                contando2++;
                     }
                       if(entro==1){
                           bw.write(contando+"         "+(contando+2+(4*(tr-1)))+"                    "+"TR"+trs+"                    "+"TRUE"+"\n");
                           contando++;
                           bw.write(contando+"         "+(Integer.parseInt(this.array.get(0))-1)+"                    "+"TR"+trs+"                    "+"FALSE"+"\n");           
                           array.remove(0);
                           contando++;        
                       }else if(entro==2){ //relacional or, segunda instruccion
                           bw.write(contando+"         "+(contando+2+(4*(tr-1)))+"                    "+"TR"+trs+"                    "+"TRUE"+"\n");
                           contando++;
                           bw.write(contando+"         "+(contando+1)+"                    "+"TR"+trs+"                    "+"FALSE"+"\n");
                           contando++;
                       }else if(entro==3){
                            bw.write(contando+"         "+(contando+2)+"                    "+"TR"+trs+"                    "+"TRUE"+"\n");
                            contando++;
                            bw.write(contando+"         "+(Integer.parseInt(this.array.get(0))-1)+"                    "+"TR"+trs+"                    "+"FALSE"+"\n");                         
                            contando++; 
                       }
                                         
            
            for(int i=0;i<guardar.size();i++){
               if(isNumeric(guardar.get(i))==true || true==guardar.get(i).matches(ID)){
                   if(i>0){
                       if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                           h=i;
                           triplo1.add(guardar.get(i));
                           triplo1.add(guardar.get(i-1));  
                       }
                   }          
               }else if(guardar.get(i).equals("+") || guardar.get(i).equals("-")){ 
                   if(triplo1.size()>0){
                        if(!triplo1.get(triplo1.size()-1).equals("sumaoresta")){
                            triplo1.add("sumaoresta");
                        }
                   }else{
                       triplo1.add("sumaoresta");
                   }
               }else if(guardar.get(i).equals("*") || guardar.get(i).equals("/")){
                   if(h+1==i){ 
                       
                   }else{
                       triplo1.add(guardar.get(i-1));
                       triplo1.add("=");
                   } 
                    
               }
            }
                
            
            //----------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------
            //suma
            //----------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------
            for(int i=0;i<guardar.size();i++){
               if(isNumeric(guardar.get(i))==true || true==guardar.get(i).matches(ID)){
                   if(i>0){
                       if(guardar.get(i-1).equals("+") || guardar.get(i-1).equals("-")){
                                    triplo2.add(guardar.get(i));
                                    triplo2.add(guardar.get(i-1));
  
                         h=i; 
                       }else if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                           h=i;
                           if(operadores.size()>1){
                                if(operadores.get(operadores.size()-2).equals("+") || operadores.get(operadores.size()-2).equals("-")){
                                    
                                    triplo2.remove(triplo2.size()-3);
                                }
                            }
                           
                       }
                   }          
               }else if(guardar.get(i).equals("+") || guardar.get(i).equals("-")){   
                   if(h+1==i){                  
                       
                   }else{
                           
                           triplo2.add(guardar.get(i-1));
                           triplo2.add("=");
                           k=0;
                   } 
                  operadores.add(guardar.get(i));
               }else if(guardar.get(i).equals("*") || guardar.get(i).equals("/")){
                   p=0;
                   if(triplo2.size()>0){
                        if(!triplo2.get(triplo2.size()-1).equals("multi")){
                            triplo2.add("multi");
                        }
                   }else{
                       triplo2.add("multi");
                   }
                   operadores.add(guardar.get(i));
               }
            }
            
                
                     //*********************************************************************************************************
            int suma=0,bandero=0;
            for (int i = 0; i < triplo2.size(); i++) {
                if(triplo2.get(i).equals("multi")){
                    triplo3.clear();
                    suma=1;
                }else if(suma==1){
                    triplo3.add(triplo2.get(i));
                    bandero=i;
                }    
            }
            for (int i = triplo2.size()-1; i >= 0; i--) {
                if(bandero!=0 && triplo3.size()>0){             
                    if(triplo2.get(i).equals("multi")){
                        break;
                    }
                    triplo2.remove(i);
                } 
            }
            

            for (int i = 0; i < triplo3.size(); i++) {
                if(suma==1){
                    triplo1.remove(triplo1.size()-1);
                    suma=0;
                }
                triplo1.add(triplo3.get(i));
            }
            triplo3.clear();
          
            for (int i = 0; i < triplo2.size(); i++) {
                    triplo3.add(triplo2.get(i));
            }
            
            
            
            //*********************************************************************************************************
            
            
            int p=1,l=1, contt=0,base=0,entrar=0;
                System.out.println(triplo1);
            for (int i = 0; i < triplo1.size(); i++) {
                if(triplo1.get(i).equals("sumaoresta")){
                    if(l==0 && i!=triplo1.size()-1 && i!=0){
                        p++;
                    }  
                    noentro=8;
                    l=1;
                }else if(triplo1.get(i).matches(CNE) || triplo1.get(i).matches(OA) || triplo1.get(i).matches(ID)){
                    if(noentro!=8){
                         noentro=1;
                    }
                    if(triplo1.get(i+1).equals("=")){
                        if(contt==1 && base==0){
                            bwr.write(contando2+"   mov CX, "+"AL"+"\n");
                            contando2++;
                            base=1;
                        }else if(contt==1 && base==1){
                            bwr.write(contando2+"   mov DX, "+"AL"+"\n");
                            contando2++;
                            base=2;
                        }
                        bwr.write(contando2+"   mov AX, "+triplo1.get(i)+"\n");
                        contando2++;
                    }else if(triplo1.get(i+1).equals("*")){
                        bwr.write(contando2+"   mov BL, "+triplo1.get(i)+"\n");
                        contando2++;
                        bwr.write(contando2+"   mul BL\n");
                        contando2++;
                        contt=1;
                    }
                    else if(triplo1.get(i+1).equals("/")){
                        bwr.write(contando2+"   mov BL, "+triplo1.get(i)+"\n");
                        contando2++;
                        bwr.write(contando2+"   div BL\n");
                        contando2++;
                        contt=1;
                    }
                    else if(triplo1.get(i+1).equals("+")){
                        bwr.write(contando2+"   add AX,"+triplo1.get(i)+"\n");
                        contando2++;
                    }
                    else if(triplo1.get(i+1).equals("-")){
                        bwr.write(contando2+"   sub AX, "+triplo1.get(i)+"\n");
                        contando2++;
                    }
                    datos[0]=triplo1.get(i+1);
                    datos[1]="T"+p;
                    datos[2]=triplo1.get(i);
                    model.addRow(datos);
                    bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                    contando++;
                    l=0;
                    if(i+1!=triplo1.size()-1){ 
                        if(triplo1.get(i+1).equals("sumaoresta")){
                            noentro=8;
                        }
                        i++;
                    }else{
                        break;
                    }
                    
                }
            }
                
            if(l!=1){
               p++; 
            }
            if(triplo2.size()>0){
                if(triplo2.get(0).equals("multi")){
                k=1;
                }else{
                    k=0;
                }
            }else{
                k=0;
            }
            int ensam=0;
            for (int i = 0; i < triplo2.size(); i++) {
                if(noentro==1){
                    break;
                }
                if(triplo2.get(i+1).equals("multi")){
                    k++;
                }
                
                if(triplo2.get(i).matches(CNE) || triplo2.get(i).matches(OA) || triplo2.get(i).matches(ID)){
                    if(i+1!=triplo2.size()){
                        if(triplo2.get(i+1).equals("multi") && triplo2.get(i).matches(OA)){
                            if(k==1){
                                entrar=1;
                                datos[2]="T"+(k);
                                datos[1]="T"+(p);
                                datos[0]=triplo2.get(i);
                                if(base==2){
                                    bwr.write(contando2+"   mov BX, CX\n");
                                    contando2++;
                                    base=10;
                                }else if(base==1){
                                    bwr.write(contando2+"   mov BX, CX\n");
                                    contando2++;
                                    base=0;
                                }
                                if(triplo2.get(i).equals("+")){
                                    if(base==10){
                                        bwr.write(contando2+"   add BX, DX\n");
                                        base=0;
                                    }else{
                                        bwr.write(contando2+"   add BX, AX\n");
                                    }
                                    
                                    contando2++;
                                }else{
                                    if(base==10){
                                        bwr.write(contando2+"   sub BX, DX\n");
                                        base=0;
                                    }else{
                                        bwr.write(contando2+"   sub BX, AX\n");
                                    }
                                    contando2++;
                                }
                                model.addRow(datos); 
                                bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                                contando++;
                                triplo2.remove(i+1);
                            }else{
                                entrar=1;
                                datos[2]="T"+(k);
                                datos[1]="T"+(1);
                                datos[0]=triplo2.get(i);
                                 if(base==2){
                                    bwr.write(contando2+"   mov BX, CX\n");
                                    contando2++;
                                    base=10;
                                }else if(base==1){
                                    bwr.write(contando2+"   mov BX, CX\n");
                                    contando2++;
                                    base=0;
                                }
                                if(triplo2.get(i).equals("+")){
                                    if(base==10){
                                        bwr.write(contando2+"   add BX, DX\n");
                                        base=0;
                                    }else{
                                        bwr.write(contando2+"   add BX, AX\n");
                                    }
                                    
                                    contando2++;
                                }else{
                                    if(base==10){
                                        bwr.write(contando2+"   sub BX, DX\n");
                                        base=0;
                                    }else{
                                        bwr.write(contando2+"   sub BX, AX\n");
                                    }
                                    contando2++;
                                }
                                contando2++;
                                model.addRow(datos); 
                                bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                                contando++;
                                triplo2.remove(i+1);
                                jerarsuma=3;
                            }     
                        }else{
                            if(triplo2.get(i).matches(OA)){
                                datos[1]=triplo2.get(i+1);
                                if(jerarsuma==3){
                                    datos[2]="T"+1;
                                    jerarsuma=0;
                                }else if(k==0){
                                    datos[2]="T"+p;
                                }else if(k>1){ 
                                    datos[2]="T"+k;
                                }
                                if(ensam==0){
                                    ensam++;
                                    bwr.write(contando2+"   mov BX, "+triplo2.get(i+1)+"\n");
                                    contando2++;
                                }else if(ensam>0 && triplo2.get(i).equals("+")){
                                    bwr.write(contando2+"   add BX, "+triplo2.get(i+1)+"\n");
                                    contando2++;
                                }else if(ensam>0 && triplo2.get(i).equals("-")){
                                    bwr.write(contando2+"   sub BX, "+triplo2.get(i+1)+"\n");
                                    contando2++;
                                }
                                
                                
                                datos[0]=triplo2.get(i);
                                model.addRow(datos);
                                bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                                contando++;
                            }else if(triplo2.get(i).matches(CNE) || triplo2.get(i).matches(ID)){
                                datos[0]=triplo2.get(i+1);
                                if(jerarsuma==3){
                                    datos[1]="T"+1;
                                    jerarsuma=0;
                                }else if(k==0){
                                    datos[1]="T"+p;
                                }else if(k>0){
                                    datos[1]="T"+k;
                                } 
                                if(ensam==0){
                                    ensam++;
                                    bwr.write(contando2+"   mov BX, "+triplo2.get(i)+"\n");
                                    contando2++;
                                }else if(ensam>0 && triplo2.get(i+1).equals("+")){
                                    bwr.write(contando2+"   add BX, "+triplo2.get(i)+"\n");
                                    contando2++;
                                }else if(ensam>0 && triplo2.get(i+1).equals("-")){
                                    bwr.write(contando2+"   sub BX, "+triplo2.get(i)+"\n");
                                    contando2++;
                                }
                                datos[2]=triplo2.get(i);
                                model.addRow(datos);
                                bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                                contando++;
                            }
                            if(i+1!=triplo2.size()-1){
                                i++;
                            }else{
                                break;
                            }
                        }
                  }
               }
                
            }
                
            if(letra!=null && letra.length()!=0){
                if(triplo1.size()>0){
                    if(triplo1.get(0).equals("sumaoresta")){ 
                        datos[1]=letra;
                        datos[2]="T"+p;
                        datos[0]="=";
                        bwr.write(contando2+"   mov "+letra+", BL\n");
                        contando2++;
                        model.addRow(datos);
                        bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                        contando++;
                    }else{
                        datos[1]=letra;
                        datos[2]="T"+1;
                        datos[0]="=";
                        if(entrar==1){
                             bwr.write(contando2+"   mov "+letra+", BL\n");
                        }else{
                             bwr.write(contando2+"   mov "+letra+", AL\n");
                        }
                        
                        contando2++;
                        model.addRow(datos);
                        bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                        contando++;
                    }
                }else{
                    if(triplo1.size()==0 && triplo2.size()==0 && guardar.size()==1){
                        bw.write(contando+"         "+"="+"                    "+"T1"+"                    "+guardar.get(0)+"\n");
                        contando++;
                    }
                    bwr.write(contando2+"   mov "+letra+","+" "+guardar.get(0)+"\n");
                    datos[1]=letra;
                    datos[2]="T"+1;
                    datos[0]="=";
                    model.addRow(datos);
                    bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                    contando++;
                }
                
            }
              
            if(this.paren==0 && relacional==0){             
                    bw.write(contando+"         "+"JMP"+"                    "+ "" +"                    "+(tr)+"\n");
                    contando++;
                    
            } 
          
            if(vacio==0){
                bw.write(contando+"         "+"...");
                contando++;
            }
              
    
            bw.close();
            bwr.close();
       }catch(Exception e){
                System.out.println(e);
             }
            return new Parseador(otro,contando,contando2);
        }
        
        
        /***************************TRIPLO2*************************************************/
        
        
        public Parseador triplo2(){
            try{
  
            StringTokenizer tokens=new StringTokenizer(expresion);
            while(true){
                  
                if(tokens.hasMoreTokens()){
                    guardar.add(tokens.nextToken());  
                }else{
                    break;
                }
            }

            for(int i=0;i<guardar.size();i++){               
                   if(i>0){                            
                       if(guardar.get(i).matches(IGN)){                   
                            contando++;
                            contando++;
                       }
                   }
            }
                       if(entro==1){ //Relacional solo                       
                           contando+=2;                         
                       }else if(entro==2){ //relacional or, segunda instruccion
                           contando+=2;
                       }else if(entro==3){
                            contando+=2;
                       }
 
            for(int i=0;i<guardar.size();i++){
               if(isNumeric(guardar.get(i))==true || true==guardar.get(i).matches(ID)){
                   if(i>0){
                       if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                           h=i;
                           triplo1.add(guardar.get(i));
                           triplo1.add(guardar.get(i-1));  
                       }
                   }          
               }else if(guardar.get(i).equals("+") || guardar.get(i).equals("-")){ 
                   if(triplo1.size()>0){
                        if(!triplo1.get(triplo1.size()-1).equals("sumaoresta")){
                            triplo1.add("sumaoresta");
                        }
                   }else{
                       triplo1.add("sumaoresta");
                   }
               }else if(guardar.get(i).equals("*") || guardar.get(i).equals("/")){
                   if(h+1==i){ 
                       
                   }else{
                       triplo1.add(guardar.get(i-1));
                       triplo1.add("=");
                   } 
                    
               }
            }
               
            
            //----------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------
            //suma
            //----------------------------------------------------------------------------------------------------------------
            //----------------------------------------------------------------------------------------------------------------
            for(int i=0;i<guardar.size();i++){
               if(isNumeric(guardar.get(i))==true || true==guardar.get(i).matches(ID)){
                   if(i>0){
                       if(guardar.get(i-1).equals("+") || guardar.get(i-1).equals("-")){
                                    triplo2.add(guardar.get(i));
                                    triplo2.add(guardar.get(i-1));
  
                         h=i; 
                       }else if(guardar.get(i-1).equals("*") || guardar.get(i-1).equals("/")){
                           h=i;
                           if(operadores.size()>1){
                                if(operadores.get(operadores.size()-2).equals("+") || operadores.get(operadores.size()-2).equals("-")){
                                    
                                    triplo2.remove(triplo2.size()-3);
                                }
                            }
                           
                       }
                   }          
               }else if(guardar.get(i).equals("+") || guardar.get(i).equals("-")){   
                   if(h+1==i){                  
                       
                   }else{
                           
                           triplo2.add(guardar.get(i-1));
                           triplo2.add("=");
                           k=0;
                   } 
                  operadores.add(guardar.get(i));
               }else if(guardar.get(i).equals("*") || guardar.get(i).equals("/")){
                   p=0;
                   if(triplo2.size()>0){
                        if(!triplo2.get(triplo2.size()-1).equals("multi")){
                            triplo2.add("multi");
                        }
                   }else{
                       triplo2.add("multi");
                   }
                   operadores.add(guardar.get(i));
               }
            }
             
                           //*********************************************************************************************************
            int suma=0,bandero=0;
            for (int i = 0; i < triplo2.size(); i++) {
                if(triplo2.get(i).equals("multi")){
                    triplo3.clear();
                    suma=1;
                }else if(suma==1){
                    triplo3.add(triplo2.get(i));
                    bandero=i;
                }    
            }
            for (int i = triplo2.size()-1; i >= 0; i--) {
                if(bandero!=0 && triplo3.size()>0){             
                    if(triplo2.get(i).equals("multi")){
                        break;
                    }
                    triplo2.remove(i);
                } 
            }
            

            for (int i = 0; i < triplo3.size(); i++) {
                if(suma==1){
                    triplo1.remove(triplo1.size()-1);
                    suma=0;
                }
                triplo1.add(triplo3.get(i));
            }
            triplo3.clear();
          
            for (int i = 0; i < triplo2.size(); i++) {
                    triplo3.add(triplo2.get(i));
            }
                
            //*********************************************************************************************************
            
            
            int p=1,l=1;
            
            for (int i = 0; i < triplo1.size(); i++) {
                if(triplo1.get(i).equals("sumaoresta")){
                    if(l==0 && i!=triplo1.size()-1 && i!=0){
                        p++;
                    }  
                    noentro=8;
                    l=1;
                }else if(triplo1.get(i).matches(CNE) || triplo1.get(i).matches(OA) || triplo1.get(i).matches(ID)){
                    if(noentro!=8){
                         noentro=1;
                    }
                    contando+=1;
                    l=0;
                    if(i+1!=triplo1.size()-1){ 
                        if(triplo1.get(i+1).equals("sumaoresta")){
                            noentro=8;
                        }
                        i++;
                    }else{
                        break;
                    }
                    
                }
            }
                
            if(l!=1){
               p++; 
            }
            if(triplo2.size()>0){
                if(triplo2.get(0).equals("multi")){
                k=1;
                }else{
                    k=0;
                }
            }else{
                k=0;
            }
           
            for (int i = 0; i < triplo2.size(); i++) {
                if(noentro==1){
                    break;
                }
                if(triplo2.get(i+1).equals("multi")){
                    k++;
                }
                
                if(triplo2.get(i).matches(CNE) || triplo2.get(i).matches(OA) || triplo2.get(i).matches(ID)){
                    if(i+1!=triplo2.size()){
                        if(triplo2.get(i+1).equals("multi") && triplo2.get(i).matches(OA)){
                            if(k==1){                                 
                                contando++;
                                triplo2.remove(i+1);
                            }else{
                                contando++;
                                triplo2.remove(i+1);
                                jerarsuma=3;
                            }     
                        }else{
                            if(triplo2.get(i).matches(OA)){
                                contando++;
                            }else if(triplo2.get(i).matches(CNE) || triplo2.get(i).matches(ID)){
                                contando++;
                            }
                            if(i+1!=triplo2.size()-1){
                                i++;
                            }else{
                                break;
                            }
                        }
                  }
               }
                
            }
              
            if(letra!=null && letra.length()!=0){
                if(triplo1.size()>0){
                    if(triplo1.get(0).equals("sumaoresta")){ 
                        contando++;
                    }else{
                        contando++;
                    }
                }else{
                    if(triplo1.size()==0 && triplo2.size()==0 && guardar.size()==1){
                        contando++;
                    }
                    contando++;
                }
                
            }
              
            if(this.paren==0 && relacional==0){
               contando++;
            } 
            
            if(vacio==0){
                contando++;
            }
    
       }catch(Exception e){
                System.out.println(e);
             }
            return new Parseador(otro,contando,contando2);
        }
        
        
        
        public void Haciendo() throws IOException{
            try{
                if(archivo.exists()) {  
                    archivo.delete();
                    bw = new BufferedWriter(new FileWriter(archivo)); 
                    bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
                 
                }else {           
                    bw = new BufferedWriter(new FileWriter(archivo));         
                    bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
                    
                }
                bw.close();
                
                 if(archivo2.exists()) {  
                    archivo2.delete();
                    bwr = new BufferedWriter(new FileWriter(archivo2)); 
                    
                }else {           
                    bwr = new BufferedWriter(new FileWriter(archivo2));         
                    bwr.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
                    
                }
                bwr.close();
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        
        
        private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
       
        
}