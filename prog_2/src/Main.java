import exceptions.InformacionInvalida;

public class Main {
    public static void main(String[] args) {
        Consulta consultas = new Consulta();
        try {
            consultas.primeraConsulta("","2024-05-13");
            consultas.segundaConsulta("2024-05-13");
            consultas.terceraConsulta("2024-05-13", "2024-06-13");
        } catch (InformacionInvalida e) {
            throw new RuntimeException(e);
        }

    }
}
