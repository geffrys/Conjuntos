import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        final String menu = "Que tipo de conjuntos desea representar\n\n1. Conjunto en listas \n\n2. Conjunto en arreglo";
        final String menuGeneral = "Escriba la operacion que desea realizar \n1. cargar conjuntos. \n2. insertar. \n3. eliminar. \n4. mostrar. \n5. posicion de dato. \n6. es vacio? \n7. es subconjunto? \n8. union. \n9. interseccion. \n10. complemento. \n11. diferencia. \n12. diferencia simetrica. \n13. vaciar. \n15. salir";

        final String[] universal = { "3", "7", "6", "9", "4", "0", "2", "1", "8", "5" };
        final String[] conjuntoA = { "3", "1", "5", "8", "2" };
        final String[] conjuntoB = { "9", "2", "1", "8", "5" };

        String opc, opc2, inputs;
        int position;
        ConjuntoArreglo conjuntoArregloA, conjuntoArregloB, conjuntoArregloUniversal;
        ConjuntoLista conjuntoListaA = new ConjuntoLista(null), conjuntoListaB = new ConjuntoLista(null), conjuntoListaUniversal = new ConjuntoLista(null);
        do {
            opc = JOptionPane.showInputDialog(null, menu);
            switch (opc) {

                // CASO PARA CONJUNTO EN ARREGLO

                case "1":
                conjuntoArregloA = new ConjuntoArreglo(conjuntoA.length);
                conjuntoArregloB = new ConjuntoArreglo(conjuntoB.length);
                conjuntoArregloUniversal = new ConjuntoArreglo(universal.length);
                    do {
                        opc2 = JOptionPane.showInputDialog(null, menuGeneral);
                        switch (opc2) {
                            case "1":
                            for (int i = 0; i < conjuntoA.length; i++) {
                                conjuntoArregloA.setDato(conjuntoA[i], i);
                            }for (int i = 0; i < conjuntoB.length; i++) {
                                conjuntoArregloB.setDato(conjuntoB[i], i);
                            }for (int i = 0; i < universal.length; i++) {
                                conjuntoArregloUniversal.setDato(universal[i], i);
                            }
                                break;
                            case "2":
                            inputs = JOptionPane.showInputDialog(null, "Escriba el dato a ingresar.");
                            position = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba la posicion en la que lo desea insertar, tenga en cuenta que las posicion van desde el 0 hasta "+ conjuntoArregloA.getCantidadElementos()));
                            conjuntoArregloA.setDato(inputs, position);    
                                break;
                            case "3":

                                break;
                            case "4":

                                break;
                            case "5":

                                break;
                            case "6":

                                break;
                            case "7":

                                break;
                            case "8":

                                break;
                            case "9":

                                break;
                            case "10":

                                break;
                            case "11":

                                break;
                            case "12":

                                break;
                            case "13":

                                break;
                            default:
                                opc2 = "15";
                                break;
                        }
                    } while (!opc2.equals("15"));
                    break;

                // CASO PARA CONJUNTO EN LISTA

                case "2":
                    do {
                        opc2 = JOptionPane.showInputDialog(null, menuGeneral);
                        switch (opc2) {
                            case "1":
                            for (int i = 0; i < conjuntoA.length; i++) {
                                conjuntoListaA.agregarElemento(conjuntoA[i]);
                            }for (int i = 0; i < conjuntoB.length; i++) {
                                conjuntoListaB.agregarElemento(conjuntoB[i]);
                            }for (int i = 0; i < universal.length; i++) {
                                conjuntoListaUniversal.agregarElemento(universal[i]);
                            }
                                break;
                            case "2":

                                break;
                            case "3":

                                break;
                            case "4":

                                break;
                            case "5":

                                break;
                            case "6":

                                break;
                            case "7":

                                break;
                            case "8":

                                break;
                            case "9":

                                break;
                            case "10":

                                break;
                            case "11":

                                break;
                            case "12":

                                break;
                            case "13":

                                break;
                            default:
                                opc2 = "15";
                                break;
                        }
                    } while (!opc2.equals("15"));
                    break;
                default:
                    opc = "3";
                    break;
            }
        } while (!opc.equals("3"));
    }
}
