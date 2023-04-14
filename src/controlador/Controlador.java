package controlador;

import modelo.Conversor;
import vista.VistaConversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Controlador implements ActionListener {
    private VistaConversor vistaConversor;
    private Conversor conversor;
    public Controlador(VistaConversor vistaConversor, Conversor conversor){
        this.vistaConversor = vistaConversor;
        this.conversor = conversor;
        this.vistaConversor.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String valor = vistaConversor.getValorIngresado((JTextField) source);
        Object sourceTo  = e.getSource();
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(valor);
        if (conversor.validarNumero(valor)) {
            conversor.setValorIngresado(Double.parseDouble(valor));
            if(source==vistaConversor.getTextField1()){
                conversor.setClave(vistaConversor.getDivisa1(), vistaConversor.getDivisa2());
            }else if(source == vistaConversor.getTextField2()){
                conversor.setClave(vistaConversor.getDivisa2(), vistaConversor.getDivisa1());
            }
            conversor.Convertir();
            String resultado = df.format(conversor.getResultado());
            vistaConversor.setValorIngresado(String.valueOf(resultado), (JTextField) source);
        } else {
            vistaConversor.mostrarMensaje("Ingrese un número válido");
        }
    }
}
