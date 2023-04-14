package vista;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaConversor extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox2;
    String[] Divisas = { "MXN", "USD", "EUR" };

    public VistaConversor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(); // Cambio de layout a GridLayout
        comboBox = new JComboBox<>(Divisas);
        panel.add(comboBox);
        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100,25));
        panel.add(textField1);

        comboBox2 = new JComboBox<>(Divisas);
        panel.add(comboBox2);
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100,25));
        panel.add(textField2);




        this.add(panel, BorderLayout.CENTER);
    }
    public void setValorIngresado(String valor, JTextField textField) {
        if(textField == textField1){
            textField2.setText(valor);
        }else if(textField == textField2){
            textField1.setText(valor);
        }
    }
    public String getValorIngresado(JTextField textField) {
        return textField.getText();
    }
    public String getDivisa1(){
        return (String) this.comboBox.getSelectedItem();
    }
    public String getDivisa2(){
        return (String) this.comboBox2.getSelectedItem();
    }


    public JTextField getTextField1() {
        return textField1;
    }
    public JTextField getTextField2() {
        return textField2;
    }

    //Listener de los textfield
    public void addActionListener(ActionListener listener) {
        textField1.addActionListener(listener);
        textField2.addActionListener(listener);
    }
    //Mensaje emergente en caso de no colocar un numero
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
