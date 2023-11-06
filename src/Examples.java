import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {
        // ["marco", "ciao", "Roma", "JDK"] -> "marco, ciao, Roma, JDK"
        List<String> parole = new ArrayList<>();
        parole.add("marco");
        parole.add("ciao");
        parole.add("Roma");
        parole.add("JDK");
        String s = "";
        for (String str : parole) {
            s += str.toUpperCase() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        System.out.println(s);


        // con le lambda
        String s_lambda = parole.stream().map(str -> str.toUpperCase()).
                collect(Collectors.joining(", "));
        System.out.println(s_lambda);

        System.out.println("---------------");
        Map<String, Integer> mappa_lunghezze =
                parole.stream().map(String::toUpperCase).
                        collect(Collectors.toMap(
                                x -> x,
                                String::length,
                                (x, y) -> x,
                                TreeMap::new));
        System.out.println(mappa_lunghezze);

    }



}
