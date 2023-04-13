package controlador;

import modelo.Conversor;
import vista.VistaConversor;

public class Controlador {
    private VistaConversor vistaConversor;
    private Conversor conversor;
    public Controlador(VistaConversor vistaConversor, Conversor conversor){
        this.vistaConversor = vistaConversor;
        this.conversor = conversor;
    }

}
