package net.elazzaouy;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
//Introduit dans Java 8

public class MainFunc {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        //Consumer<String> consumer = (input) -> System.out.println(input);
        consumer.accept("check");
        /*
        Consumer<T> : Cette interface fonctionnelle prend un argument de type T et ne retourne rien (void).
        Elle est utilisée lorsque vous souhaitez effectuer une action sur un objet de type T,comme 
        l'impression, l'enregistrement en base de données, la mise à jour d'un état, etc.
         */

        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
        /*
        Supplier<T> : Cette interface fonctionnelle ne prend aucun argument et retourne un résultat de type T.
        Elle est utilisée lorsque vous avez besoin de fournir une valeur de type T, généralement pour
        l'initialisation ou la création d'objets.
         */

        Function<Integer, Integer> func = input -> input*9;
        System.out.println(func.apply(9));
        /*
        Function<T, R> : Cette interface fonctionnelle prend un argument de type T et renvoie un résultat de type R.
        Elle est utilisée pour transformer un objet de type T en un objet de type R, comme la conversion,
         la manipulation ou la transformation de données.
         */

    }
}
