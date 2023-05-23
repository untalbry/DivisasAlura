package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VistaConversor extends JFrame{
    //Creación de componentes
    private final JTextField textField1;
    private final JTextField textField2;
    private final JComboBox<String> comboBox;
    private final JComboBox<String> comboBox2;
    //Valores para los ComboBox, Aqui puedes añadir mas en un futuro
    String[] Divisas = { "MXN", "USD", "EUR" };

    public VistaConversor(){
        ImageIcon icono = new ImageIcon("src/vista/img/monedas.png");
        this.setIconImage(icono.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
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
        textField.setText(valor);
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
