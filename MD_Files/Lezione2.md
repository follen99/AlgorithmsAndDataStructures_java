# Lezione 2
## Implementare gli ADT's
Usiamo le variabili d’istanza per rappresentare le caratteristiche di un **oggetto**. E’ buona pratica usare l’identificatore `private` per le variabili, in modo da renderle accessibili solo tramite i **metodi di accesso alle variabili**.
## Progettare gli ADT's
L’obbiettivo principale è quello di nascondere il più possibile l’implementazione interna e separare l’interfaccia dall’implementazione. Nel progettare le **API** è buona norma fornire **solo** i metodi di cui i **client** avranno bisogno.

## Strutture dati - Stacks e Queues
Le due strutture dati si differenziano per la politica con cui **aggiungono**  e **rimuovono** gli elementi. Infatti la pila è di tipo **LIFO**, mentre la coda di tipo **FIFO**.

Le operazioni di entrambe sono:
-	insert()
-	remove()
-	iterate()
-	testEmpty()

![enter image description here](https://vitolavecchia.altervista.org/wp-content/uploads/2020/11/Differenza-tra-strutture-dati-a-pila-e-coda-in-informatica.png)



## Stacks

Uno stack è una struttura dati che utilizza la politica '**LIFO**: quando impiliamo dei documenti, stiamo utilizzando uno **stack**. Un altro esempio di **stack** è la cronologia di un **browser**, infatti esso effettua un **push()** quando visitiamo un sito, mentre effettua un **pop()** quando si torna al sito precedente.

## Stack API

- StackOfStrings()	-costruttore
- void **push()** -inserisce nello stack
- String **pop()** -rimuove un elemento
- int **size()** -ritorna la grandezza dello stack

## Queues

Una queue p una struttura basata sul principio '**FIFO**'. La politica di effettuare dei task nell'ordine in cui essi arrivano è collegabile al concetto 'reale' di '**EQUITA'**'. Potremmo usare questa struttura, ad esempio, per popolare un array di elementi letti da un file, nell'ordine in cui sono letti.

## Queue API

- void **Queue**()	-costruttore
- void **enqueue()** -inserisce nella queue
- String **dequeue()** -rimuove un elemento
- int **size()** -ritorna la grandezza dello queue
- Boolean **isEmpty()** -controlla se la queue è vuota

## Bags

Una Bag è una collezione dove la rimozione di un elemento **NON** è supportata. Inoltre, l'ordine di **iterazione** non è specificato, e dovrebbe non avere importanza per l'utente. Un esempio di applicazone potrebbe essere il seguente:

consideriamo l'immissione nello `stdInput`una serie di numeri, con l'obbiettivo di calcolarne la **media**. Per questo tipo di calcolo, l'ordine degli elementi è **irrilevante.**

## Bag API

- **Bag()**	-costruttore
- void **add()** -inserisce nella bag
- boolean **isEmpty()** -controlla se la queue è vuota
- int **size()** -ritorna la grandezza della bag

## Aggiungere un elemento

Per aggiungere un elemento, per prima cosa viene salvato la reference del **primo elemento.** Successivamente, viene creato un **nuovo nodo** e viene inserito l'item al suo interno, con `intem.next = oldFirst`

## Implementare uno stack statico con un array

Usiamo un puntatore che punta sull'index dell'array. Come beneficio abbiamo che sappiamo sempre dove si trova l'ultimo elemento, ma con una capacità limitata.



## Loitering

Il **Garbage Collector** di Java ha come obbiettivo quello di 'pulire' automaticamente dalla memoria gli elementi che non possono più essere raggiunti. Il problema, è che usando gli **array** per implementare gli stack, nel momento in cui eseguiamo un **pop()** di un elemento, il riferimento all'elemento persiste nell'array. 

Come conseguenza, il **Garbage Collector** non ha idea che quell'elemento non verrà più usato.

La soluzione a questo problema non è troppo difficile: basta includere nel codice della **pop()** una porzione di codice che imposti a **null** il riferimento dell'elemento eliminato.

```arr[deletedElement] = null``` 







