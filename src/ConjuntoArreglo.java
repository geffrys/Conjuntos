public class ConjuntoArreglo {
    // para la union se podria hacer el tamaño a partir de la suma del tamaño de los dos subconjuntos
    private int cantidadElementos;
    private String[] conjunto;

    public ConjuntoArreglo(int cantidadElementos){
        this.cantidadElementos = cantidadElementos;
        this.conjunto = new String[this.cantidadElementos];
    }

    public String getDato(int posicion){
        return this.conjunto[posicion];
    }public void setDato(int dato){

    }
    public int getCantidadElementos() {
        return cantidadElementos;
    }
    public boolean inConjunto(String elemento){
        for (int i = 0; i < conjunto.length; i++) {
            if(conjunto[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }
    public boolean subconjuntoA(ConjuntoArreglo B){
        
    }
}
