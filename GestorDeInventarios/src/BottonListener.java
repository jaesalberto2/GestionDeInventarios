import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottonListener {

    //eventos de boton abrir ventana registrar entrada
    class EventosBotonRegistrarEntrada implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaRegistrarEntrada ventana = new VentanaRegistrarEntrada();
        }
    }
   
}
