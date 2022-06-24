public class Nodo {
    public Nodo(){
        this.next = null;
        this.dato = null;
    }
    private String dato;
    private Nodo next;

    public void setDato(String dato) {
        this.dato = dato;
    }public String getDato() {
        return dato;
    }
    
    public void setNext(Nodo next) {
        this.next = next;
    }public Nodo getNext() {
        return next;
    }
}
