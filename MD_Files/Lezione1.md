# Lezione 1
## Algoritmi
Un algoritmo può essere definito tramite un **linguaggio naturale**, semplicemente descrivendo l'algoritmo a parole, oppure scrivendo un **programma** che implementi la procedura.

```
public static int gcd(int p, int q){
	if(q==0) return p
	int r = p % q;
	return gcd(q,r);
}
```
## Perchè usare gli algoritmi?
Quando usiamo un computer per aiutarci a risolvere un problema, possiamo usare un gran numero di approcci. Per problemi piccoli, possiamo scegliere un qualsiasi approccio, purchè esso risolva il problema. Quando invece ci troviamo a risolvere un **problema grande**, dobbiamo stare attenti a quale approccio, e quindi **algoritmo**, scegliamo. Infatti un buon algoritmo ottimizzato può farci risparmiare molto tempo.

Grazie agli algoritmi, inoltre, possiamo risolvere problemi che altrimenti **non sarebbero risolvibili**, come ad esempio visualizzare qualcosa di invisibile, come nel caso di un **buco nero**.
![](https://www.media.inaf.it/wp-content/uploads/2019/04/buco.jpg)

## Perché **analizzare** gli algoritmi?
La scelta del migliore algoritmo può essere un processo complicato. Inoltre non dovremmo **mai usare** un algoritmo senza conoscere le **risorse** che potrebbe consumare.