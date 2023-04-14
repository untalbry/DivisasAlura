package controlador;

import modelo.Conversor;
import vista.VistaConversor;
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
        String valor = vistaConversor.getValorIngresado();
        if (conversor.validarNumero(valor)) {
            conversor.setValorIngresado(valor);
            vistaConversor.setValorIngresado(valor);
        } else {
            vistaConversor.mostrarMensaje("Ingrese un número válido");
        }
    }
}
