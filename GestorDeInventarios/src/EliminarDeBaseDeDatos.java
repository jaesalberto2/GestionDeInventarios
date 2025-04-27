import java.io.*;

public class EliminarDeBaseDeDatos {
    /**
     * This class provides functionality to remove a specific line from a text file
     * that acts as a database. It reads the original file, copies all lines except
     * the specified one to a temporary file, and then replaces the original file
     * with the temporary file.
     *
     * @param in The line to be removed from the database file.
     */
    public EliminarDeBaseDeDatos(String in)  {
     String ruta="";
     String nombre="GestorInventario.txt";
     //String desc;


        File archivo=new File(ruta+nombre);
        //eliminar un elemento de la base de datos
        //se crea un archivo temporal para almacenar los datos
        //se lee el archivo original y se copian los datos al archivo temporal
        //se elimina la linea que se desea eliminar
        //se copian los datos del archivo temporal al archivo original
        //se elimina el archivo temporal
        File archivoTemporal = new File(ruta+"temporal.txt");
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(archivoTemporal);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;
            while((linea = br.readLine()) != null){
                if(!linea.equals(in)){
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            br.close();
            archivo.delete();
            archivoTemporal.renameTo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }

     
    }

}
