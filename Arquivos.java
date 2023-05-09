import java.io.*;
import java.util.*;

public class Arquivos {
    public String ReadData(String caminho, Boolean repeatLines) {
        String conteudo = "";
        Map<String, String> nonRepeatedData = new HashMap<>();
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    if (!repeatLines) {
                        String[] aux = linha.split(";");
                        nonRepeatedData.put(aux[0], aux[1] + "\n");
                    } else {
                        conteudo += linha + "\n";
                    }
                    linha = lerArq.readLine();
                }
                arq.close();

                if (!repeatLines) {
                    Set keys = nonRepeatedData.keySet();
                    Iterator iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        Object aux = iterator.next();
                        conteudo += aux + ";" + nonRepeatedData.get(aux);
                    }
                }
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public boolean WriteData(String Caminho, String texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.write(texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String CombineData(String Caminho1, String Caminho2, Boolean repeatData) {
        String dataArch1 = this.ReadData(Caminho1, repeatData);
        String dataArch2 = this.ReadData(Caminho2, repeatData);
        String combinetedData = dataArch1 + "" + dataArch2;

        Boolean isWritted = this.WriteData("dadosCombinados.txt", combinetedData);
        combinetedData = this.ReadData("dadosCombinados.txt", repeatData);
        Boolean isWritted2 = this.WriteData("dadosCombinados.txt", combinetedData);

        if (isWritted && isWritted2) {
            System.out.println("Arquivos combinados com sucesso");
        }

        return combinetedData;
    }
}