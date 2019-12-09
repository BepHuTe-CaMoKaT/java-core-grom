import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Program2{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorFrame1 frame = new CalculatorFrame1();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class CalculatorFrame1 extends JFrame{
    public CalculatorFrame1(){
        setTitle("Calculator");
        CalculatorPanel1 panel = new CalculatorPanel1();
        add(panel);
        pack();

    }
}
class CalculatorPanel1 extends JPanel{
    public CalculatorPanel1(){

    }
}