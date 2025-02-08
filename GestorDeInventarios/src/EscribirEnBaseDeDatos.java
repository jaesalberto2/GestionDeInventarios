
import java.util.*;
import java.io.*;


public class EscribirEnBaseDeDatos {


    public EscribirEnBaseDeDatos(String in)  {
     String ruta="C:/Users/ALBERTO/Documents/herramientas/gestorInventarios/";
     String nombre="GestorInventario.txt";
     //String desc;

     File archivo=new File(ruta+nombre); 


        if (archivo.exists()) {
           try (FileReader fr = new FileReader(archivo)) {
            BufferedReader br=new BufferedReader(fr);
            BufferedWriter bw=new BufferedWriter(new FileWriter(archivo,true));
                bw.write("\n"+in);
                bw.flush();
                
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
        } else{
        try (FileWriter fw = new FileWriter(archivo)) {
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(in);
            bw.flush();
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
