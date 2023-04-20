
import java.util.Scanner;

public class ValidadorRutGPT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su RUT (sin puntos ni guión): ");
        String rut = scanner.nextLine();

        if (validarRut(rut)) {
            int dv = calcularDV(rut);
            System.out.println("El dígito verificador de su RUT es: " + dv);
        } else {
            System.out.println("El RUT ingresado es inválido.");
        }
    }

    public static boolean validarRut(String rut) {
        if (!rut.matches("[0-9]+")) {
            return false;
        }

        int suma = 0;
        int multiplicador = 2;
        for (int i = rut.length() - 1; i >= 0; i--) {
            suma += multiplicador * Character.getNumericValue(rut.charAt(i));
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int dv = 11 - suma % 11;
        String dvCalculado = dv == 11 ? "0" : dv == 10 ? "K" : String.valueOf(dv);

        return dvCalculado.equals(String.valueOf(rut.charAt(rut.length() - 1)));
    }

    public static int calcularDV(String rut) {
        int suma = 0;
        int multiplicador = 2;
        for (int i = rut.length() - 2; i >= 0; i--) {
            suma += multiplicador * Character.getNumericValue(rut.charAt(i));
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int dv = 11 - suma % 11;
        return dv == 11 ? 0 : dv == 10 ? -1 : dv;
    }
}
