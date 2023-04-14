package controlador;

import modelo.Conversor;
import vista.VistaConversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        System.out.println(valor);
        if (conversor.validarNumero(valor)) {
            conversor.setValorIngresado(valor);
            vistaConversor.setValorIngresado(valor, (JTextField) source);
        } else {
            vistaConversor.mostrarMensaje("Ingrese un número válido");
        }
    }
}
