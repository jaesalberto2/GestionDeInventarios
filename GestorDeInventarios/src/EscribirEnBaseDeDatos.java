

/**
 * The EscribirEnBaseDeDatos class provides functionality to write data to a text file
 * that acts as a simple database. It checks if the data already exists in the file
 * before adding it, and appends a timestamp to each entry.
 * 
 * <p>This class uses the following libraries:
 * <ul>
 *   <li>javax.swing.JOptionPane for displaying messages to the user</li>
 *   <li>java.io.* for file operations</li>
 *   <li>java.sql.Date for handling date and time</li>
 *   <li>java.text.SimpleDateFormat for formatting date and time</li>
 * </ul>
 * </p>
 * 
 * <p>Usage example:
 * <pre>
 * {@code
 * EscribirEnBaseDeDatos escribir = new EscribirEnBaseDeDatos("item1");
 * }
 * </pre>
 * </p>
 * 
 * <p>Constructor:
 * <ul>
 *   <li>{@code EscribirEnBaseDeDatos(String in)}: Initializes the class with the input string
 *       and writes it to the file if it does not already exist.</li>
 * </ul>
 * </p>
 * 
 * @param in The string to be written to the file.
 */
import javax.swing.JOptionPane;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class EscribirEnBaseDeDatos {


    public EscribirEnBaseDeDatos(String in)  {
     String ruta="";
     String nombre="GestorInventario.txt";
     //detectar fecha
     Date todayDate = new Date(System.currentTimeMillis());
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
String fechaActual = sdf.format(todayDate);
     //String desc;


     File archivo=new File(ruta+nombre); 


        if (archivo.exists()) {
           try (FileReader fr = new FileReader(archivo)) {
            BufferedReader br=new BufferedReader(fr);
            
            BufferedWriter bw=new BufferedWriter(new FileWriter(archivo,true));


                //detectar si el elemento ya existe en la base de datos
                String linea;
                while((linea = br.readLine()) != null){
                    if(linea.contains(in)){
                        JOptionPane.showMessageDialog(null,"MAP ya existe en el inventario","Error",JOptionPane.ERROR_MESSAGE);
                        
                        return;
                        
                    }

                }
                bw.write("\n"+in+"                  Entrada:"+fechaActual);
                bw.flush();
                JOptionPane.showMessageDialog(null,"Se ha agregado el MAP al inventario", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                bw.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
        } else{
        try (FileWriter fw = new FileWriter(archivo)) {
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(in+"                   Entrada:"+fechaActual);
            bw.flush();
            bw.close();
            //System.out.println("¿Qué compraste?");
                //desc=sc.nextLine();
                //bw.write(""+desc);
                //bw.newLine();

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }




    }
}
