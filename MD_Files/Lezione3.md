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



# Applicazioni dello Stack

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

[Animazione `pagina 53`](https://github.com/follen99/AlgorithmsAndDataStructures_java/blob/main/PDFs/13StacksAndQueues.pdf)

## Codice

```java
public class Evaluate{
  public static void main(String args){
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    
    while(!StdIn.isEmpty()){
      String s = StdIn.readString();
      if (s.equals("("));		//do nothing
      else if (s.equals("+"))	ops.push(s);
      else if (s.equals("*"))	ops.push(s);
      else if (s.equals(")")){
        String op = ops.pop();
        if (op.equals("+")) vals.push(vals.pop + vals.pop());
        else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
      }
      else vals.push(Double.parseDouble(s));
    }
    StdOut.println(vals.pop());
  }
}
```

**Eseguire il programma: ** `% java Evaluate ( 1 + (( 2 + 3) * ( 4 * 5)))`

**Output: ** `101.0`

## Osservazioni

L'**Algoritmo** computa le operazioni anche quando l'operatore appare dopo i due operandi.

Utilizzando la notazione `( 1 + (( 2 + 3) * ( 4 * 5)))` le parentesi diventano ridondanti, e quando trovo un operatore, semplicemente devo prendere i due operandi che si trovano al **top** dello stack, effettuare l'operazione e restituire il risultato sul top dello stack.

La notazione precedente corrisponde a: 

`1 2 3 + 4 5 * * +` 	notazione **PostFix**



# Analisi degli algoritmi

Le prestazioni di un algoritmo possono dipendere sia dalla **macchina** su cui esso è eseguito, sia dall'algoritmo stesso. 

L'architettura della macchina che viene utilizzata ha ovviamente influenza sulle prestazioni: se utilizzo un computer con un processore datato, avrò delle prestazioni inferiori rispetto allo stesso algoritmo che viene eseguito su un computer dalle prestazioni migliori.

Noi ci occuperemo solo delle prestazioni che dipendono **strettamente** dall'algoritmo. 

## Storia

Da quando si è cominciato ad utilizzare delle macchine per eseguire le operazioni, la prima domanda è stata: `come posso minimizzare il numero di operazioni per arrivare al risultato?` 

Le ragioni per analizzare gli algoritmi sono varie, ma la principale è quella di predirre quali saranno le **performance** a partire da come è strutturato un algoritmo. Potendo predirre quelle che sono le prestazioni degli algoritmi, posso effettuare una **comparazione** tra i vari algoritmi, andando a scegliere il migliore per le mie esigenze. 

## Esempio pratico

La **Trasformata di Fourier** viene utilizzata in applicazioni come **DVD, JPEG, astrofisica...** , e l'algoritmo **Brute Force** per questo tipo di problema viene completato in un tempo pari a N<sup>2</sup>  passaggi.

E' stato però proposto un algoritmo di **Fast Furier Transform** che ha permesso di abilitare nuove tecnologie, come alle fotocamere digitale, mp3 portatili, ecc. Esso ha un tempo di esecuzione pari a `N log N` , molto più veloce.

## Metodo Scientifico

- **Osservare** alcune caratteristiche nel mondo naturale
- **Ipotizzare** un modello che sia coerente con le osservazioni
- **Predirre** gli eventi delle ipotesi
- **Verificare** le previsioni facendo ulteriori osservazioni
- **Validare** ripetendo finchè le ipotesi e osservazioni sono concordi

possiamo usare due soluzioni per capire quali sono le prestazioni di un algoritmo:

### Soluzione Empirica

Andiamo a misurare quello che è effettivamente il tempo che un algoritmo impiega ad essere eseguito su una serie di **input** diversi

### Soluzione Matematica

Consiste nell'andare a contare la **frequenza** delle operazioni che vengono effettuate per completare l'algoritmo.

### Principi

- Gli esperimenti devono essere **Riproducibili**
- Le ipotesi devono essere **Falsificabili**

### Esempio

Se faccio l'ipotesi che il mio algoritmo completa in un tempo proporzionale a `N` e andando a fare le verifiche mi rendo conto che invece di essere proporzionale ad `N`, è proporzionale ad N<sup>2</sup>. 

Ho così **falsificato** la mia ipotesi. Dovrò fare una nuova ipotesi che mi permetta di fare una predizione più attinente a quello che è il **Mondo Reale**.



## Esempio: 3-Sum

`3-Sum`: Dati `N` diversi interi, quante diverse triplette mi daranno come risultato `0`?

### Algoritmo bruteforce

Quando andiamo a risolvere questo problema su un numero N piccolo, abbiamo subito la soluzione, ma man mano che N diventa grande, questo problema si complica sempre di più.

Questo perchè l'algoritmo **bruteforce** per questo problema deve verificare **tutte** le triplette.

| a[i] | a[j] | a[k] | sum  |
| :--: | :--: | :--: | :--: |
|  30  | -40  |  10  |  0   |
|  30  | -20  | -10  |  0   |
| -40  |  40  |  0   |  0   |
| -10  |  0   |  10  |  0   |

#### Codice

```java
public class ThreeSum{
  public static int count(int[] a){
    int N = a.lenght;
    int count = 0;
    
    for(int i = 0; i < N; i++)
      for(int j = i+1; j < N; j++)
        for(int k = j+1; k < N; k++)
          if(a[i] + a[j] + a[k] == 0)
            count++;
    return count
  }
  
  public static void main(String[] args){
    In in = new In(args[0]);
    int[] a = in.readAllInts();
    StdOut.println(count(a));
  }
}
```

#### Misurare il tempo di esecuzione manualmente

Possiamo misurare il tempo **fisicamente** con un orologio manuale, ovviamente questo metodo si presta ad errori, opteremo per qualcosa di più preciso.

#### Misurare il tempo di esecuzione automaticamente

Per avere una misurazione più accurata possiamo usare la classe **Stopwatch**, avente la seguente API:

- Stopwatch() `Costruttore`
- double elapsedTime() `tempo dalla creazione`

``` java
public static void main(String[] args){
  	In in = new In(args[0]);
    int[] a = in.readAllInts();
  	
  	Stopwatch stopwatch = new Stopwatch();	//faccio partire lo stopwatch
  
    StdOut.println(count(a));
  
  	double time = stopwatch.elapsedTime();	//misuro il tempo appena finisco di contare le triplette
  
  	StdOut.println("Elapsed time: " + time);
}
```

#### Ipotesi del raddoppio

Un metodo semplice per **stimare** il **coefficiente angolare** della retta che mette in relazione il tempo di esecuzione con il numero di operazioni, è quello di **duplicare** sempre la grandezza dell'**input**.



<img src="https://latex.codecogs.com/png.image?\dpi{110}&space;\bg_white&space;\frac{T(2N)}{T(N)}&space;=&space;\frac{\alpha(2N)^b}{\alpha&space;N^b}&space;=&space;2^b" title="\bg_white \frac{T(2N)}{T(N)} = \frac{\alpha(2N)^b}{\alpha N^b} = 2^b" />



| N    | Tempo(secondi) | ratio | lg ratio |
| ---- | -------------- | ----- | -------- |
| 250  | 0.0            |       | -        |
| 500  | 0.0            | 4.8   | 2.3      |
| 100  | 0.1            | 6.9   | 2.8      |
| 2000 | 0.8            | 7.7   | 2.9      |
| 4000 | 6.4            | 8.0   | 3.0      |
| 8000 | 51.1           | 8.0   | 3.0      |

Se guardiamo gli ultimi due valori (ratio e lg ratio) delle ultime due righe (4000 e 8000), ci accorgiamo che sembra convergere alla costante b = 3.

Di conseguenza, se conosciamo **b**, possiamo sostituirlo all'equazione ed **approssimare** il comportamento dell'algoritmo.

Questo metodo ci torna utile nel momento in cui abbiamo un algoritmo di cui non possiamo guardare il codice effettivo, in modo da poter fare un **reverse engineering** e scoprirne il comportamento.

## Modelli matematici

Possiamo capire il running time se invece di effettuare una procedura **sperimentale** come la precedente, andiamo ad analizzare l'algoritmo in modo da capire la **frequenza** delle operazioni e moltiplicarle per il **costo** delle singole operazioni.

Abbiamo bisogno di analizzare l'**algoritmo**, ed il costo dipende dalla **macchina**, più che dall'algoritmo stesso. 

### Costo di operazioni base

Come stimare operazioni costanti?

|        operazione        | esempio | nanosecondi |
| :----------------------: | :-----: | :---------: |
|     addizione interi     |  a + b  |     2.1     |
|  moltiplicazione interi  |  1 * b  |     2.4     |
|     divisione interi     |  1 / b  |     5.4     |
| addizione floating point |  a + b  |     4.6     |
| divisione floating point |  a / b  |     4.2     |

`Ovviamente le prestazioni dipendono interamente dalla macchina su cui sono eseguite`

`Questi tempi sono presi da un MacBook con CPU 2.2GHz e 2GB di ram`

Se proviamo ad eseguire delle operazioni base diverse volte, ne calcoliamo il tempo di esecuzione e ne facciamo la media, ci accorgiamo che hanno sempre lo stesso tempo:

|         operazione         | esempio  |  nanosecondi  |
| :------------------------: | :------: | :-----------: |
| dichiarazione di variabile |  int a   | c<sub>1</sub> |
|        assegnazione        |  a = b   | c<sub>2</sub> |
|    comparazione interi     |  a < b   | c<sub>3</sub> |
| Accesso ad elemento array  |   a[i]   | c<sub>4</sub> |
|      lunghezza array       | a.lenght | c<sub>5</sub> |

Quelle che non sono **operazioni primitive**, spesso impiegano un **tempo maggiore** rispetto a quello costante.

### Esempi

#### 1-Sum

```java
int count = 0;
for(int i = 0; i < N; i++)
  if(a[i] == 0)
    count ++;
```

Con questo codice stiamo contando quante volte appare un intero pari a **0** nell'array **a**. Per fare ciò dobbiamo **ciclare** su tutti gli elementi, quindi abbiamo che la frequenza è data dal `for`.

Se andiamo a vedere tutte le operazioni che vengono eseguite nel codice otteniamo:

|       Operazione        | Frequenza |
| :---------------------: | :-------: |
| dichiarazione variabile |     2     |
|      assegnazione       |     2     |
|    Comparazione less    |    N+1    |
|   Comparazione uguale   |     N     |
|   `accesso all'array`   |     N     |
|       incremento        | da N a 2N |

Capiamo subito che, all'aumentare di N, le operazioni che verranno eseguite maggiormente, **sono quelle che dipendono da N** (come ad esempio l'accesso all'array).

#### 2-Sum

```java
int count = 0;
	for(int i = 0; i < N; i++)
    for(int j = i+1; j < N; j++)
      if(a[i] + a[j] == 0)
        count ++;
```

In questo caso abbiamo **due cicli for**, ed andiamo a verificare quali sono le due coppie che hanno **somma = 0**. Dobbiamo quindi verificare tutte le **combinazioni lineari**, date dalla formula: 

<img src="https://latex.codecogs.com/png.image?\dpi{110}&space;\bg_white&space;\binom{N}{2}" title="\bg_white \binom{N}{2}" />

Il perchè della formula è molto semplice, infatti guardando il codice ci accorgiamo che sebbene il primo `for` controlli tutti gli elementi di `a`, il secondo parte sempre da `i+1`, di conseguenza controllerà solo la `diagonale superiore` della combinazione `a x a`.

![Schermata 2021-09-26 alle 18.08.53](/Users/folly/Desktop/Schermata 2021-09-26 alle 18.08.53.png)
