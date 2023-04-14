package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaConversor extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    public VistaConversor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(); // Cambio de layout a GridLayout

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100,25));
        panel.add(textField1);

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100,25));
        panel.add(textField2);

        this.add(panel, BorderLayout.CENTER);
    }
    public void setValorIngresado(String valor) {
        textField2.setText(valor);
    }
    public String getValorIngresado() {
        return textField1.getText();
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
