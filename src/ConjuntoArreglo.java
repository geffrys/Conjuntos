import javax.swing.JOptionPane;

public class ConjuntoArreglo {
    // para la union se podria hacer el tamaño a partir de la suma del tamaño de los
    // dos subconjuntos
    private int cantidadElementos;
    private String[] conjunto;

    public ConjuntoArreglo(int cantidadElementos) {
        this.cantidadElementos = cantidadElementos;
        this.conjunto = new String[this.cantidadElementos];
    }

    public String getDato(int posicion) {
        return this.conjunto[posicion];
    }

    public void setDato(String dato, int posicion) {

        if (this.esVacio()) {
            this.conjunto[posicion] = dato;
        } else {
            // if(universal.pertenece(dato)){
            if (this.pertenece(dato) == false) {
                this.conjunto[posicion] = dato;
            } else {
                JOptionPane.showMessageDialog(null, "El dato no ha sido ingresado pues ya esta en el conjunto");
            }
            // }
        }
    }

    public int getCantidadElementos() {
        return cantidadElementos;
    }

    public boolean pertenece(String elemento) {
        try {
            if (!this.esVacio()) {
                for (int i = 0; i < this.getCantidadElementos(); i++) {
                    if (this.conjunto[i].equals(elemento)) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean subconjuntoA(ConjuntoArreglo B) {
        boolean flag = false;
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (B.pertenece(this.getDato(i))) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    public boolean esVacio() {
        boolean flag = false;
        for (int i = 0; i < conjunto.length; i++) {
            if (this.getDato(i) != null) {
                return false;
            }
            flag = true;
        }
        return flag;
    }

    public ConjuntoArreglo union(ConjuntoArreglo B) {
        ConjuntoArreglo union = new ConjuntoArreglo(this.getCantidadElementos() + B.getCantidadElementos());
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            union.setDato(this.getDato(i), i);
        }
        int i = 0, x = this.getCantidadElementos();
        while (i < B.getCantidadElementos()) {
            if (!union.pertenece(B.getDato(i))) {
                union.setDato(B.getDato(i), x);
                x++;
            }
            i++;
        }
        return union;
    }

    public ConjuntoArreglo interseccion(ConjuntoArreglo B) {
        ConjuntoArreglo interseccion = new ConjuntoArreglo(
                B.getCantidadElementos() > this.getCantidadElementos() ? B.getCantidadElementos()
                        : this.getCantidadElementos());
        int x = 0;
        if (B.getCantidadElementos() > this.getCantidadElementos()) {
            for (int i = 0; i < B.getCantidadElementos(); i++) {
                if (this.pertenece(B.getDato(i))) {
                    interseccion.setDato(B.getDato(i), x);
                    x++;
                }
            }
        } else {
            for (int i = 0; i < this.getCantidadElementos(); i++) {
                if (B.pertenece(this.getDato(i))) {
                    interseccion.setDato(this.getDato(i), x);
                    x++;
                }
            }
        }
        return interseccion;
    }

    public ConjuntoArreglo diferenciaSimetrica(ConjuntoArreglo B) {
        ConjuntoArreglo diferencia = new ConjuntoArreglo(
                B.getCantidadElementos() > this.getCantidadElementos() ? B.getCantidadElementos()
                        : this.getCantidadElementos());
        int x = 0;
        // se analiza el conjunto b
        for (int i = 0; i < B.getCantidadElementos(); i++) {
            if (!this.pertenece(B.getDato(i))) {
                diferencia.setDato(B.getDato(i), x);
                x++;
            }
        }
        // se analiza el conjunto a pues en el paso anterior no se toman en cuenta los
        // elementos de a para ingresarse al nuevo conjunto
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (!B.pertenece(this.getDato(i))) {
                diferencia.setDato(this.getDato(i), x);
                x++;
            }
        }
        return diferencia;
    }

    public ConjuntoArreglo diferencia(ConjuntoArreglo B) {
        ConjuntoArreglo diferencia = new ConjuntoArreglo(
                B.getCantidadElementos() > this.getCantidadElementos() ? B.getCantidadElementos()
                        : this.getCantidadElementos());
        int x = 0;
        // se analiza el conjunto b
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (!B.pertenece(this.getDato(i))) {
                diferencia.setDato(this.getDato(i), x);
                x++;
            }
        }
        return diferencia;
    }

    public boolean igualdad(ConjuntoArreglo B) {
        boolean flag = false;
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (B.pertenece(this.getDato(i))) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    // los que le faltan al conjunto para igualar al universal
    public ConjuntoArreglo complemento(ConjuntoArreglo B) {
        ConjuntoArreglo complemento = new ConjuntoArreglo(cantidadElementos);
        int x = 0;
        for (int i = 0; i < B.getCantidadElementos(); i++) {
            if (!this.pertenece(B.getDato(i))) {
                complemento.setDato(B.getDato(i), x);
                x++;
            }
        }
        return complemento;
    }

    private String concatenadorMostrar = "";

    public void setConcatenadorMostrar(String concatenadorMostrar) {
        this.concatenadorMostrar = concatenadorMostrar;
    }

    public String getConcatenadorMostrar() {
        return concatenadorMostrar;
    }

    public void mostrarConjunto() {
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (this.conjunto[i] != null) {
                concatenadorMostrar += this.conjunto[i];
            }
        }
    }

    public void vaciar() {
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            this.conjunto[i] = null;
        }
    }

    public void borrar(String dato) {
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (this.conjunto[i].equals(dato)) {
                this.conjunto[i] = null;
            }
        }
    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void posicion(String dato) {
        for (int i = 0; i < this.getCantidadElementos(); i++) {
            if (this.conjunto[i].equals(dato)) {
                this.position = i;
            }
        }
    }
}
