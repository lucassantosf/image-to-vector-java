package aps;

import com.sun.javafx.iio.ImageMetadata;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Controle {

    private String Caminho;
    public byte[] imageInByte;
    private boolean acesso;
    private int nivel;

    public void ImageToVetor() {

        // Receber a imagem de amostra escolhida pelo usuario e converter para vetor
        try {

            BufferedImage originalImage = ImageIO.read(new File(this.Caminho));

            ByteArrayOutputStream vtr = new ByteArrayOutputStream();

            ImageIO.write(originalImage, "jpg", vtr);

            vtr.flush();
            imageInByte = vtr.toByteArray();
            vtr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Comparar comparacao = new Comparar();
        comparacao.setAmostra(imageInByte);
        comparacao.CompararBD();
        acesso = comparacao.isPermissaoacesso();
        nivel = comparacao.getNivel();
    }

    public int getNivel() {
        return nivel;
    }

    public String getCaminho() {
        return Caminho;
    }

    public void setCaminho(String Caminho) {
        this.Caminho = Caminho;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

}
