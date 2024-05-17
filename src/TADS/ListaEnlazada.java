package TADS;

public class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {
    private Nodo<T> primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public void add(T value, int position) {
        int i = 0;
        Nodo<T> temp1 = null;
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            while (temp.getSiguiente() != null && i < position) {
                temp = temp.getSiguiente();
                i += 1;
            }
            if (temp.getSiguiente() != null) {
                temp1 = temp.getSiguiente();
            }
                temp.setSiguiente(new Nodo<T>(value));
                (temp.getSiguiente()).setSiguiente(temp1);
        } else{
            this.setPrimero(new Nodo<>(value));
        }
    }

    public void remove(int position) throws WrongPositionException {
        int i = 0;
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            Nodo<T> temp1 = null;
            while (i < position && temp.getSiguiente() != null) {
                temp1 = temp;
                temp = temp.getSiguiente();
                i += 1;
            }
            if (i == position) {
                temp1.setSiguiente(temp.getSiguiente());
            }
            else {
                throw new WrongPositionException();
            }
        }
    }

    public T get(int position) {
        int i = 0;
        Nodo<T> nodeToReturn = null;
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            while (i < position && temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                i += 1;
            }
            if (i == position) {
                nodeToReturn = temp;
            }
        }
        return nodeToReturn.getValue();
    }

    public Nodo<T> getNode(int position) {
        int i = 0;
        Nodo<T> nodeToReturn = null;
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            while (i < position && temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                i += 1;
            }
            if (i == position) {
                nodeToReturn = temp;
            }
        }
        return nodeToReturn;
    }

    public boolean contains(T value) {
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            while (temp.getValue() != value && temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            if (temp.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    public void addFirst(T value) {
        Nodo<T> temp = new Nodo<T>(value);
        if (this.primero != null) {
            Nodo<T> temp1 = this.primero;
            temp.setSiguiente(temp1);
            this.primero = temp;
        } else {
            setPrimero(temp);
        }
    }

    public void addLast(T value) {
        if (this.primero != null) {
            Nodo<T> temp = this.primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(new Nodo<T>(value));
        } else {
            this.setPrimero(new Nodo<>(value));
        }
    }

    public int size(){
        if (this.primero == null){
            return 0;
        }
        int i = 1;
        Nodo<T> temp = primero;
        while (temp.getSiguiente() != null){
            i++;
            temp = temp.getSiguiente();
        }
        return i;
    }
}
