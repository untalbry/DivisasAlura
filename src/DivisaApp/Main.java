package DivisaApp;
import controlador.Controlador;
import modelo.Conversor;
import vista.VistaConversor;
public class Main {
    public static void main(String[] args) {
        Conversor model = new Conversor();
        VistaConversor view = new VistaConversor();
        Controlador controller = new Controlador();

        //controller.start();

    }
}
