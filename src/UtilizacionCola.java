/**
 * Clase UtilizacionCola, para desarrollar los ejercicios propuestos en el
 * apartado 4
 *
 * @author
 */
public class UtilizacionCola {

    /**
     * TO-DO 1: Método que recibe una lista de etiquetas html y un String
     * conteniendo una página html.
     * Genera una cola que contiene las etiquetas de la lista contenidas en el texto
     *
     * @param lista lista que contiene las etiquetas que queremos comprobar
     * @param texto la página que vamos a analizar
     * @return la cola que contiene las etiquetas de la lista contenidas en el texto
     */
    public Cola leerTexto(ListaEtiquetas lista, String texto) {
        Cola cola = new Cola();
        String[] etiqueta = texto.split("\\s+");
        for (int i = 0; i < etiqueta.length; i++)
            if (lista.esEtiqueta(etiqueta[i]))
                cola.encolar(etiqueta[i]);
        return cola;
    }

    /**
     * Método que recibe una cola y una lista de etiquetas. Comprueba si todas las etiquetas
     * de la cola están balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param cola  que contiene las etiquetas extraídas de una página html
     * @param lista contiene las etiquetas que queremos analizar.
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarHtml(Cola cola, ListaEtiquetas lista) {
        Pila pilaAuxiliar = new Pila();
        int num = cola.getNumElementos();
        for (int i = 0; i < num; i++) {
            String etiqueta = cola.desencolar();
            if (lista.esApertura(etiqueta)) {
                pilaAuxiliar.apilar(etiqueta);
            } else if (lista.esCierre(etiqueta)) {
                String etiquetaDeApertura = pilaAuxiliar.desapilar();
                if (!lista.emparejados(etiquetaDeApertura, etiqueta)) {
                    pilaAuxiliar.apilar(etiquetaDeApertura);
                }
            }
            cola.encolar(etiqueta);
        }
        if (!pilaAuxiliar.vacia()) {
            System.out.println("En la pila quedan elementos:");
            pilaAuxiliar.mostrar();
            return false;
        }
        return true;
    }
}
