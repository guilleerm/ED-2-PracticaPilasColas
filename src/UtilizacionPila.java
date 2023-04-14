import java.util.Stack;

/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el
 * apartado 2
 *
 * @author
 * @version
 */
public class UtilizacionPila {

    /**
     * TO-Do 1: Método que recibe un texto y una lista de etiquetas. Comprueba
     * si todas las etiquetas del texto están balanceadas (cada etiqueta de
     * apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarTexto(ListaEtiquetas lista, String texto) {
        Pila pila = new Pila();
        String[] etiqueta = texto.split("\\s+");
        int i = 0;
        while (i < etiqueta.length) {
            if (lista.esEtiqueta(etiqueta[i])) {
                if (lista.esApertura(etiqueta[i]))
                    pila.apilar(etiqueta[i]);
                else if (lista.esCierre(etiqueta[i])) {
                    String etiquetaApertura = pila.desapilar();
                    if (!lista.emparejados(etiquetaApertura, etiqueta[i]))
                        pila.apilar(etiquetaApertura);
                }
            }
            i++;
        }
        if (!pila.vacia()) {
            System.out.println("En la pila quedan elementos:");
            mostrarInverso(pila);
            return false;
        }
        return true;
    }

    /**
     * Método que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     *
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Pila pila) {
        if (!pila.vacia()) {
            String elemento = pila.desapilar();
            mostrarInverso(pila);
            System.out.println(elemento);
            pila.apilar(elemento);
        }
    }
}













