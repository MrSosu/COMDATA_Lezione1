import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Esercizi {

    public static void main(String[] args) {
        List<String> parole = new ArrayList<>();
        parole.add("marco");
        parole.add("ciao");
        parole.add("Roma");
        parole.add("JDK");
        parole.add("marco");
        parole.add("ciccio");
        parole.add("pippo");
        parole.add("roma");
        // 1) Ordinare una lista di stringhe senza modificarla.
        System.out.println("ESERCIZIO 1");

        List<String> parole_sorted = parole.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println(parole_sorted);
        System.out.println("-----------");

        // 2) Convertire in maiuscolo le stringhe in una lista
        System.out.println("ESERCIZIO 2");
        List<String> maiuscole = parole.stream().map(String::toUpperCase).toList();
        System.out.println(maiuscole);
        System.out.println("-----------");

        // 3) Vogliamo scrivere un codice che aggiunga l’IVA ad
        // ogni prezzo contenuto ad una lista di prezzi e li stampi.
        System.out.println("ESERCIZIO 3");
        List<Double> prices = new ArrayList<>();
        prices.add(3.20);
        prices.add(13.50);
        prices.add(7.89);
        prices.add(4.99);
        prices.add(5.30);
        prices.add(6.99);
        prices.stream().mapToDouble(prezzo -> Math.round(prezzo * 1.22*100)/100.0).forEach(System.out::println);
        System.out.println("-----------");

        // 4) Stampare i numeri dispari da 1 a 10
        System.out.println("ESERCIZIO 4");
        IntStream.range(1,11).filter(x -> x % 2 != 0).forEach(System.out::println);
        System.out.println("-----------");

        // 5) Scrivere un metodo per ottenere una stringa che rappresenta
        // la concatenazione delle stringhe contenute in una lista,
        // rese maiuscole e separate da virgola
        System.out.println("ESERCIZIO 5");
        String result = parole.stream().map(String::toUpperCase).
                collect(Collectors.joining(", "));
        System.out.println(result);
        System.out.println("-----------");

        List<Integer> interi = new ArrayList<>();
        interi.add(10);
        interi.add(13);
        interi.add(17);
        interi.add(11);
        interi.add(8);
        interi.add(4);
        // 6) Scrivere un metodo per ottenere, a partire da una lista di numeri, una mappa
        // dove ad ogni numero dispari è associata la sua rappresentazione in stringa
        System.out.println("ESERCIZIO 6");
        Map<Integer, String> mappa = interi.stream().filter(x -> x % 2 != 0).
                collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
        System.out.println(mappa);
        System.out.println("-----------");

        // 7) Scrivere un metodo per ottenere a partire da una lista di stringhe una mappa
        // con chiave la stringa e valore il numero di occorrenze nella lista
        System.out.println("ESERCIZIO 7");
        Map<String, Integer> mappa2 = parole.stream()
                .collect(Collectors.toMap(Function.identity(), x -> 1, Integer::sum));
        System.out.println(mappa2);
        System.out.println("-----------");

        // 8) Scrivere un metodo per ottenere, a partire da una lista di stringhe,
        // restituisca una mappa che ha come chiave la prima lettera (univoca) e
        // come valore la somma delle occorrenze delle stringhe che iniziano con tale lettera.
        //Esempio: ["ciao", "ciao", "come", "va"] produce la mappa {c=3, v=1}
        System.out.println("ESERCIZIO 8");
        Map<Character, Integer> mappa3 = parole.stream().map(String::toLowerCase).collect(Collectors.toMap(x -> x.charAt(0),
        x -> 1, Integer::sum));

        System.out.println(mappa3);
        System.out.println("-----------");
    }

    public static double addIva(double prezzo) {
        return prezzo * 1.22;
    }




}
