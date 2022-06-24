public class Nodo {
    public Nodo(){
        this.next = null;
        this.dato = 0;
    }
    private int dato;
    private Nodo next;

    public void setDato(int dato) {
        this.dato = dato;
    }public int getDato() {
        return dato;
    }
    
    public void setNext(Nodo next) {
        this.next = next;
    }public Nodo getNext() {
        return next;
    }
}
