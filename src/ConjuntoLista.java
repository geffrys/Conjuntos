
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

    public boolean subconjuntoA(ConjuntoLista B){
        Nodo p = this.getCabeza();
        boolean flag = false;
        while (p!=null) {
            if(B.pertenece(p.getDato())){
                flag=true;
            }else{
                return false;
            }
            p=p.getNext();
        }
        return flag;
    }

    public boolean esVacio(){
        Nodo p = this.getCabeza();
        // a pesar de que la cabeza es nula se debe comprobar que los elementos sean diferentes de null
        boolean flag = false;
        while (p!=null) {
            if(p.getDato().equals(null)){
                flag=true;
            }else{
                return false;
            }
            p=p.getNext();
        }
        return flag;
    }

    public void agregarElemento(String dato){
        if(this.cabeza==null){
            Nodo x = new Nodo(dato);
            this.setCabeza(x);
        }else{
            Nodo p = this.getCabeza();
            while (p.getNext()!=null) {
                p=p.getNext();
            }
            Nodo x = new Nodo(dato);
            p.setNext(x);
        }
    }

    public ConjuntoLista union(ConjuntoLista B){
        ConjuntoLista union = new ConjuntoLista(null);
        Nodo p = this.getCabeza();
        while (p!=null) {
            union.agregarElemento(p.getDato());
            p = p.getNext();
        }
        p = B.getCabeza();
        while (p!=null) {
            if(!union.pertenece(p.getDato())){
                union.agregarElemento(p.getDato());
            }
            p = p.getNext();
        }
        return union;
    }


}
