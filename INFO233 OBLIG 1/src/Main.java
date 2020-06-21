import twostack.TwoStackArray;

public class Main {

    private static boolean tallogbokstaver = false; //operand
    private static boolean symboler = true; //operator

    private static TwoStackArray<String> twostack = new TwoStackArray<>();

    //leter etter symboler og returnerer tall avhengig av hvilke symboler man finner
    private static int getCharPresedens (char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    //checks if it is a tall or a bokstav
    private static boolean isItAnTallOrBokstaverMyGuy (char c) {
        if (Character.isAlphabetic(c) || Character.isDigit(c)) {
            return true;
        } else {
            return false;
        }
    }

    //checks for symbols
    private static boolean isItAnSymbolmyBoi (char c) {
        String symbolerSquad = "-+*/";
        for (int i = 0; i < symbolerSquad.length(); i++) {
            if (symbolerSquad.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

    //src: https://github.com/EwyBoy/twostack/blob/master/src/Main.java
    private static String infixToPrefix(String infix) {

        System.out.println("Infix: " + infix);

        for (int i = 0; i < infix.length(); i++) {

            System.out.println("Loop Count: " + i);

            char c = infix.charAt(i);
            System.out.println("Char: " + c);

            if (!isItAnSymbolmyBoi(c)) {

                System.out.println("TwoStack Push: " + tallogbokstaver + " | " + infix.charAt(i));
                twostack.push(tallogbokstaver, infix.charAt(i) + "");

            } else {

                System.out.println("TwoStack Peek: " + twostack.peek(symboler));


                System.out.println("Is Empty: " + twostack.isItEmpty(symboler));
                System.out.println("Char Presidents One: " + getCharPresedens(c));

                System.out.println("Char to peek at 0: " + twostack.peek(symboler).charAt(0));
                System.out.println("Char Presidents Two: " + getCharPresedens(twostack.peek(symboler).charAt(0)));

                try {
                    while (!twostack.isItEmpty(symboler) && getCharPresedens(c) <= getCharPresedens(twostack.peek(symboler).charAt(0))) {

                        String operand_one = twostack.pop(tallogbokstaver);
                        String operand_two = twostack.pop(tallogbokstaver);

                        String operator_one = twostack.pop(symboler);

                        String prefix = operator_one + operand_two + operand_one;
                        twostack.push(tallogbokstaver, prefix);

                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

                System.out.println("TwoStack push: " + symboler + " | " + String.valueOf(c));
                twostack.push(symboler, String.valueOf(c));
            }
        }

        while (!twostack.isItEmpty(symboler)) {

            System.out.println("Shuffle");

            String operand_one = twostack.pop(tallogbokstaver);
            String operand_two = twostack.pop(tallogbokstaver);

            String operator_one = twostack.pop(symboler);

            String prefix = operator_one + operand_two + operand_one;

            System.out.println("TwoStack push: " + tallogbokstaver + " | " + prefix);
            twostack.push(tallogbokstaver, prefix);
        }

        System.out.println("TwoStack: peek" + tallogbokstaver);
        return twostack.peek(tallogbokstaver);
    }

    public static void main(String[] args) {
        String infix = "a+b*c";
        System.out.println("Final result: " + infixToPrefix(infix));
    }

}






