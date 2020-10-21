package expresiones;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paloma
 */
public class ExpresionLogicaV2 {

    public ExpresionLogicaV2() {
        Separar("1 2 b 3 c 4 d 5 e");
    }

    private void Separar(String oracion) {
        System.out.println("La cadena original es: " + oracion);
        String separador = " ";
        String arr1[] = oracion.split(separador);

        Clasificador(arr1);
//        for(int i = 0; i < arr1.length; i++){
//            System.out.print(arr1[i]);
//        }
    }

    private boolean isNumeric(String string) {

        try {
            double d = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void Clasificador(String[] arreglo) {

        ArrayList<String> cadenaNumeros = new ArrayList<String>();
        ArrayList<String> cadenaLetras = new ArrayList<String>();

        for (int i = 0; i < arreglo.length; i++) {

            if (isNumeric(arreglo[i])) {
                cadenaNumeros.add(arreglo[i]);
            } else {
                cadenaLetras.add(arreglo[i]);
            }
        }

        System.out.println("Los elementos que son números son: " + cadenaNumeros);
        int tamaño = cadenaNumeros.size();
        System.out.println("El número de elementos es de " + tamaño);
        System.out.println("Los elementos que son letras son: " + cadenaLetras);
        int tamaño2 = cadenaLetras.size();
        System.out.println("El número de elementos es de " + tamaño2);
    }

}
