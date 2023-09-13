import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LerCSV {

    public static void main(String[] args) {

        String csvArquivo = "C:\\Users\\Frederico Rocha\\OneDrive\\Área de Trabalho\\Coding Interview\\baseDados.csv";

        BufferedReader conteudoCSV = null;

        String linha = "";

        String csvSepadorCampo = ";";

        try {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            while ((linha = conteudoCSV.readLine()) != null) {
                String[] dados = linha.split(csvSepadorCampo);
                System.out.println(" " + dados[0]
                + " " + dados[1]
                + " " + dados[2]
                + " " + dados[3]
                + " " + dados[4]
                + " " + dados[5]
                + " " + dados[6]);

                System.out.println(" " + dados[3]);

            int peso = 0;

            //if ( peso > dados[5])
            //    peso = dados[5];

            int altura = 0;

            //if (altura > dados[6])
            //    altura = dados[6];


                Map<String, Integer> contador = new HashMap<>();

                // Percorra a lista de strings e atualize o contador
                for (String valor : conteudoCSV.) {
                    if (contador.containsKey(valor)) {
                        contador.put(valor, contador.get(valor) + 1);
                    } else {
                        contador.put(valor, 1);
                    }
                }

                // Exiba o resultado
                for (Map.Entry<String, Integer> entry : contador.entrySet()) {
                    System.out.println("Valor '" + entry.getKey() + "' aparece " + entry.getValue() + " vezes");
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("A");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("B");
        } catch (IOException e) {
            System.out.println();
        } finally {
            if (conteudoCSV != null) {
                try {
                    conteudoCSV.close();
                } catch (IOException e) {
                    System.out.println();
                }
            }
        }
    }
}