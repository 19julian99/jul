package CreateFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class CreateFiles {
	
	public static void main(String[] args) {
        // objeto que se usa para crear un archivo punto UMD
        CreateFiles cf = new CreateFiles();
        // .countRead es para saber si alguna contiene algun String especifico
        System.out.println(cf.countReads("CAA"));
        // la cadena a encontrar en este caso es 

    }

    public CreateFiles() {
        //Secuencias.umd
        //EnteroAleatorio, EnteroAleatorio(Mayor), CadenaCaracteresAleatoria(ACGT)1000 lineas
        // .length  es para saber el numero de caracteres en una cadena
        int start, length;
        String sequence;
        // objeto para crear un numero random
        Random rd = new Random();
        // try  y catch son parte condicional que intentan prevenir o resolver errores con excepciones
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("secuencias.umd"));
            // ciclo que hace mill lineas
            for (int i = 0; i <= 1000; i++) {
                // En este caso se usa librea Math para llamar al balor absoluto 
                start = Math.abs(rd.nextInt());
                length = 5 + rd.nextInt(25);
                //se genera secuencia como una variable en blanco
                sequence = "";
                for (int j = 0; j < length; j++) {	//Swich crea 3 casos donde en cada uno  se asigna una letra a la variable sequence
                    switch (rd.nextInt(4)) {
                        case 0:
                            sequence += "A";
                            break;

                        case 1:
                            sequence += "C";
                            break;

                        case 2:
                            sequence += "G";
                            break;

                        case 3:
                            sequence += "T";
                            break;
                    }
                }
                // sale en conola el numero , el numero mas un agredado y la secuencia
                bw.write(start + "," + (start + length) + "," + sequence + "\n");
            }
            bw.flush();

        } catch (IOException e) {
            //IOException genera una excepcion en cuanto a un resultado o procedimiento en el codigo
            e.printStackTrace();
        }
    }

    public int countReads(String motif) {
        int lines = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("secuencias.umd"));
            String read;
            read = br.readLine();

            // se hace una condicion donde dice que read debe ser diferente a null 
            while (read != null) {
            // split sirve para separar una cadena de caracteres donde alla una coma 
            // contains como su nombre indica es saber si contiene el motif
                if (read.split(",")[2].contains(motif)) {
                    lines += 1;
                }
                read = br.readLine();
            }
            // se pone la excepcion del try para finlaizar y solucionar el error 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // se retorna la variable lines
        return lines;
    }
}
