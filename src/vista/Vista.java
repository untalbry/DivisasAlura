package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Vista extends  JFrame{
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JLabel ErrorText;

    public Vista(String title){
        super(title);

        ImageIcon icono = new ImageIcon("src/vista/img/monedas.png");
        this.setIconImage(icono.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(450, 300);
    }
    public void setValorIngresado(String valor, JTextField textField) {
        textField.setText(valor);
    }
    public String getValorIngresado(JTextField textField) {
        return textField.getText();
    }
    public String getDivisa1(){
        return (String) this.comboBox1.getSelectedItem();
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

    public void mostrarMensaje() {
        ErrorText.setText("Ingresa un número");
    }
}
