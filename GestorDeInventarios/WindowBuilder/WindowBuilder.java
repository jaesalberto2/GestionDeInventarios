import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(679, 367);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JButton registrar = new JButton("Registrar Entrada");
     registrar.setBounds(35, 34, 106, 57);
     registrar.setBackground(Color.decode("#2e2e2e"));
     registrar.setForeground(Color.decode("#D9D9D9"));
     registrar.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     registrar.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     registrar.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(registrar, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(registrar);

     JButton consulta = new JButton("Consultar Disponibilidad");
     consulta.setBounds(35, 100, 106, 57);
     consulta.setBackground(Color.decode("#2e2e2e"));
     consulta.setForeground(Color.decode("#D9D9D9"));
     consulta.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     consulta.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     consulta.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(consulta, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(consulta);

     JButton inventario = new JButton("Inventario");
     inventario.setBounds(35, 168, 106, 28);
     inventario.setBackground(Color.decode("#2e2e2e"));
     inventario.setForeground(Color.decode("#D9D9D9"));
     inventario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     inventario.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     inventario.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(inventario, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(inventario);

     JButton salida = new JButton("Registrar Salida");
     salida.setBounds(35, 206, 106, 57);
     salida.setBackground(Color.decode("#2e2e2e"));
     salida.setForeground(Color.decode("#D9D9D9"));
     salida.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     salida.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     salida.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(salida, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(salida);

     JTextArea element5 = new JTextArea("");
     element5.setBounds(177, 34, 460, 232);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element5.setBackground(Color.decode("#B2B2B2"));
     element5.setForeground(Color.decode("#656565"));
     element5.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element5, "Your long Input!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element5);

     frame.add(panel);
     frame.setVisible(true);

  }
}