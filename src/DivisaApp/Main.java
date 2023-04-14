package DivisaApp;
import controlador.Controlador;
import modelo.Conversor;
import vista.VistaConversor;
public class Main {
    public static void main(String[] args) {
        Conversor modelo = new Conversor();
        VistaConversor vista = new VistaConversor();
        Controlador controlador = new Controlador(vista,modelo);
        vista.setVisible(true);

    }
}
