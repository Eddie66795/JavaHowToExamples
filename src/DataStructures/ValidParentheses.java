package DataStructures;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "";
        new ValidParentheses().isValid(input);
    }

    public final Character OPEN_P = '(';
    public final Character CLOSE_P = ')';

    public final Character OPEN_B = '{';
    public final Character CLOSE_B = '}';

    public final Character OPEN_BR = '[';
    public final Character CLOSE_BR = ']';

    public boolean isValid(String input) {
        if (input == null || input.length() == 0) {
            return false;
        } else if (input == "") {
            return true;
        } else if (input.length() % 2 != 0) {
            return false;
        } else if (isClosed(input.charAt(0))) {
            return false;
        }

        Stack<Character> temp = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            Character inputChar = input.charAt(i);
            if (isOpen(inputChar) || isClosed(inputChar)) {
                if (isOpen(inputChar)) {
                    temp.push(inputChar);
                } else {
                    Character popped = temp.pop();
                    if (popped != getOpposite(inputChar)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return temp.isEmpty();
    }

    public Character getOpposite(Character inputChar) {
        if (inputChar == CLOSE_P) {
            return OPEN_P;
        } else if (inputChar == CLOSE_B) {
            return OPEN_B;
        } else {
            return OPEN_BR;
        }
    }

    public boolean isOpen(Character input) {
        if (input == OPEN_B || input == OPEN_BR || input == OPEN_P) {
            return true;
        }
        return false;
    }

    public boolean isClosed(Character input) {
        if (input == CLOSE_B || input == CLOSE_BR || input == CLOSE_P) {
            return true;
        }
        return false;
    }
}
