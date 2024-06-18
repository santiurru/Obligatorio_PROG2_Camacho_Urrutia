import exceptions.InformacionInvalida;
import java.util.Scanner;

public class Main {

    static int menu_principal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------Menu Principal----------------------------");
        System.out.println();
        System.out.println("Opciones disponibles:");
        System.out.println();
        System.out.println("1: Top 10 canciones en un pais (dia dado)");
        System.out.println("2: Top 5 canciones en mas top 50 (dia dado)");
        System.out.println("3: Top 7 artistas en mas top 50 (rango de fechas)");
        System.out.println("4: Apariciones de un artista en un top 50 (Rango de fechas)");
        System.out.println("5: Cantidad de canciones con un tempo especifico (Rango de fechas)");
        System.out.println("6: EXIT");
        int opcion = scanner.nextInt();
        if(1<= opcion && opcion<= 6){
            return opcion;
        }else{
            System.out.println("Opcion invalida");
            return menu_principal();
        }
    }
    static void menu_consulta_1(){

    }
    static void menu_consulta_2(){
        
    }

    public static void main(String[] args) {
        Consulta consultas = new Consulta();
        int opcion = menu_principal();
        switch(opcion){
            case 1:
                menu_consulta_1();
                break;
            case 2:
                menu_consulta_2();
                break;
            case 6:

        }

    }
}