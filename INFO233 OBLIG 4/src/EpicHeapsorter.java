import no.uib.info233.heap.MaxHeap;

import java.util.ArrayList;

//Fått lit hjelp av Eivind til å få min epic heap sorter til å fungere, referer til githuben hans som src, for hjelpen med heapsorter. https://github.com/EwyBoy/INFO-233-Oblig-04/blob/master/Oblig04/src/HeapSort.java
//heapsorten er O(n) når man kjører en kjøretidsanalyse, ettersom den kun kaller på seg selv. Altså den er rekusiv
public class EpicHeapsorter implements MaxHeap {

    public ArrayList<Integer> epicHeapsort(ArrayList<Integer> epicUnsortedList) {

        int list = epicUnsortedList.size();

        for ( int i = list / 2 - 1; i >= 0; i-- ) {

            heapinator(epicUnsortedList, list, i);

        }

        for (int i = list - 1; i > 0; i--) {

            int temporary = epicUnsortedList.get(0);

            epicUnsortedList.set(0, epicUnsortedList.get(i));

            epicUnsortedList.set(i, temporary);

            heapinator(epicUnsortedList, i, 0);
        }

        return epicUnsortedList;
    }

    private void heapinator(ArrayList<Integer> arrayList, int n, int i) {

        int largest = i;

        int left = 2*i + 1;

        int right = 2*i + 2;

        if (left < n && arrayList.get(left) > arrayList.get(largest))

            largest = left;

        if (right < n && arrayList.get(right) > arrayList.get(largest))

            largest = right;

        if (largest != i) {

            int swap = arrayList.get(i);

            arrayList.set(i, arrayList.get(largest));

            arrayList.set(largest, swap);

            heapinator(arrayList, n, largest);
        }
    }


    /**
         * Adds a new entry to this heap.
         *
         * @param entry An object to be added.
         */
        @Override
        public void add(Comparable entry) {

        }

        /**
         * Removes and returns the largest item in this heap.
         *
         * @return Either the largest object in the heap or, if the heap is empty before
         * the operation, null.
         */
        @Override
        public Comparable removeMax() {
            return null;
        }

        /**
         * Retrieves the largest item in this heap.
         *
         * @return Either the largest object in the heap or, if the heap is empty, null.
         */
        @Override
        public Comparable getMax() {
            return null;
        }

        /**
         * Detects whether this heap is empty.
         *
         * @return True if the heap is empty, or false otherwise.
         */
        @Override
        public Boolean isEmpty() {
            return null;
        }

        /**
         * Gets the size of this heap.
         *
         * @return The number of entries currently in the heap.
         */
        @Override
        public Integer getSize() {
            return null;
        }

        /**
         * Removes all entries from this heap.
         */
        @Override
        public void clear() {

        }
    }
