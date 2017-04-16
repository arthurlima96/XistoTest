package xistotest.com.br.model;

/**
 * Created by Arthur C. Lima on 14/04/2017.
 */

public class Pergunta {

    private String pegunta;
    private String resposta;
    private String gabarito;
    private String imagem;

    public Pergunta(String pergunta,String gabarito){
        this.pegunta = pergunta;
        this.gabarito = gabarito;
    }

    public String getPegunta() {
        return pegunta;
    }

    public void setPegunta(String pegunta) {
        this.pegunta = pegunta;
    }

    public String getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
