package com.Lucky.lucky.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//CREDIT Java Code Geeks for some of the help


//Jbuttons, JPanel and JTextField created using the GUI.
public class Calculator {
    private JTextField resultsTxt;
    private JButton clearBtn;
    private JButton signBtn;
    private JButton percentBtn;
    private JButton divideBtn;
    private JButton numSeven;
    private JButton numFour;
    private JButton numEight;
    private JButton numNine;
    private JButton multiplyBtn;
    private JButton numOne;
    private JButton numFive;
    private JButton numSix;
    private JButton subBtn;
    private JButton numZero;
    private JButton numTwo;
    private JButton numThree;
    private JButton addBtn;
    private JButton decBtn;
    private JButton equalBtn;
    private JPanel calculatorView;
    private Double leftOperand;
    private Double rightOperand;
    private Operation calcOperation;

    public Calculator() {
    //Adding actions when buttons are clicked.
        numSeven.addActionListener(new NumberBtnClicked(numSeven.getText()));
        numEight.addActionListener(new NumberBtnClicked(numEight.getText()));
        numNine.addActionListener(new NumberBtnClicked(numNine.getText()));
        numFour.addActionListener(new NumberBtnClicked(numFour.getText()));
        numFive.addActionListener(new NumberBtnClicked(numFive.getText()));
        numSix.addActionListener(new NumberBtnClicked(numSix.getText()));
        numOne.addActionListener(new NumberBtnClicked(numOne.getText()));
        numTwo.addActionListener(new NumberBtnClicked(numTwo.getText()));
        numThree.addActionListener(new NumberBtnClicked(numThree.getText()));
        numZero.addActionListener(new NumberBtnClicked(numZero.getText()));
        percentBtn.addActionListener(new OperationBtnClicked(Operation.PERCENTAGE));
        multiplyBtn.addActionListener(new OperationBtnClicked(Operation.MULTIPLICATION));
        divideBtn.addActionListener(new OperationBtnClicked(Operation.DIVISION));
        subBtn.addActionListener(new OperationBtnClicked(Operation.SUBTRACTION));
        addBtn.addActionListener(new OperationBtnClicked(Operation.ADDITION));
        equalBtn.addActionListener(new EqualBtnClicked());
        clearBtn.addActionListener(new ClearBtnClicked());
        signBtn.addActionListener(new SignBtnClicked());
        decBtn.addActionListener(new decBtnClicked());

    }//When number button clicked it implements the value.
    private class NumberBtnClicked implements ActionListener {
        private String value;
        public NumberBtnClicked(String value) {
            this.value = value;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(leftOperand == null || leftOperand == 0.0) {
                value = resultsTxt.getText() + value;
            }else{
                rightOperand = Double.valueOf(value);
            }
            resultsTxt.setText(value);
        }
    }//Calculator Addition, Subtraction, Multiply, Division, Percent buttons clicked
    private class OperationBtnClicked implements ActionListener {

        private Operation operation;
        public OperationBtnClicked(Operation operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            calcOperation = operation;
            leftOperand = Double.valueOf(resultsTxt.getText());
        }
    }//Clear the calculator
    private class ClearBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTxt.setText("");
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }//Decimal button clicked
    private class decBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTxt.setText(resultsTxt.getText() + ".");
        }
    }//Equal button clicked
    private class EqualBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double output = calcOperation.getOperator().applyAsDouble(leftOperand, rightOperand);
            resultsTxt.setText(output%1==0?String.valueOf(output.intValue()):String.valueOf(output));
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }//+/- button clicked
    private class SignBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTxt.setText("-"+ resultsTxt.getText());
        }
    }
    //This is what makes the Calculator form functional
    // requires a runtime frame
    // responsible for creating and disposing the runtime frame.
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculatorView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
