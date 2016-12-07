package aps;

public class BancoDados {

    // Responsavel por retornar o caminho dos arquivos do banco de dados
    private String acesso1;
    private String acesso2;
    private String acesso3;

    public String getAcesso1() {
        acesso1 = "..\\aps\\src\\A11.txt";
        return acesso1;
    }

    public String getAcesso2() {
        acesso2 = "..\\aps\\src\\A22.txt";
        return acesso2;
    }

    public String getAcesso3() {
        acesso3 = "..\\aps\\src\\A33.txt";
        return acesso3;
    }

}
