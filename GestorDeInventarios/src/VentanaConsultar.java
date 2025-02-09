import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.*;

import helper_classes.*;

public class VentanaConsultar {
  String ruta="";
  String nombre="GestorInventario.txt";
   String nombre2="GestorInventarioSalidas.txt";


  public  VentanaConsultar() {

    File archivo=new File(ruta+nombre);
    File archivo2=new File(ruta+nombre2);

     JFrame frame = new JFrame("Consultar Disponibilidad");
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setSize(469, 254);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));
     frame.setIconImage(new ImageIcon(frame.getClass().getResource("/helper_classes/resources/fonts/logo.png")).getImage());


     JButton Registrar = new JButton("Buscar MAP");
     Registrar.setBounds(180, 22, 106, 28);
     Registrar.setBackground(Color.decode("#2e2e2e"));
     Registrar.setForeground(Color.decode("#D9D9D9"));
     Registrar.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     Registrar.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     Registrar.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(Registrar, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(Registrar);

     JTextField element2 = new JTextField("");
     element2.setBounds(35, 100, 400, 21);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element2.setBackground(Color.decode("#B2B2B2"));
     element2.setForeground(Color.decode("#656565"));
     element2.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element2, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element2);

     frame.add(panel);
     frame.setVisible(true);

     //buscar en la base de datos
      Registrar.addActionListener((ActionEvent e) -> {
        String texto= ( element2.getText());
        if (archivo.exists()) {
          try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            boolean encontrado = false;
            while((linea = br.readLine()) != null){
              if(linea.equals(texto)){
                JOptionPane.showMessageDialog(null,"La MAP se encuentra en Inventario");
                encontrado = true;
                return;
              }
            }
            //buscar en la base de datos de salidas
            if (archivo2.exists()) {
              FileReader fr2 = new FileReader(archivo2);
              BufferedReader br2 = new BufferedReader(fr2);
              String linea2;
              while((linea2 = br2.readLine()) != null){
              if(linea2.equals(texto)){
                JOptionPane.showMessageDialog(null,"La MAP se encuentra en Salidas");
                encontrado = true;
                return;
              }
              }
            }

            if(!encontrado){
              JOptionPane.showMessageDialog(null,"MAP no encontrada!!!");
            }
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        } else{
          JOptionPane.showMessageDialog(null,"No hay elementos en la base de datos");
          
        }
  
        element2.setText("");
      });

  }
}
