package controlador;
import modelo.Conversor;
import vista.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

//Implementamos la interfaz Action Listener y sobre escribimos su único método
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Controlador implements ActionListener {
    private final Vista vista;
    private final Conversor conversor;
    private final DecimalFormat df;

    public Controlador(Vista vista, Conversor conversor) {
        this.vista = vista;
        this.conversor = conversor;
        this.vista.addActionListener(this);
        //Set decimal separator to a dot
        DecimalFormatSymbols otherSymbols = DecimalFormatSymbols.getInstance(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        df = new DecimalFormat("###.###", otherSymbols); // Formato para colocar los valores obtenidos
    }

    /**
     * Función donde obtenemos una ActionEvent
     * 
     * @param e
     *          Y obtenemos su origen,
    **/
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JTextField sourceTo = (source == vista.getTextField1()) ? vista.getTextField2(): vista.getTextField1();
        String valor = vista.getValorIngresado((JTextField) source);
        // Si el valor ingresado es un número entonces pasamos al converson el número
        if (conversor.isNumber(valor)) {
            conversor.setValorIngresado(Double.parseDouble(valor));

            String claveSource = (source == vista.getTextField1()) ? vista.getDivisa1(): vista.getDivisa2();
            String claveSourceTo = (source == vista.getTextField1()) ? vista.getDivisa2() : vista.getDivisa1();

            conversor.setClave(claveSource, claveSourceTo);
            conversor.Convertir();

            String resultado = df.format(conversor.getResultado()); // Casteamos a String el resultado y con formato

            vista.setValorIngresado(resultado, sourceTo); // Pasamos el valor al JTexfield
                                                                                // correspondiente
        } else {
            // Pasamos el mensaje a un JOptionPane
            vista.setValorIngresado("", (JTextField) source);
            vista.setValorIngresado("", sourceTo);
            vista.mostrarMensaje();
        }
    }
}
