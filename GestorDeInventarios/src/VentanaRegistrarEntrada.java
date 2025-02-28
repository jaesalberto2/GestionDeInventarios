import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import helper_classes.*;

public class VentanaRegistrarEntrada {
 String texto = "";

  /**
   * VentanaRegistrarEntrada is a class that creates a GUI window for registering material entries.
   * The window contains a text field for input and a button to submit the entry.
   * The input is processed and written to a database upon clicking the button or pressing the Enter key.
   * 
   * Components:
   * - JFrame: The main window frame.
   * - JPanel: The panel that holds all the components.
   * - JTextField: A text field for user input.
   * - JButton: A button to submit the input.
   * 
   * Features:
   * - Custom fonts and colors for UI components.
   * - Rounded borders for text field and button.
   * - Focus and click event handling for better user experience.
   * - Action listener for the button to handle input submission.
   * - Key listener for the text field to handle Enter key press for input submission.
   * 
   * Usage:
   * Create an instance of VentanaRegistrarEntrada to display the window.
   * The input text will be written to the database when the button is clicked or Enter key is pressed.
   */
  public  VentanaRegistrarEntrada() {

    


     JFrame frame = new JFrame("Registrar Entrada de Material");
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setSize(469, 254);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));
     frame.setIconImage(new ImageIcon(frame.getClass().getResource("/helper_classes/resources/fonts/logo.png")).getImage());


     JTextField element2 = new JTextField("");
     element2.setBounds(35, 100, 400, 21);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element2.setBackground(Color.decode("#B2B2B2"));
     element2.setForeground(Color.decode("#656565"));
     element2.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element2, "", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element2);

     JButton Registrar = new JButton("Registrar MAP");
     Registrar.setBounds(180, 22, 106, 28);
     Registrar.setBackground(Color.decode("#2e2e2e"));
     Registrar.setForeground(Color.decode("#D9D9D9"));
     Registrar.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     Registrar.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     Registrar.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(Registrar, Color.decode("#232323"), Color.decode("#2e2e2e"));
    Registrar.requestFocusInWindow();
     panel.add(Registrar);

     Registrar.addActionListener((ActionEvent e) -> {
      texto= ( element2.getText());
      EscribirEnBaseDeDatos escribir = new EscribirEnBaseDeDatos(texto);
      
      element2.setText("");
 
    });
    

     frame.add(panel);
    


   
         
     frame.setVisible(true);

     //detectar enter para registrar
      element2.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
  
        @Override
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            texto= ( element2.getText());
            EscribirEnBaseDeDatos escribir = new EscribirEnBaseDeDatos(texto);
            element2.setText("");
          }
        }
  
        @Override
        public void keyReleased(KeyEvent e) {
        }
      });


  }

  //keylistener enter


  //getters and setters
  public String getTexto() {
    return texto;
  }

}
