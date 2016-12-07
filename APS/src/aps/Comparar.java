package aps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comparar {

    private byte[] amostra;
    private String caminho1;
    private String caminho2;
    private String caminho3;
    private boolean permissaoacesso = true;
    private int nivel = 0;

    int[] referencia1 = new int[11029];
    int[] referencia2 = new int[8809];
    int[] referencia3 = new int[13079];

    public void CompararBD() {

        BancoDados banco = new BancoDados();
        caminho1 = banco.getAcesso1();
        caminho2 = banco.getAcesso2();
        caminho3 = banco.getAcesso3();

        referencia1 = lerBancoDados(caminho1, referencia1);

        // Algoritmo para comparar vetores e definir nivel de acesso
        for (int a = 0; a < amostra.length; a++) {

            if (amostra[a] != referencia1[a]) {
                permissaoacesso = false;
                referencia2 = lerBancoDados(caminho2, referencia2);

                for (int x = 0; x < amostra.length; x++) {

                    if (amostra[x] != referencia2[x]) {
                        permissaoacesso = false;

                        referencia3 = lerBancoDados(caminho3, referencia3);

                        for (int b = 0; b < amostra.length; b++) {

                            if (amostra[b] != referencia3[b]) {
                                permissaoacesso = false;
                                break;
                            } else {
                                permissaoacesso = true;
                                this.nivel = 3;
                            }
                        }

                        break;
                    } else {
                        permissaoacesso = true;
                        this.nivel = 2;
                    }
                }

                break;

            } else {
                permissaoacesso = true;
                this.nivel = 1;
            }
        }

    }

    public int[] lerBancoDados(String caminho, int[] referencia) {

        // recuperar vetor do banco de dados
        String nomeArquivo = null;
        String nomeArquivoCompleto = caminho;
        nomeArquivo = nomeArquivoCompleto;

        FileInputStream fin = null;
        BufferedReader in = null;
        String linha = null;

        try {

            fin = new FileInputStream(nomeArquivo);

            in = new BufferedReader(new InputStreamReader(fin));
            int i = 0;

            while (in.ready()) {

                linha = in.readLine();

                if (linha == null) {
                    break;
                }
                linha = linha.trim();

                if (linha.length() != 0) {

                    referencia[i] = Integer.parseInt(linha);
                    i++;
                }
            }
            fin.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado ...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Erro durante a leitura do arquivo ...");
            System.exit(1);
        }
        return referencia;
    }

    public byte[] getAmostra() {
        return amostra;
    }

    public void setAmostra(byte[] amostra) {
        this.amostra = amostra;
    }

    public boolean isPermissaoacesso() {
        return permissaoacesso;
    }

    public int getNivel() {
        return nivel;
    }

}
