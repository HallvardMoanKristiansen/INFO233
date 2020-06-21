import java.util.ArrayList;

public class Main {

    private static EpicHeapsorter epicHeapSorter = new EpicHeapsorter();

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(3);
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(6);
        list.add(18);
        list.add(14);
        list.add(0);

        //printer usortert liste
        System.out.println(list);

        //lager en ny arraylist for sortedlist
        ArrayList<Integer> sortedlist = epicHeapSorter.epicHeapsort(list);

        //printer sortert liste
        System.out.println(sortedlist);




    }
}
