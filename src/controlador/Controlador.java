package controlador;

import modelo.Conversor;
import vista.VistaConversor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
//Implementamos la interfaz Action Listener y sobre escribimos su único método

public class Controlador implements ActionListener {
    private VistaConversor vistaConversor;
    private Conversor conversor;
    public Controlador(VistaConversor vistaConversor, Conversor conversor){
        this.vistaConversor = vistaConversor;
        this.conversor = conversor;
        this.vistaConversor.addActionListener(this);
    }

    /**
     * Función donde obtenemos una ActionEvent
     * @param e
     * Y obtenemos su origen,
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Object sourceTo  = e.getSource();
        String valor = vistaConversor.getValorIngresado((JTextField) source);
        DecimalFormat df = new DecimalFormat("#.###"); //Formato para colocar los valores obtenidos
        //System.out.println(valor);
        //Si el valor ingresado es un número entonces pasamos al converson el número
        if (conversor.isNumber(valor)) {
            conversor.setValorIngresado(Double.parseDouble(valor));
            //Y si la fuente de la Action es el TextField 1 seteamos la clave ComboBox1-Combobox2
            if(source==vistaConversor.getTextField1()){
                conversor.setClave(vistaConversor.getDivisa1(), vistaConversor.getDivisa2());
                sourceTo = vistaConversor.getTextField2();
                //Caso contrario si la funte es TextField2 setteamos la clave ComboBox2-Combobox1
            }else if(source == vistaConversor.getTextField2()){
                conversor.setClave(vistaConversor.getDivisa2(), vistaConversor.getDivisa1());
                sourceTo = vistaConversor.getTextField1();
            }
            //Realizamos conversion
            conversor.Convertir();
            String resultado = df.format(conversor.getResultado()); //Casteamos a String el resultado y con formato
            vistaConversor.setValorIngresado(resultado, (JTextField) sourceTo); // Pasamos el valor al JTexfield correspondiente
        } else {
            //Pasamos el mensaje a un JOptionPane
            vistaConversor.mostrarMensaje("Ingrese un número válido");
        }
    }
}
