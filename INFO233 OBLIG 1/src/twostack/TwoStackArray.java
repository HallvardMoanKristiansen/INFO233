package twostack;

import exceptions.TwostackEmptyException;
import exceptions.TwostackFullException;

public class TwoStackArray<E> implements TwoStack.Twostack<E> {

    private E twostack[];

    public E[] getTwostack() {
        return twostack;
    }

    //setter default verdi til maxSize som 100.
    //setter standardverdi til leftArraySize på 0, for den er på venstre i arrayet
    //setter maxverdi på rightArraySize 100
    public TwoStackArray() {
        this.twostack = (E[]) new Object[101];
        leftArraySize = 0;
        rightArraySize = twostack.length;
    }

    //lager constrcutur for klaasen med argument
    //setter verdi til ønsket verdi, om ingen verdi er oppgitt, henter den "deafult" = 100.
    public TwoStackArray(int tallInn) {
        this.twostack = (E[]) new Object[tallInn+1];
        leftArraySize = 0;
        rightArraySize = twostack.length;
    }

    //definerer max size value på venstresiden
    private int leftArraySize;

    //definerer max size value på høyresiden. om tall er oppgitt over, vil den hente ut tallet, om ikke vil den hente ut 100.
    private int rightArraySize;

    public boolean isItEmpty(Boolean right) {

        //Hvis høyre side
        if (right) {

            if (rightArraySize == twostack.length) {
                return true;
            }
            else {
                return false;
            }
        }
        //Hvis venstre siden
        else {

            if (leftArraySize == 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * Retunerer hvor mange elementer angitt stabel inneholder.
     *
     * @param right sann hvis høyre stabel og usann hvis venstre stabel
     * @return Størrelsen
     */
    @Override
    public Integer size(Boolean right) {
        //henter størrelsen til twostack
        if (right) {
            return twostack.length - rightArraySize;
        } else {
            return leftArraySize;
        }
    }

    //got this code from Eivind Nordling in the same lab, used to define


    /**
     * Legger et element i angitt stabel.
     *
     * @param right   sann hvis høyre stabel og usann hvis venstre stabel
     * @param element Elementet som skal stables.
     * @throws TwostackFullException når det ikke er plass til elementet.
     */
    @Override
    public void push(Boolean right, E element) throws TwostackFullException {
        //src https://github.com/EwyBoy/Twostack/blob/master/src/
        //bruker dette for å sjekke at en variabel kommer inn i arrayet og ikke null. (null pointers vil kreasje programmet)
        //all kode skal inn i element
        if (right) {
            if (rightArraySize - leftArraySize > 1) {
                twostack[--rightArraySize] = element;
            } else {
                throw new TwostackFullException();
            }
            } else {
                if (rightArraySize - leftArraySize > 1) {
                        twostack[++leftArraySize] = element;
              } else {
                throw new TwostackFullException();
            }
        }
    }

    /**
     * Stabler av topp-elementet av angitt stabel og returnerer det.
     *
     * @param right sann hvis høyre stabel og usann hvis venstre stabel
     * @return Topp-elementet i samlingen.
     * @throws TwostackEmptyException hvis stabelen er tom
     */
    @Override
    public E pop(Boolean right) throws TwostackEmptyException {
        //src https://github.com/EwyBoy/Twostack/blob/master/src/
        //setter right til å være true, og left til å være false.
        //returnerer toppelement og thrower twostackEmptyException om stabelen er otm.
        E topElement;
        if (right) {
            if (rightArraySize < twostack.length) {
                topElement = peek(true);
                twostack[rightArraySize] = null;
                rightArraySize++;
                return topElement;
            } else {
                throw new TwostackEmptyException();
            }
        } else {
            if (leftArraySize > 0) {
                topElement = peek(false);
                twostack[leftArraySize] = null;
                leftArraySize--;
                return topElement;
            } else {
                throw new TwostackEmptyException();
            }
        }
    }


    /**
     * Retunerer topp-elementet av angitt stabel, men fjerner det ikke.
     *
     * @param right sann hvis høyre stabel og usann hvis venstre stabel
     * @return Det første elementet i samlingen.
     * @throws TwostackEmptyException hvis samlingen er tom.
     */
    @Override
    public E peek(Boolean right) throws TwostackEmptyException {
        //src https://github.com/EwyBoy/Twostack/blob/master/src/
        //rightarraysize passer på top-elementet av angitt stabel men fjerner det ikke
        //henter stabel og sjekker hva som er på toppen av stabelen til right - rightarraysize
        //henter stabel og sjekker hva som er på toppen av stabelen til venstre - leftarraysize
        //kaster ny TwoStckEmptyException om samlingen er tom

        if (rightArraySize == twostack.length) {
            rightArraySize--;
        }

        if (leftArraySize == 0) {
            leftArraySize++;
        }

        try {
            if (right) {
                if (rightArraySize < twostack.length) {
                    System.out.println(twostack[rightArraySize]);
                    return twostack[rightArraySize];
                } else {
                    throw new TwostackFullException();
                }
            } else {
                if (leftArraySize > 0) {
                    System.out.println(twostack[leftArraySize]);
                    return twostack[leftArraySize];
                } else {
                    throw new TwostackEmptyException();
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("Ingenting skjedde her ass");

        return null;
    }

    /**
     * Sjekker om et element er i samlingen.
     *
     * @param element Elementet som kanskje er i samlingen.
     * @return retunerer true hvis elementet er i samlingen.
     */
    @Override
    public Boolean contains(E element) {
        // sjekker etter found item, søker gjennom hele stabelen og øker med 1 (++)
        //om den finner foundItem i element vil den break'e og returnere found item.
        boolean foundItem = false;

        for (int i = 0; i < twostack.length; i++) {
            if (twostack[i] == element) {
                foundItem = true;
                break;
            }
        }
        return foundItem;
    }

    /**
     * Fjerner alle elementene fra samlingen.
     */
    @Override
    public void clear() {
        //går gjennom alle elementene i arrayet og fjerner dem.
        rightArraySize = twostack.length;
        leftArraySize = 0;
        for (int i = 0; i <= twostack.length; i++) {
            twostack[i] = null;
        }
    }

    /**
     * Retunerer en tabell med alle elementene i samlingen.
     *
     * @param a@return En tabell med alle elementene i samlingen.
     */

    //denne funksjonen får jeg ikke til, den gir ingen mening for meg, derfor vil jeg ikke gjøre den.
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

}
