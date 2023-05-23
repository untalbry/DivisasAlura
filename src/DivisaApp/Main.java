/**
 * @Autor : Bryan Castro Sánchez
 * @Version: 1.0.0
 * Descripción: Conversor de divisas, proyecto hecho para el curso Next Education
 *
 */
package DivisaApp;
import controlador.Controlador;
import modelo.Conversor;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        Conversor modelo = new Conversor();
        Vista vista = new Vista("Divisas");
        Controlador controlador = new Controlador(vista,modelo);
        vista.setVisible(true);
    }
}
