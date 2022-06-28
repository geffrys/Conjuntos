import javax.swing.JOptionPane;

public class ConjuntoLista {
    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    // constructor
    public ConjuntoLista(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    private String Concatenator = "";
    public String getConcatenator() {
        return Concatenator;
    }
    public void resetTestConcatenator() {
        this.Concatenator = "";
    }

    public void mostrarConjunto() {
        Nodo p = this.getCabeza();
        while (p != null) {
            // System.out.println(p.getDato() + " ");
            Concatenator += p.getDato();
            p = p.getNext();
        }
    }

    public int cantidadElementos() {
        Nodo p = this.getCabeza();
        int counter = 0;
        while (p != null) {
            counter++;
            p = p.getNext();
        }
        return counter;
    }

    public boolean pertenece(String dato) {
        Nodo p = this.getCabeza();
        while (p != null) {
            if (p.getDato().equals(dato)) {
                return true;
            }
            p=p.getNext();
        }
        return false;
    }

    public boolean subconjuntoA(ConjuntoLista B) {
        Nodo p = this.getCabeza();
        boolean flag = false;
        while (p != null) {
            if (B.pertenece(p.getDato())) {
                flag = true;
            } else {
                return false;
            }
            p = p.getNext();
        }
        return flag;
    }

    public boolean esVacio() {
        // a pesar de que la cabeza es nula se debe comprobar que los elementos sean
        // diferentes de null
        if(this.getCabeza()!=null){
            Nodo p = this.getCabeza();
            boolean flag = false;
            while (p != null) {
                if (p.getDato()==null) {
                    flag = true;
                } else {
                    return false;
                }
                p = p.getNext();
            }
            return flag;
        }
        return true;
    }

    public void agregarElemento(String dato) {
        if (this.cabeza == null) {
            Nodo x = new Nodo(dato);
            this.setCabeza(x);
        } else {
            if(!this.pertenece(dato)){
                Nodo p = this.getCabeza();
                while (p.getNext() != null) {
                    p = p.getNext();
                }
                Nodo x = new Nodo(dato);
                p.setNext(x);
            }
            else{
                JOptionPane.showMessageDialog(null, "El dato no ha sido ingresado pues ya esta en el conjunto");
            }
        }
    }

    public ConjuntoLista union(ConjuntoLista B) {
        ConjuntoLista union = new ConjuntoLista(null);
        Nodo p = this.getCabeza();
        while (p != null) {
            union.agregarElemento(p.getDato());
            p = p.getNext();
        }
        p = B.getCabeza();
        while (p != null) {
            if (!union.pertenece(p.getDato())) {
                union.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return union;
    }

    public ConjuntoLista interseccion(ConjuntoLista B) {
        ConjuntoLista interseccion = new ConjuntoLista(null);
        Nodo p = this.getCabeza();
        while (p != null) {
            if (B.pertenece(p.getDato())) {
                interseccion.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return interseccion;
    }

    public ConjuntoLista diferencia(ConjuntoLista B) {
        ConjuntoLista diferencia = new ConjuntoLista(null);
        Nodo p = this.getCabeza();
        while (p != null) {
            if (!B.pertenece(p.getDato())) {
                diferencia.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return diferencia;
    }

    public ConjuntoLista diferenciaSimetrica(ConjuntoLista B) {
        ConjuntoLista diferencia = new ConjuntoLista(null);
        Nodo p = this.getCabeza();
        while (p != null) {
            if (!B.pertenece(p.getDato())) {
                diferencia.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        p = B.getCabeza();
        while (p != null) {
            if (!this.pertenece(p.getDato())) {
                diferencia.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return diferencia;
    }

    public boolean igualdad(ConjuntoLista B){
        boolean flag = false;
        Nodo p = this.getCabeza();
        while(p!=null){
            if(B.pertenece(p.getDato())){
                flag=true;
            }else{
                return false;
            }
            p = p.getNext();
        }
        return flag;
    }

    public ConjuntoLista Complemento(ConjuntoLista B){
        ConjuntoLista complemento = new ConjuntoLista(null);
        Nodo p = B.getCabeza();
        while (p!=null) {
            if(!this.pertenece(p.getDato())){
                complemento.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return complemento;
    }

    private int posicion = 0;
    public int getPosicion() {
        return posicion;
    }public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void posicionDato(String dato){
        Nodo p = this.getCabeza();
        while (p!=null && !p.getDato().equals(dato)) {
            this.setPosicion(posicion++);
            p = p.getNext();
        }
    }

    public void borrar(String dato){
        if(this.pertenece(dato)){
            Nodo p = this.getCabeza(), ant = p;
            while(p.getDato()!=dato){
                ant = p;
                p = p.getNext();
            }
            ant.setNext(p.getNext());
        }else{
            System.out.println("Not possible");
        }
    }

    public void vaciar(){
        this.setCabeza(null);
    }
}
