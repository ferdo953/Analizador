/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;


public class clasesita {
    String hola;
public String getHola(){
    return hola;
}
    public clasesita(String hola){
        this.hola=hola;
    }
    
    public clasesita pruebas() {
       
        if(this.hola.equals("hola")){
            this.hola="Si conservo el valor anterior";
            
        }else{
            
        }

       return new clasesita(this.hola);
}
}
