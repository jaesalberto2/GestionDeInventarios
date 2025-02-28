
/**
 * The EscribirEnBaseDeDatosSalida class is responsible for writing inventory exit data to a text file.
 * It appends the provided input string along with the current date and time to the file "GestorInventarioSalidas.txt".
 * If the file does not exist, it creates a new one.
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * EscribirEnBaseDeDatosSalida escribir = new EscribirEnBaseDeDatosSalida("Item description");
 * }
 * </pre>
 * 
 * @param in The input string to be written to the file, representing the inventory item description.
 * 
 * @throws NumberFormatException If an error occurs while parsing numbers.
 * @throws IOException If an I/O error occurs while reading from or writing to the file.
 */
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javafx.scene.paint.Material;


public class EscribirEnBaseDeDatosSalida {


    public EscribirEnBaseDeDatosSalida(String in)  {
     String ruta="";
     String nombre="GestorInventarioSalidas.txt";

     


     Date todayDate = new Date(System.currentTimeMillis());
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
String fechaActual = sdf.format(todayDate);
     //String desc;



     File archivo=new File(ruta+nombre); 


        if (archivo.exists()) {
           try (FileReader fr = new FileReader(archivo)) {
            BufferedReader br=new BufferedReader(fr);
            BufferedWriter bw=new BufferedWriter(new FileWriter(archivo,true));
            //revisar que no este vacio
            if (in != null) {
                bw.write("\n"+in+"                  Salida:"+fechaActual);
                bw.flush();
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
        } else{
        try (FileWriter fw = new FileWriter(archivo)) {
            BufferedWriter bw=new BufferedWriter(fw);
            //revisar que no este vacio
            if (in != null) {
                bw.write("\n"+in+"                  Salida:"+fechaActual);
                bw.flush();
                bw.close();
                
            }
         
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
