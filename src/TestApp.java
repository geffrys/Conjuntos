

import org.junit.Test;

import junit.framework.TestCase;

public class TestApp extends TestCase{
    final String[] universal = {"3","7","6","9","4","0","2","1","8","5"};
    final String[] conjuntoA = {"3","1","5","8","2"};
    final String[] conjuntoB = {"9","2","1","8","5"};
    ConjuntoArreglo Uni1 = new ConjuntoArreglo(universal.length), A1 = new ConjuntoArreglo(conjuntoA.length), B1 = new ConjuntoArreglo(conjuntoB.length);
    ConjuntoLista Uni2 = new ConjuntoLista(null), A2 = new ConjuntoLista(null), B2 = new ConjuntoLista(null);

    // Escenarios de testeo

    private void scenary1Arrays(){
        for (int i = 0; i < conjuntoA.length; i++) {
            A1.setDato(conjuntoA[i], i);
        }for (int i = 0; i < conjuntoB.length; i++) {
            B1.setDato(conjuntoB[i], i);
        }for (int i = 0; i < universal.length; i++) {
            Uni1.setDato(universal[i], i);
        }
    }
    private void scenary2Lists(){
        for (int i = 0; i < conjuntoA.length; i++) {
            A2.agregarElemento(conjuntoA[i]);
        }for (int i = 0; i < conjuntoB.length; i++) {
            B2.agregarElemento(conjuntoB[i]);
        }for (int i = 0; i < universal.length; i++) {
            Uni2.agregarElemento(universal[i]);
        }
    }

    // Pruebas del conjunto arreglo

    @Test
    public void testUnionArreglo(){
        scenary1Arrays();
        ConjuntoArreglo union = A1.union(B1);
        union.mostrarConjunto();
        assertEquals("315829", union.getConcatenadorMostrar());
        union.setConcatenadorMostrar("");
    }

    @Test
    public void testInterseccionArreglo(){
        scenary1Arrays();
        ConjuntoArreglo interseccion = A1.interseccion(B1);
        interseccion.mostrarConjunto();
        assertEquals("1582", interseccion.getConcatenadorMostrar());
        interseccion.setConcatenadorMostrar("");
    }

    @Test
    public void testVacioArreglo(){
        scenary1Arrays();
        assertEquals(false, A1.esVacio());
    }

    @Test
    public void testVacio1Arreglo(){
        assertEquals(true, A1.esVacio());
    }

    @Test
    public void testSubconjuntoArreglo(){
        scenary1Arrays();
        assertEquals(true, A1.subconjuntoA(Uni1));
    }

    @Test
    public void testSubconjunto1Arreglo(){
        scenary1Arrays();
        assertEquals(false, A1.subconjuntoA(B1));
    }

    @Test
    public void testComplementoArreglo(){
        scenary1Arrays();
        ConjuntoArreglo complemento = A1.complemento(Uni1);
        complemento.mostrarConjunto();
        assertEquals("76940", complemento.getConcatenadorMostrar());
    }

    @Test
    public void testComplemento1Arreglo(){
        scenary1Arrays();
        ConjuntoArreglo complemento = B1.complemento(Uni1);
        complemento.mostrarConjunto();
        assertEquals("37640", complemento.getConcatenadorMostrar());
    }

    @Test
    public void testDiferenciaArreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = A1.diferencia(B1);
        diferencia.mostrarConjunto();
        assertEquals("3", diferencia.getConcatenadorMostrar());
    }
    @Test
    public void testDiferencia1Arreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = B1.diferencia(A1);
        diferencia.mostrarConjunto();
        assertEquals("9", diferencia.getConcatenadorMostrar());
    }
    @Test
    public void testDiferencia2Arreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = A1.diferencia(Uni1);
        diferencia.mostrarConjunto();
        assertEquals("", diferencia.getConcatenadorMostrar());
    }
    @Test
    public void testDiferencia3Arreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = Uni1.diferencia(A1);
        diferencia.mostrarConjunto();
        assertEquals("76940", diferencia.getConcatenadorMostrar());
    }

    @Test
    public void testDiferenciaSimetricaArreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = A1.diferenciaSimetrica(B1);
        diferencia.mostrarConjunto();
        assertEquals("93", diferencia.getConcatenadorMostrar());
    }
    @Test
    public void testDiferenciaSimetrica1Arreglo(){
        scenary1Arrays();
        ConjuntoArreglo diferencia = A1.diferenciaSimetrica(Uni1);
        diferencia.mostrarConjunto();
        assertEquals("76940", diferencia.getConcatenadorMostrar());
    }

    // pruebas del conjunto en lista

    @Test
    public void testUnionLista(){
        scenary2Lists();
        ConjuntoLista union = A2.union(B2);
        union.mostrarConjunto();
        assertEquals("315829", union.getConcatenator());
        union.resetTestConcatenator();
    }

    @Test
    public void testInterseccionLista(){
        scenary2Lists();
        ConjuntoLista interseccion = A2.interseccion(B2);
        interseccion.mostrarConjunto();
        assertEquals("1582", interseccion.getConcatenator());
    }

    @Test
    public void testVacioLista(){
        scenary2Lists();
        assertEquals(false, A2.esVacio());
    }
    @Test
    public void testVacioLista1(){
        assertEquals(true, A2.esVacio());
    }
    @Test
    public void testSubconjunto1Lista(){
        scenary2Lists();
        assertEquals(true, A2.subconjuntoA(Uni2));
    }
    @Test
    public void testSubconjuntoLista1(){
        scenary2Lists();
        assertEquals(false, A2.subconjuntoA(B2));
    }
    @Test
    public void testComplementoLista(){
        scenary2Lists();
        ConjuntoLista complemento = A2.Complemento(Uni2);
        complemento.mostrarConjunto();
        assertEquals("76940", complemento.getConcatenator());
    }
    @Test
    public void testComplementoLista1(){
        scenary2Lists();
        ConjuntoLista complemento = B2.Complemento(Uni2);
        complemento.mostrarConjunto();
        assertEquals("37640", complemento.getConcatenator());
    }
    @Test
    public void testDiferenciaLista(){
        scenary2Lists();
        ConjuntoLista diferencia = A2.diferencia(B2);
        diferencia.mostrarConjunto();
        assertEquals("3", diferencia.getConcatenator());
    }
    @Test
    public void testDiferenciaLista1(){
        scenary2Lists();
        ConjuntoLista diferencia = B2.diferencia(A2);
        diferencia.mostrarConjunto();
        assertEquals("9", diferencia.getConcatenator());
    }
    @Test
    public void testDiferenciaLista2(){
        scenary2Lists();
        ConjuntoLista diferencia = A2.diferencia(Uni2);
        diferencia.mostrarConjunto();
        assertEquals("", diferencia.getConcatenator());
    }
    @Test
    public void testDiferenciaLista3(){
        scenary2Lists();
        ConjuntoLista diferencia = Uni2.diferencia(A2);
        diferencia.mostrarConjunto();
        assertEquals("76940", diferencia.getConcatenator());
    }
    @Test
    public void testDiferenciaSimetricaLista(){
        scenary2Lists();
        ConjuntoLista diferenciaSimetrica = A2.diferenciaSimetrica(B2);
        diferenciaSimetrica.mostrarConjunto();
        assertEquals("39", diferenciaSimetrica.getConcatenator());
    }
    @Test
    public void testDiferenciaSimetricaLista1(){
        scenary2Lists();
        ConjuntoLista diferenciaSimetrica = A2.diferenciaSimetrica(Uni2);
        diferenciaSimetrica.mostrarConjunto();
        assertEquals("76940", diferenciaSimetrica.getConcatenator());
    }
}
