package stackPractice;

import java.util.*;
import javax.swing.*;

public class Demo {

    public static void main(String[] args) {
        Stack<Double> mathData = new Stack();
        String mathExpression = JOptionPane.showInputDialog("Enter the postfix string: ");
        String thisToken = "";
        StringTokenizer tokens = new StringTokenizer(mathExpression);
        while (tokens.hasMoreTokens()) {
            thisToken = tokens.nextToken();
            double num1 = 0.0;
            double num2 = 0.0;
            if (thisToken.equals("+")) {
                num1 = mathData.pop();
                num2 = mathData.pop();
                mathData.push(num2 + num1);
            } else if (thisToken.equals("-")) {
                num1 = mathData.pop();
                num2 = mathData.pop();
                mathData.push(num2 - num1);
            } else if (thisToken.equals("*")) {
                num1 = mathData.pop();
                num2 = mathData.pop();
                mathData.push(num2 * num1);
            } else if (thisToken.equals("/")) {
                num1 = mathData.pop();
                num2 = mathData.pop();
                mathData.push(num2 / num1);
            } else {
                mathData.push(Double.parseDouble(thisToken));
            }
        }
        JOptionPane.showMessageDialog(null, "The expression is equal to: " + String.format("%.2f", mathData.pop()));
    }

}
