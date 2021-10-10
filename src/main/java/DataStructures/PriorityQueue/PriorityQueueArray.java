package DataStructures.PriorityQueue;

public class PriorityQueueArray {
    private int MAX;        //tiene traccia dell'elemento massimo, così da non dover ricercarlo ogni volta
    private int[] arr;      //la struttura dati usata
    private int nItems;      //il numero di elementi nella struttura.

    public PriorityQueueArray(int size){
        this.MAX = size;
        this.arr = new int[MAX];
        this.nItems = 0;        //all'inizio gli elementi sono zero
    }

    public void insert(int val){
        //caso in cui la coda è vuota
        int i;
        if (nItems == 0){
            arr[0] = val;   //semplicemente assegno l'elemento al primo elemento dell'array
            nItems++;       //incremento il numero di elementi
            return;
        }
        //tutti gli altri casi
        for (i = nItems - 1; i>=0; i--){    //scorro gli elementi dalla fine finchè l'elemento non è in posizione
            if (val > arr[i])               //se l'el da inserire è maggiore dell'el corrente allora...
                arr[i+1] = arr[i];          //scambio l'el corrente con la posizione successiva
            else break;                     //quindi continuo
        }

        arr[i+1] = val;                     //infine imposto l'elemento da inserire
        nItems++;
    }

    /*
    Metodo da usare con gli oggetti
    public int poll(){
        int element = arr[nItems];
        arr[nItems] = null;
        nItems--;
        return element;
    }*/

    /**
     * Questo metodo è molto ottimizzato, ma ha un problema:
     * - problema del loitering, l'elemento eliminato rimane nell'array
     * Questo metodo non andrebbe usato se la struttura contenesse degli OGGETTI
     * ma visto che stiamo parlando di array, non è un problema in quanto la grandezza dell'array è statica*/
    @Deprecated
    public int remove(){
        return arr[--nItems];   //ritorna l'ultimo elemento ma allo stesso tempo decrementa il numero di elementi (solo il count)
    }

    public boolean isEmpty(){
        return nItems == 0;
    }
    public boolean isFull(){
        return nItems == MAX;
    }

    public int peek(){
        return arr[nItems-1];
    }

    public int[] getElements(){
        return this.arr;
    }
}
