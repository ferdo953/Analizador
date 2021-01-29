
package proyectos;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
/**
 *
 * @author f-er9
 */
public class Botchat {
    static Scanner f = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException {
    System.out.println("Hola Humano, ¿Qué nombre deseas ponerme?");
    String nombre = f.next();
    Month mes = LocalDate.now().getMonth();
    String nombree = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    saludar(nombre,LocalDate.now().getYear(),nombree);
    Thread.sleep(2000);
    nombre();
    
}
    
    static void saludar (String nombre, int anio, String mes){
         System.out.println("\nHola Creador, mi nombre es "+nombre);
         System.out.println("Naci en el mes de "+mes+" de "+anio);
    }
    
    static void nombre () throws InterruptedException{
        System.out.println("\n¿Podrias decirme tu nombre?");
        String name = f.next();
        Thread.sleep(1000);
        System.out.println("\nMucho gusto "+name+".\nQué increible nombre tienes.");
    }
    
    
}
