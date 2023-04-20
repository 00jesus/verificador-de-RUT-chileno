import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String rutPrueba = "12.345.678-455";

        verificarDV();


    }

    public static void verificarDV() {
        System.out.println("Ingrese su rut con su digito verificador, sin punto ni guion: ");
        String rut = ingresarRut();
        String dvReal = calcularDV(rut);
        String dvSupuesto = tomarUltimo(rut);
        if (dvSupuesto.equals(dvReal)) {
            System.out.println("Su digito verificador es correcto, es: " + dvReal);
        } else if (!(dvSupuesto.equals(dvReal))) {
            System.out.println("Su rut ingresado no es valido, el digito verificador que ingreso es: " + dvSupuesto + " mientras que el real es: " + dvReal);
        }

    }

    public static String ingresarRut() {
        Scanner sc = new Scanner(System.in);
        String prueba = "";
        System.out.println("Ingrese rut: ");
        while (!isNumeric(prueba)) {
            prueba = sc.nextLine();
            if (prueba.length() == 0) {
                System.out.println("Ingrese algo");
            } else if (!(isNumeric(prueba))) {
                System.out.println("Ingrese solo numeros");
            } else {
                return prueba;
            }
        }
        return prueba;
    }

    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static boolean esVacio(String rut) {
        if (rut.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String calcularDV(String rut) {
        String dv;
        String rutInvertido = reversarCadena(quitarCaracteres(tomarPrimeros(rut)));
        int sumatoria = multiplicaciones(rutInvertido); //PASO4
        int divido = dividir_por(sumatoria, 11);//PASO6
        int multiplicado = multiplicar_por(divido, 11); //PASO 7
        int resta = restaValorAbsoluto(sumatoria, multiplicado); //PASO 4-PASO 7
        int resultado = (11 - resta); //PASO 8
        switch (resultado) {
            case 10:
                dv = "k";
                return dv;
            case 11:
                dv = "0";
                return dv;
            default:
                dv = String.valueOf(resultado);
                return dv;
        }
    }

    public static int restaValorAbsoluto(int sumaMultiplicaciones, int resultado_x11) {
        int temp = sumaMultiplicaciones - resultado_x11;
        if ((temp) < 0) {
            return -(temp);
        } else {
            return sumaMultiplicaciones - resultado_x11;
        }
    }
    //PASO 7

    public static int multiplicar_por(int sumaRUT, int multiplicador) {
        return (sumaRUT * multiplicador);
    }

    public static int dividir_por(int sumaRUT, int divisor) throws ArithmeticException {
        return (sumaRUT / divisor);
    }

    //PASO 5 y 6
    public static int multiplicaciones(String rutInvertido) {
        int acumulador = 0;
        int aux;
        int[] digitosRut = stringHaciaArregloEnteros(rutInvertido);
        int[] serie = {2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < digitosRut.length; i++) {
            aux = serie[i] * digitosRut[i];
            acumulador = acumulador + aux;
        }
        return acumulador;
    }
// PASO 4

    public static int[] stringHaciaArregloEnteros(String rut) { //convierte el arreglo char a un arreglo de int
        char[] caracteres = rut.toCharArray();
        int[] digitos = new int[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            digitos[i] = Character.getNumericValue(caracteres[i]);
        }
        return digitos;
    }

    public static String reversarCadena(String rut) {
        char aux;
        String reverse = "";
        for (int i = 0; i < rut.length(); i++) {
            aux = rut.charAt(i);
            reverse = aux + reverse;
        }
        return reverse;
    }

    public static String quitarCaracteres(String rut) {
        String limpio = rut.replace(".", "");
        limpio = limpio.replace("  ", "");
        limpio = limpio.replace(" ", "");
        return limpio;
    }

    public static String tomarPrimeros(String rut) {
        String acumular = "";
        char temp;
        for (int i = 0; i < rut.length() - 1; i++) {
            temp = rut.charAt(i);
            acumular = acumular + temp;
        }
        return acumular;
    }

    public static String tomarUltimo(String rut) {
        String ultimo = "";
        char sacarUltimo = rut.charAt(rut.length() - 1);
        ultimo = ultimo + sacarUltimo;
        return ultimo;
    }

}
