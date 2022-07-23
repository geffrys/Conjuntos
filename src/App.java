import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        final String menu = "Que tipo de conjuntos desea representar\n\n2. Conjunto en listas \n\n1. Conjunto en arreglo";
        final String menuGeneral = "Escriba la operacion que desea realizar \n1. cargar conjuntos. \n2. insertar. \n3. eliminar. \n4. mostrar. \n5. posicion de dato. \n6. es vacio? \n7. es subconjunto? \n8. union. \n9. interseccion. \n10. complemento. \n11. diferencia. \n12. diferencia simetrica. \n13. vaciar. \n15. salir";

        final String[] universal = { "3", "7", "6", "9", "4", "0", "2", "1", "8", "5" };
        final String[] conjuntoA = { "3", "1", "5", "8", "2" };
        final String[] conjuntoB = { "9", "2", "1", "8", "5" };
        final String opcionConjunto = "Escriba el conjunto sobre el cual desea operar A o B";

        String opc, opc2, inputs, inputs2;
        ConjuntoArreglo conjuntoArregloA, conjuntoArregloB, conjuntoArregloUniversal;
        ConjuntoLista conjuntoListaA = new ConjuntoLista(null), conjuntoListaB = new ConjuntoLista(null),
                conjuntoListaUniversal = new ConjuntoLista(null);
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
                                }
                                for (int i = 0; i < conjuntoB.length; i++) {
                                    conjuntoArregloB.setDato(conjuntoB[i], i);
                                }
                                for (int i = 0; i < universal.length; i++) {
                                    conjuntoArregloUniversal.setDato(universal[i], i);
                                }
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null, "Opcion inhabilitada");
                                break;
                            case "3":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                inputs2 = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                if (inputs.equals("A")) {
                                    conjuntoArregloA.borrar(inputs2);
                                } else {
                                    inputs = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                    conjuntoArregloB.borrar(inputs2);
                                }
                                break;
                            case "4":
                                conjuntoArregloUniversal.mostrarConjunto();
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                JOptionPane.showMessageDialog(null, "El conjunto Universal\n\n"
                                        + conjuntoArregloUniversal.getConcatenadorMostrar() + "\n\nEl conjunto A\n\n"
                                        + conjuntoArregloA.getConcatenadorMostrar() + "\n\nEl conjunto B\n\n"
                                        + conjuntoArregloB.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                conjuntoArregloUniversal.setConcatenadorMostrar("");
                                break;
                            case "5":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                inputs2 = JOptionPane.showInputDialog(null, "Escriba el elemento a mostrar indice");
                                if (inputs.equals("A")) {
                                    conjuntoArregloA.posicion(inputs2);
                                    ;
                                } else {
                                    inputs = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                    conjuntoArregloB.posicion(inputs2);
                                    ;
                                }
                                break;
                            case "6":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                if (inputs.equals("A")) {
                                    if (conjuntoArregloA.esVacio()) {
                                        JOptionPane.showMessageDialog(null, "El conjunto A esta vacio");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El conjunto A no esta vacio");
                                    }
                                } else {
                                    if (conjuntoArregloB.esVacio()) {
                                        JOptionPane.showMessageDialog(null, "El conjunto B esta vacio");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El conjunto B no esta vacio");
                                    }
                                }
                                break;
                            case "7":
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                conjuntoArregloUniversal.mostrarConjunto();
                                inputs = JOptionPane.showInputDialog(null,
                                        "A. el conjunto A como subconjunto de B\nB. el conjunto B como subconjunto de A.\nC. el conjunto A como subconjunto del universal. \nD. el conjunto B como subconjunto del universal");
                                switch (inputs) {
                                    case "A":
                                        if (conjuntoArregloA.subconjuntoA(conjuntoArregloB)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                            + " \nes subconjunto de B: \n"
                                                            + conjuntoArregloB.getConcatenadorMostrar());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                            + " \nno es subconjunto de B: \n"
                                                            + conjuntoArregloB.getConcatenadorMostrar());

                                        }
                                        break;
                                
                                    case "B":
                                        if (conjuntoArregloB.subconjuntoA(conjuntoArregloA)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoArregloB.getConcatenadorMostrar()
                                                            + " \nes subconjunto de A: \n"
                                                            + conjuntoArregloA.getConcatenadorMostrar());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoArregloB.getConcatenadorMostrar()
                                                            + " \nno es subconjunto de A: \n"
                                                            + conjuntoArregloA.getConcatenadorMostrar());

                                        }
                                        break;
                                    case "C":
                                        if (conjuntoArregloA.subconjuntoA(conjuntoArregloUniversal)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                            + " \nes subconjunto de Universal: \n"
                                                            + conjuntoArregloUniversal.getConcatenadorMostrar());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                            + " \nno es subconjunto de Universal: \n"
                                                            + conjuntoArregloUniversal.getConcatenadorMostrar());

                                        }
                                        break;
                                    case "D":
                                        if (conjuntoArregloB.subconjuntoA(conjuntoArregloUniversal)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoArregloB.getConcatenadorMostrar()
                                                            + " \nes subconjunto de Universal: \n"
                                                            + conjuntoArregloUniversal.getConcatenadorMostrar());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoArregloB.getConcatenadorMostrar()
                                                            + " \nno es subconjunto de Universal: \n"
                                                            + conjuntoArregloUniversal.getConcatenadorMostrar());

                                        }
                                        break;

                                    default:
                                        break;
                                }
                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                conjuntoArregloUniversal.setConcatenadorMostrar("");
                                break;
                            case "8":
                                ConjuntoArreglo union = conjuntoArregloA.union(conjuntoArregloB);
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                union.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La union del conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                + "\n y el conjunto B: \n" + conjuntoArregloB.getConcatenadorMostrar()
                                                + "\n es \n" + union.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                break;
                            case "9":
                                ConjuntoArreglo interseccion = conjuntoArregloA.interseccion(conjuntoArregloB);
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                interseccion.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La interseccion del conjunto A: " + conjuntoArregloA.getConcatenadorMostrar()
                                                + " y el conjunto B: " + conjuntoArregloB.getConcatenadorMostrar()
                                                + " \nes \n" + interseccion.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                break;
                            case "10":
                                ConjuntoArreglo complemento = conjuntoArregloA.complemento(conjuntoArregloUniversal);
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloUniversal.mostrarConjunto();
                                complemento.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "El complemento del conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                + "\n y el conjunto universal:\n " + conjuntoArregloUniversal.getConcatenadorMostrar()
                                                + " \nes \n" + complemento.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloUniversal.setConcatenadorMostrar("");
                                break;
                            case "11":
                                ConjuntoArreglo diferencia = conjuntoArregloA.diferencia(conjuntoArregloB);
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                diferencia.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "la diferencia del conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                + "\n y el conjunto universal:\n "
                                                + conjuntoArregloB.getConcatenadorMostrar()
                                                + " \nes \n" + diferencia.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                break;
                            case "12":
                                ConjuntoArreglo diferenciasimetrica = conjuntoArregloA.diferenciaSimetrica(conjuntoArregloB);
                                conjuntoArregloA.mostrarConjunto();
                                conjuntoArregloB.mostrarConjunto();
                                diferenciasimetrica.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "la diferencia simetrica del conjunto A: \n" + conjuntoArregloA.getConcatenadorMostrar()
                                                + "\n y el conjunto universal:\n "
                                                + conjuntoArregloB.getConcatenadorMostrar()
                                                + " \nes \n" + diferenciasimetrica.getConcatenadorMostrar());

                                conjuntoArregloA.setConcatenadorMostrar("");
                                conjuntoArregloB.setConcatenadorMostrar("");
                                break;
                            case "13":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                if (inputs.equals("A")) {
                                    conjuntoArregloA.vaciar();
                                } else {
                                    conjuntoArregloB.vaciar();
                                }
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
                                }
                                for (int i = 0; i < conjuntoB.length; i++) {
                                    conjuntoListaB.agregarElemento(conjuntoB[i]);
                                }
                                for (int i = 0; i < universal.length; i++) {
                                    conjuntoListaUniversal.agregarElemento(universal[i]);
                                }
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null, "Esta opcion no esta habilitada");
                                break;
                            case "3":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                inputs2 = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                if (inputs.equals("A")) {
                                    conjuntoListaA.borrar(inputs2);
                                } else {
                                    inputs = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                    conjuntoListaB.borrar(inputs2);
                                }
                                break;
                            case "4":
                                conjuntoListaUniversal.mostrarConjunto();
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                JOptionPane.showMessageDialog(null, "El conjunto Universal\n\n"
                                        + conjuntoListaUniversal.getConcatenator() + "\n\nEl conjunto A\n\n"
                                        + conjuntoListaA.getConcatenator() + "\n\nEl conjunto B\n\n"
                                        + conjuntoListaB.getConcatenator());
                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();;
                                conjuntoListaUniversal.resetTestConcatenator();
                                break;
                            case "5":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                inputs2 = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                                if (inputs.equals("A")) {
                                    conjuntoListaA.posicionDato(inputs2);
                                    JOptionPane.showMessageDialog(null, "el dato esta en la posicion "+ conjuntoListaA.getPosicion());
                                } else {
                                    conjuntoListaB.posicionDato(inputs2);
                                    JOptionPane.showMessageDialog(null,
                                            "el dato esta en la posicion " + conjuntoListaB.getPosicion());
                                }
                                break;
                            case "6":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                if (inputs.equals("A")) {
                                    if (conjuntoListaA.esVacio()) {
                                        JOptionPane.showMessageDialog(null, "El conjunto A esta vacio");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El conjunto A no esta vacio");
                                    }
                                } else {
                                    if (conjuntoListaB.esVacio()) {
                                        JOptionPane.showMessageDialog(null, "El conjunto B esta vacio");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El conjunto B no esta vacio");
                                    }
                                }
                                break;
                            case "7":
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                conjuntoListaUniversal.mostrarConjunto();
                                inputs = JOptionPane.showInputDialog(null, "A. el conjunto A como subconjunto de B\nB. el conjunto B como subconjunto de A.\nC. el conjunto A como subconjunto del universal. \nD. el conjunto B como subconjunto del universal");
                                switch (inputs) {
                                    case "A":
                                        if (conjuntoListaA.subconjuntoA(conjuntoListaB)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                            + " \nes subconjunto de B: \n"
                                                            + conjuntoListaB.getConcatenator());
                                        }else{
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                            + " \nNo es subconjunto de B: \n"
                                                            + conjuntoListaB.getConcatenator());
                                        }
                                        break;
                                    case "B":
                                        if (conjuntoListaB.subconjuntoA(conjuntoListaA)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                            + " \nes subconjunto de A: \n"
                                                            + conjuntoListaA.getConcatenator());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                            + " \nNo es subconjunto de A: \n"
                                                            + conjuntoListaA.getConcatenator());
                                        }
                                        break;
                                    case "C":
                                        if (conjuntoListaA.subconjuntoA(conjuntoListaUniversal)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                            + " \nes subconjunto del universal: \n"
                                                            + conjuntoListaUniversal.getConcatenator());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                            + " \nNo es subconjunto del universal: \n"
                                                            + conjuntoListaUniversal.getConcatenator());
                                        }
                                        break;
                                    case "D":
                                        if (conjuntoListaB.subconjuntoA(conjuntoListaUniversal)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoListaA.getConcatenator()
                                                            + " \nes subconjunto del Universal: \n"
                                                            + conjuntoListaUniversal.getConcatenator());
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "El conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                            + " \nNo es subconjunto del universal: \n"
                                                            + conjuntoListaUniversal.getConcatenator());
                                        }
                                        break;
                                
                                    default:
                                        break;
                                }
                                
                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();
                                conjuntoListaUniversal.resetTestConcatenator();
                                break;
                            case "8":
                                ConjuntoLista union = conjuntoListaA.union(conjuntoListaB);
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                union.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La union del conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                + "\n y el conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                + "\n es \n" + union.getConcatenator());

                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();
                                break;
                            case "9":
                                ConjuntoLista interseccion = conjuntoListaA.union(conjuntoListaB);
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                interseccion.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La interseccion del conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                + "\n y el conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                + "\n es \n" + interseccion.getConcatenator());

                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();
                                break;
                            case "10":
                                ConjuntoLista complemento = conjuntoListaA.union(conjuntoListaUniversal);
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaUniversal.mostrarConjunto();
                                complemento.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La union del conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                + "\n y el conjunto B: \n" + conjuntoListaUniversal.getConcatenator()
                                                + "\n es \n" + complemento.getConcatenator());

                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaUniversal.resetTestConcatenator();
                                break;
                            case "11":
                                ConjuntoLista diferencia = conjuntoListaA.union(conjuntoListaB);
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                diferencia.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La diferencia del conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                + "\n y el conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                + "\n es \n" + diferencia.getConcatenator());

                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();
                                break;
                            case "12":
                                ConjuntoLista diferenciasimetrica = conjuntoListaA.union(conjuntoListaB);
                                conjuntoListaA.mostrarConjunto();
                                conjuntoListaB.mostrarConjunto();
                                diferenciasimetrica.mostrarConjunto();
                                JOptionPane.showMessageDialog(null,
                                        "La union del conjunto A: \n" + conjuntoListaA.getConcatenator()
                                                + "\n y el conjunto B: \n" + conjuntoListaB.getConcatenator()
                                                + "\n es \n" + diferenciasimetrica.getConcatenator());

                                conjuntoListaA.resetTestConcatenator();
                                conjuntoListaB.resetTestConcatenator();
                                break;
                            case "13":
                                inputs = JOptionPane.showInputDialog(null, opcionConjunto);
                                if (inputs.equals("A")) {
                                    conjuntoListaA.vaciar();
                                } else {
                                    conjuntoListaB.vaciar();
                                }
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
