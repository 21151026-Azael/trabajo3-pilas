
package trabajo3.pilas;

import java.util.Stack;

public class Trabajo3Pilas {
public static void main(String[] args) {
        String[] expresiones = {
            "{[()]}", 
            "{[(])}", 
            "{{[[(())]]}}", 
            "[({})]", 
            "[(])"
        };

        for (String exp : expresiones) {
            if (sonBalanceados(exp)) {
                System.out.println("La expresión '" + exp + "' está balanceada.");
            } else {
                System.out.println("La expresión '" + exp + "' no está balanceada.");
            }
        }
    }

    public static boolean sonBalanceados(String expresion) {
        Stack<Character> pila = new Stack<>();

        char[] apertura = {'(', '[', '{'};
        char[] cierre = {')', ']', '}'};

        for (char charActual : expresion.toCharArray()) {
            
            if (esApertura(charActual, apertura)) {
                pila.push(charActual);
            } 

            else if (esCierre(charActual, cierre)) {
                
                if (pila.isEmpty() || !esParCorrespondiente(pila.pop(), charActual)) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    private static boolean esApertura(char c, char[] apertura) {
        for (char a : apertura) {
            if (c == a) {
                return true;
            }
        }
        return false;
    }

    private static boolean esCierre(char c, char[] cierre) {
        for (char b : cierre) {
            if (c == b) {
                return true;
            }
        }
        return false;
    }

    private static boolean esParCorrespondiente(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
    
}
