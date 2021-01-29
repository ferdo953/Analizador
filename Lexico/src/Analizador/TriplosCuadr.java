package Analizador;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class TriplosCuadr {
        String ruta = "C:/Users/Public/Triplos.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        Stack pila = new Stack();
        Stack pila2 = new Stack();
        int bandera=0,jerarsuma=0,h=1,bandera2=0;
        int noentro=0,contador=0,entro=0,p=0,k=0;
        int contando,sientra=0,paren=1,relacional=1,vacio=1,tr=1,numtr=1,trs=1;
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
        public TriplosCuadr( ){
     
        }
        public TriplosCuadr(String expresion){
            this.expresion=expresion;
         
        }
        public TriplosCuadr(String expresion,int contando){
            this.expresion=expresion;
            this.contando=contando;
        }
        
        public TriplosCuadr(String letra,String expresion,int contando){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
        }
        public TriplosCuadr(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
            this.tr=tr;
            
        }
        
        public TriplosCuadr(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,int entro){
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
        
        public TriplosCuadr(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,int entro,ArrayList<String> array,int trs){
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
        
        public TriplosCuadr(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio,int tr,ArrayList<String> array){
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
        
         public TriplosCuadr(String letra,String expresion,int contando,int sientro,int paren,int relacional,int vacio){
            this.expresion=expresion;
            this.letra=letra;
            this.contando=contando;
            this.sientra=sientro;
            this.paren=paren;
            this.relacional=relacional;
            this.vacio=vacio;
           
        }
         
         
        public TriplosCuadr convirtiendo(){
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
            return new TriplosCuadr(otro,contando);
        }
        
       
        public TriplosCuadr convirtiendopre(){
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
         
            return new TriplosCuadr(otro,contando);
        }
       
  //----------------------------------------------------------------------------------------------------------------      
 //-----------------------------------------------------------------------------------------------------------------
        public TriplosCuadr triplo(){
            
            try{
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo,true));
           
        }else {           
            bw = new BufferedWriter(new FileWriter(archivo));         
            bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
        }
        model.addColumn("Operador");
        model.addColumn("Dato Objeto");    
        model.addColumn("Dato Fuente");
        
              
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
                                datos[2]="T"+(k);
                                datos[1]="T"+(p);
                                datos[0]=triplo2.get(i);
                                model.addRow(datos); 
                                bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                                contando++;
                                triplo2.remove(i+1);
                            }else{
                                datos[2]="T"+(k);
                                datos[1]="T"+(1);
                                datos[0]=triplo2.get(i);
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
                        model.addRow(datos);
                        bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                        contando++;
                    }else{
                        datos[1]=letra;
                        datos[2]="T"+1;
                        datos[0]="=";
                        model.addRow(datos);
                        bw.write(contando+"         "+datos[0]+"                    "+datos[1]+"                    "+datos[2]+"\n");
                        contando++;
                    }
                }else{
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
    
       }catch(Exception e){
                System.out.println(e);
             }
            return new TriplosCuadr(otro,contando);
        }
        
        public TriplosCuadr triplo2(){
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
            return new TriplosCuadr(otro,contando);
        }
        
        
        
        public void Haciendo() throws IOException{
            try{
                if(archivo.exists()) {  
                    archivo.delete();
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n"
                            + "-------------------------------------------------------------------------------------------\n");
                }else {           
                    bw = new BufferedWriter(new FileWriter(archivo));         
                    bw.write("         "+"Operador"+"         "+"Dato Objeto"+"         "+"Dato fuente"+"\n");
                }
                bw.close();
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