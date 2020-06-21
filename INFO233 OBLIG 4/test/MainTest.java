import no.uib.info233.tree.LinkedBinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //lager et test set for search tree
    private static LinkedBinarySearchTree searchTree = new LinkedBinarySearchTree();

    @Test
    void main() {

        //legger inn data, bruker bilmerker som eksempler.
        Comparable<String> bmw = "BMW";
        Comparable<String> toyota = "Toyota";
        Comparable<String> nissan = "Nissan";
        Comparable<String> mazda = "Mazda";
        Comparable<String> porsche = "Porsche";

        //tester om searchtree er tomt, om den er tom vil programmet kjøre, om den har noe i vil feilmelding oppstå
        assertTrue(searchTree.isEmpty());

        //tester til bmw
        searchTree.add(bmw);

        //tester om den har blitt lagt til og at vi har 1 verdi i tabellen.
        assertEquals(searchTree.getNumberOfNodes(), 1);

        //tester hvordan testen reagerer når jeg legger til flere verdier samtidig
        searchTree.add(toyota);
        searchTree.add(nissan);
        searchTree.add(mazda);
        searchTree.add(porsche);

        //tester om alle har blit lagt til og at vi faktisk har 5 verier i tabellen.
        assertEquals(searchTree.getNumberOfNodes(), 5);

        //tester hva som skjer dersom man legger til en verdi som allerede eksisterer.
        searchTree.add(nissan);

        //tester at verdien fremdeles er 5, selv om vi la til 2 av samme verdi.
        assertEquals(searchTree.getNumberOfNodes(), 5);

        //tester hva som skjer dersom vi fjerner to verdier samtidig
        searchTree.remove(toyota);
        searchTree.remove(bmw);

        //tester om begge to har blitt fjernet.
        assertEquals(searchTree.getNumberOfNodes(), 3);
        //tester om toyota har blitt fjernet fra datasettet.
        assertEquals(searchTree.getEntry(toyota), null);
        //tester om Porsche er i datasettet.
        assertEquals(searchTree.getEntry(porsche), "Porsche");

        searchTree.clear();
        assertTrue(searchTree.isEmpty());

    }
}