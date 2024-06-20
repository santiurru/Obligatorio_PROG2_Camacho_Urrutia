import exceptions.InformacionInvalida;
import java.util.Scanner;

public class Main {

    static int menu_principal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------Menu Principal----------------------------");
        System.out.println();
        System.out.println("Opciones disponibles:");
        System.out.println();
        System.out.println("1: Top 10 canciones en un pais (dia dado)");
        System.out.println("2: Top 5 canciones en mas top 50 (dia dado)");
        System.out.println("3: Top 7 artistas en mas top 50 (rango de fechas)");
        System.out.println("4: Apariciones de un artista en un top 50 (Dia dado)");
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

    static void switch_menu(int opcion, Consulta consultas){

        switch(opcion){
            case 1:
                menu_consulta_1(consultas);
                break;
            case 2:
                menu_consulta_2(consultas);
                break;
            case 3:
                menu_consulta_3(consultas);
                break;
            case 4:
                menu_consulta_4(consultas);
                break;
            case 5:
                menu_consulta_5(consultas);
            case 6:
                break;
        }
    }
    static void menu_consulta_1(Consulta cons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el codigo de Pais (Ejemplo: UY): ");
        String pais = scanner.nextLine();
        System.out.println("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        try {
            cons.consultaUno(pais, fecha);
        } catch (InformacionInvalida e) {
            System.out.println("La informacion es invalida, intente nuevamente");
            menu_consulta_1(cons);
        }


    }
    static void menu_consulta_2(Consulta cons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        try {
            cons.consultaDos(fecha);
        } catch (InformacionInvalida e) {
            System.out.println("La informacion es invalida, intente nuevamente");
            menu_consulta_2(cons);
        }
    }

    static void menu_consulta_3(Consulta cons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fecha inicial (desde) (YYYY-MM-DD): ");
        String fecha_ini = scanner.nextLine();
        System.out.println("Ingrese la fecha final (hasta) (YYYY-MM-DD): ");
        String fecha_fin = scanner.nextLine();
        try {
            cons.consultaTres(fecha_ini, fecha_fin);
        } catch (InformacionInvalida e) {
            System.out.println("La informacion es invalida, intente nuevamente");
            menu_consulta_3(cons);
        }
    }

    static void menu_consulta_4(Consulta cons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del artista: ");
        String artista = scanner.nextLine();
        System.out.println("Ingrese la fecha (YYYY-MM-DD):");
        String fecha = scanner.nextLine();
        try {
            cons.consultaCuatro(artista, fecha);
        } catch (InformacionInvalida e) {
            System.out.println("La informacion es invalida, intente nuevamente");
            menu_consulta_4(cons);
        }
    }
    static void menu_consulta_5(Consulta cons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el rango de tempo inicial (double): ");
        double tempo_ini = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el rango de tempo final (double): ");
        double tempo_fin = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese la fecha inicial (desde) (YYYY-MM-DD): ");
        String date_ini = scanner.nextLine();
        System.out.println("Ingrese la fecha final (hasta) (YYYY-MM-DD): ");
        String date_fin = scanner.nextLine();
        try {
            cons.consultaCinco(tempo_ini, tempo_fin, date_ini, date_fin);
        } catch (InformacionInvalida e) {
            System.out.println("La informacion es invalida, intente nuevamente");
            menu_consulta_5(cons);
        }
    }


    public static void main(String[] args) {
        Consulta consultas = new Consulta();
        int opcion = menu_principal();
        while(opcion != 6){
            switch_menu(opcion, consultas);
            opcion = menu_principal();
        }
    }
}