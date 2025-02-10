import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import helper_classes.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
//creamos un modelo de lista para la lista de inventario global



public class VentanaPrincipal {
  public static DefaultListModel<String> modeloLista = new DefaultListModel<String>();
  public static DefaultListModel<String> modeloListaSalidas = new DefaultListModel<String>();

  private JScrollPane scroll;
  private JList<String> lista;
    private DefaultTableModel modelo; 

     String ruta="";
     String nombre="GestorInventario.txt";
      String nombre2="GestorInventarioSalidas.txt";
      //textarea
      

     //String desc;



    

  public VentanaPrincipal(String[] args) {

    

     JFrame frame = new JFrame("Gestor de Inventarios PTS");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1200, 1100);
     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
     frame.setIconImage(new ImageIcon(frame.getClass().getResource("/helper_classes/resources/fonts/logo.png")).getImage());

     
     
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));
     //logo de la ventana
     

      //titulo de la tabla de inventario
      JLabel tituloInventario = new JLabel("Inventario");
      tituloInventario.setBounds(177, 10, 575, 20);
      tituloInventario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
      tituloInventario.setForeground(Color.decode("#D9D9D9"));
      panel.add(tituloInventario);

//Inventario scroll de inventario
     lista = new JList<String>(modeloLista);

      scroll = new JScrollPane(lista);
      scroll.setBounds(177, 34, 575, 650);
      scroll.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     File archivo=new File(ruta+nombre); 
         try (FileReader fr = new FileReader(archivo);
              BufferedReader br = new BufferedReader(fr);
              BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                

            String line;
            while((line = br.readLine()) != null){
                modeloLista.addElement(line);
            }
         } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      scroll.setForeground(Color.decode("#656565"));
      scroll.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));

     panel.add(scroll);


//titulo de la tabla de salidas
      JLabel tituloSalidas = new JLabel("Salidas");
      tituloSalidas.setBounds(770, 10, 575, 20);
      tituloSalidas.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
      tituloSalidas.setForeground(Color.decode("#D9D9D9"));
      panel.add(tituloSalidas);
         //Salidas scroll de salidas
          JList<String> listaSalidas = new JList<String>(modeloListaSalidas);

      JScrollPane scrollSalidas = new JScrollPane(listaSalidas);
      scrollSalidas.setBounds(770, 34, 575, 650);
      scrollSalidas.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
      File archivo2=new File(ruta+nombre2); 
          try (FileReader fr = new FileReader(archivo2);
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo2, true))) {
  
              String line;
              while((line = br.readLine()) != null){
                  modeloListaSalidas.addElement(line);
              }
          } catch (NumberFormatException | IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }

      scrollSalidas.setForeground(Color.decode("#656565"));
      scrollSalidas.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));

      panel.add(scrollSalidas);

      


        





//Boton Registrar Entrada
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
      

      
    });


    //Boton Consultar Disponibilidad

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

     
//Boton Actualizar

     JButton actualizar = new JButton("Actualizar");
     actualizar.setBounds(10, 168, 160, 28);
     actualizar.setBackground(Color.decode("#2e2e2e"));
     actualizar.setForeground(Color.decode("#D9D9D9"));
     actualizar.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     actualizar.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     actualizar.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(actualizar, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(actualizar);
      actualizar.addActionListener((ActionEvent e) -> {
          modeloLista.clear();
          try (FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
  
              String line;
              while((line = br.readLine()) != null){
                  modeloLista.addElement(line);
              }
          } catch (NumberFormatException | IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
          }

          modeloListaSalidas.clear();
          try (FileReader fr = new FileReader(archivo2);
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo2, true))) {
  
              String line;
              while((line = br.readLine()) != null){
                  modeloListaSalidas.addElement(line);
              }
          } catch (NumberFormatException | IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
          }
        });


//Boton Registrar Salida

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

        //agregar a base de datos de salidas
        EscribirEnBaseDeDatosSalida escribir2 = new EscribirEnBaseDeDatosSalida(lista.getSelectedValue());

        EliminarDeBaseDeDatos eliminar = new EliminarDeBaseDeDatos(lista.getSelectedValue());

        modeloLista.removeElementAt(lista.getSelectedIndex());
        //VentanaSalida salida1 = new VentanaSalida();
        

      });

      



    


     frame.add(panel);
     frame.setVisible(true);
     

 
      


  }


}