
public class ConjuntoLista {
    private Nodo cabeza;

    public Nodo getCabeza() {
        return cabeza;
    }public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    // constructor
    public ConjuntoLista(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public String testConcatenator = "";
    public void resetTestConcatenator() {
        this.testConcatenator = "";
    }

    public void mostrarConjunto(){
        Nodo p = this.getCabeza();
        while(p!= null){
            System.out.println(p.getDato()+" ");
            testConcatenator+= p.getDato();
            p= p.getNext();           
        }
    }
    
    public int cantidadElementos(){
        Nodo p = this.getCabeza();
        int counter=0;
        while (p!=null) {
            counter++;            
            p= p.getNext();           
        }
        return counter;
    }

    public boolean pertenece(String dato){
        Nodo p = this.getCabeza();
        while (p!=null) {
            if(p.getDato().equals(dato)){
                return true;
            }
        }
        return false;
    }
}
