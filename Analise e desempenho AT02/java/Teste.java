import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static List<String> lerArquivo(File arq){
        List<String> retorno = new ArrayList<String>();
        try{
            Scanner scan = new Scanner(arq, "UTF-8");
            while (scan.hasNextLine()) {
                retorno.add(scan.nextLine());
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }


    public static void main(String[] args) {
        float tempo_inicial = System.nanoTime();
        String arquivo = "arq.txt";
        L_Ligada lista = new L_Ligada();
        List<String> filedata = lerArquivo(new File(arquivo));
        String[] numeros = filedata.get(0).split(" ");
        for (String num : numeros) {
            lista.adicionar( (Integer.parseInt(num)), 999);
        }
        List<String> comandos = filedata.subList(1, filedata.size());
        for (String comando : comandos) {
            String[] cmd = comando.split(" ");
            if (cmd[0].equals("A")) {
                if (cmd.length == 3) {
                    lista.adicionar(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                }
            } else if (cmd[0].equals("R")) {
                lista.remover(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("P")) {
                lista.imprimir();
            }
        }
        float tempo_final = System.nanoTime();
        float tempo = (tempo_final - tempo_inicial) / 1000000;
        System.out.println("Tempo de execução: " + (tempo_final - tempo_inicial) / 1000000 + "ms");
        File arquivo_saida = new File("Medicoes Java.txt");
        try {
            if (!arquivo_saida.exists()) {
                arquivo_saida.createNewFile();
            }
            java.io.FileWriter fw = new java.io.FileWriter(arquivo_saida, true);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.write("Java: " + tempo + "ms\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
