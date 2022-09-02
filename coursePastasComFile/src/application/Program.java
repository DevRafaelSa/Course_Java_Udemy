package application;

import java.io.File;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        //essa chamada vai criar um vetor de File contendo cada um dos caminhos da pasta path.
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS");
        for (File folder : folders) {
            System.out.println(folder);

        }

        //agora a lista de arquivos
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES");
        for (File file : files) {
            System.out.println(file);
        }

        //criando uma subpasta
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Diretorio criado com sucesso: " + success);

        System.out.println("Enter a folder path: ");
        String strPaste = sc.nextLine();

        File path2 = new File(strPaste);
        System.out.println("Apenas nome: " + path2.getName());
        System.out.println("Só Caminho: " + path2.getParent());
        System.out.println("Caminho completo: " + path2.getPath());

        sc.close();
    }
}
