package net.elazzaouy.business;

import net.elazzaouy.model.BankAccount;

@FunctionalInterface
/*
public interface Condition { // Interface Fonctionnelle
    boolean test(BankAccount bankAccount);

   /*Une interface fonctionnelle est une interface qui ne contient qu'une seule méthode abstraite.
    Java 8 introduit des annotations spéciales telles que @FunctionalInterface pour marquer une interface
    comme fonctionnelle. Cela permet d'utiliser des lambdas et des références de méthode pour créer des
    instances de cette interface.

}
*/

public interface Condition<T> { // Interface Générique
    boolean test(T o);

    /*les interfaces génériques sont un moyen puissant de créer des composants réutilisables et flexibles en Java.
     Elles permettent de définir des interfaces qui fonctionnent avec différents types de données tout en
     garantissant la sécurité de type à la compilation.
     */
}

