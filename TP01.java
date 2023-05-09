public class TP01 {

    public static void main(String[] args) {
        String arq1 = "dados.txt";
        String arq2 = "dados2.txt";
        Arquivos arquivo = new Arquivos();

        // Lendo apenas os dados do primeiro arquivo
        // String texto = arquivo.ReadData(arq1, false);
        // if (texto.isEmpty())
        // System.out.println("Erro ao ler do arquivo!");
        // else
        // System.out.println(texto);

        // Lendo apenas os dados do segundo arquivo
        // String texto2 = arquivo.ReadData(arq2, false);
        // if (texto.isEmpty())
        // System.out.println("Erro ao ler do arquivo!");
        // else
        // System.out.println(texto2);

        String combinatedData = arquivo.CombineData(arq1, arq2, false);
        System.out.println(combinatedData);

    }
}
