# Iterazione

Un iterator ci permette di sfruttare l'iterazione sugli oggetti all'interno di una struttura dati, senza rivelare al client quale sia la rappresentazione interna. Ad esempio, non vogliamo rivelare al client se stiamo usando un Array o una Linked List, ma vogliamo far accedere agli elementi sempre nello stesso modo.

Se non avessi un **iterator**, il client dovrebbe o **ciclare** sugli elementi dell'array, oppure accedere ai vari elementi attraverso i **puntatori**.

Java fornisce un **metodo generale** per iterare sugli elementi di **qualsiasi** struttura dati. Per usufruire di ciò, andiamo ad **implementare** l'interfaccia **Iterable**.

## L'interfaccia iterable

L'interfaccia **Iterable** ha un metodo `Iterator`che ritorna un oggetto di tipo **Iterator**. **Iterator** è un'altra interfaccia, avente i metodi:

- `boolean hasNext()`
- `Item next()`
- `void remove()` (solitamente non viene usato)

```java
Iterator<String> i = stack.iterator();
while(i.hasNext()){
	String s = i.next();
	StdOut.println(s);
}
```

Per implementare l'**Interfaccia Iterable** dobbiamo implementare il metodo **iterator** che restituirà un **ListIterator** (che a sua volta implementa **Iterator**)

## Classe ListIterator

```java
private class ListIterator implements Iterator<Item>{
	private Node current = first;
	
	public boolean hasNext(){
		return current != null;
	}
	
	public void remove(){//metodo vuoto}
	
	public Item next(){
		Item item = current.item;
		current = current.next;
		return item;
	}
}
```



# Interfaccia List

```java
								List();
boolean 				isEmpty();
int 						size();
void 						add(Item item);
Item 						get(int index);
Item 						remove(int index);
boolean 				contains(Item item);
Iterator<Item> 	iterator();
  ...
```

Questa interfaccia viene implementata all'interno della libreria standard di **java** da due classi concrete:

- **ArrayList** che usa il **resizing array**
- **LinkedList** che usa le **liste concatenate**

Esiste anche un'implementazione della classe **Stack** all'interno dello stesso package (`java.util`), che supporta le operazioni:

- Push()
- Pop()
- iteration

Questa classe **Stack** estende la classe **Vector**, che implementa l'interfaccia **List**, che include i metodi che abbiamo visto prima.

Questa è un esempio di API **Progettata male**, proprio perchè non dobrebbe implementare i metodi **get()**, **remove()**. Questo perchè nello **stack** dobbiamo usare i metodi **push()** e **pop()** per aggiungere o rimuovere elementi, e non **get() e remove()**. Inoltre, queste operazioni vengono effettuate solo sul **top dello stack**, e non in altre posizioni.

---

Per quanto riguarda la **Queue**, esiste un'**Interfaccia**, ma non esiste un'**implementazione**. Sarà compito del programmatore della classe custom, implementare i metodi dell'**Interfaccia**.



## Applicazioni dello stack

- Parser in un compilatore
- 'annulla' in un **word processor**
- Tasto 'indietro' in un **browser**

Possiamo inoltre usare due stack per risolvere delle espressioni in parentesi:

`( 1 + (( 2 + 3) * ( 4 * 5)))`

Avremo quindi due **Stacks**:

- Stack dei **valori**
- Stack degli **operatori**

**L'algoritmo** è il seguente:

- Se mentre effettuo il **parsing** da sinistra a destra incontro un valore, lo aggiungo (**push()**) nello stack dei **valori**. 
- Se incontro un **operatori**, lo aggiungo allo stack degli operatori.

- Se incontro una parentesi sinistra `(` la **ignoro**.

- Se incontro una parentesi destra `)` effettuo:
  - effettuo il **pop()** per l'operatore
  - effettuo **due pop()** per i due valori sul **top** dello **stack dei valori**
  - effettuo il **push()** del risultato dell'operazione dei due valori con l'operatore, sullo stack dei valori.



[Animazione]()







