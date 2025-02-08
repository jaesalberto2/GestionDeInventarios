import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import helper_classes.*;
import java.awt.event.ActionEvent;


public class VentanaPrincipal {
  private JScrollPane scroll;
  private JTextField inventario;
  private DefaultListModel<String> modeloLista = new DefaultListModel<String>();
  private JList<String> lista;
    private JTable tabla;
    private DefaultTableModel modelo; 
    private String[] columnas = {"ID", "Nombre", "Cantidad", "Precio", "Descripción"};
    

  public VentanaPrincipal(String[] args) {

    

     JFrame frame = new JFrame("Gestor de Inventarios PTS");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1200, 1100);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));


     lista = new JList<String>(modeloLista);

      scroll = new JScrollPane(lista);
      scroll.setBounds(177, 34, 1150, 650);
      scroll.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
      scroll.setBackground(Color.decode("#B2B2B2"));
      scroll.setForeground(Color.decode("#656565"));
      scroll.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));

     panel.add(scroll);


     JButton registrar = new JButton("Registrar\n Entrada");
     registrar.setBounds(10, 34, 160, 57);
     registrar.setBackground(Color.decode("#2e2e2e"));
     registrar.setForeground(Color.decode("#D9D9D9"));
     registrar.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     registrar.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     registrar.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(registrar, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(registrar);
     registrar.addActionListener((ActionEvent e) -> {
      @SuppressWarnings("unused")
      VentanaRegistrarEntrada registro = new VentanaRegistrarEntrada();
      
      modeloLista.addElement(registro.getTexto());
    });



     JButton consulta = new JButton("Consultar\n Disponibilidad");
     consulta.setBounds(10, 100, 160, 57);
     consulta.setBackground(Color.decode("#2e2e2e"));
     consulta.setForeground(Color.decode("#D9D9D9"));
     consulta.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     consulta.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     consulta.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(consulta, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(consulta);
      consulta.addActionListener((ActionEvent e) -> {
        @SuppressWarnings("unused")
        VentanaConsultar consulta1 = new VentanaConsultar();
      });

     


     JButton inventario = new JButton("Inventario");
     inventario.setBounds(10, 168, 160, 28);
     inventario.setBackground(Color.decode("#2e2e2e"));
     inventario.setForeground(Color.decode("#D9D9D9"));
     inventario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     inventario.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     inventario.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(inventario, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(inventario);




     JButton salida = new JButton("Registrar\n Salida");
     salida.setBounds(10, 206, 160, 57);
     salida.setBackground(Color.decode("#2e2e2e"));
     salida.setForeground(Color.decode("#D9D9D9"));
     salida.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     salida.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     salida.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(salida, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(salida);

      salida.addActionListener((ActionEvent e) -> {
        @SuppressWarnings("unused")
        VentanaSalida salida1 = new VentanaSalida();
      });



    


     frame.add(panel);
     frame.setVisible(true);
     

 
      


  }


}