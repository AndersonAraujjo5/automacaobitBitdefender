package com.pontodata.relatorios.Models;

public class AuditoriaDeSeguranca {
    private String nomeEndPoint;
    private String fqdnEndPoint;
    private String usuario;
    private String ocorrencia;
    private String ultimaOcorrencia;
    private String modulo;
    private String tipoEvento;
    private String detalhes;
    private String hash;
    private String ataqueSemArquivo;


    public AuditoriaDeSeguranca(String nomeEndPoint, String fqdnEndPoint, String usuario, String ocorrencia, String ultimaOcorrencia, String modulo, String tipoEvento, String detalhes, String hash, String ataqueSemArquivo) {
        this.nomeEndPoint = nomeEndPoint;
        this.fqdnEndPoint = fqdnEndPoint;
        this.usuario = usuario;
        this.ocorrencia = ocorrencia;
        this.ultimaOcorrencia = ultimaOcorrencia;
        this.modulo = modulo;
        this.tipoEvento = tipoEvento;
        this.detalhes = detalhes;
        this.hash = hash;
        this.ataqueSemArquivo = ataqueSemArquivo;
    }

    public String getNomeEndPoint() {
        return nomeEndPoint;
    }

    public void setNomeEndPoint(String nomeEndPoint) {
        this.nomeEndPoint = nomeEndPoint;
    }

    public String getFqdnEndPoint() {
        return fqdnEndPoint;
    }

    public void setFqdnEndPoint(String fqdnEndPoint) {
        this.fqdnEndPoint = fqdnEndPoint;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getUltimaOcorrencia() {
        return ultimaOcorrencia;
    }

    public void setUltimaOcorrencia(String ultimaOcorrencia) {
        this.ultimaOcorrencia = ultimaOcorrencia;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAtaqueSemArquivo() {
        return ataqueSemArquivo;
    }

    public void setAtaqueSemArquivo(String ataqueSemArquivo) {
        this.ataqueSemArquivo = ataqueSemArquivo;
    }



    @Override
    public String toString() {
        return "WebSitesModels{" +
                "nomeEndPoint='" + nomeEndPoint + '\'' +
                ", fqdnEndPoint='" + fqdnEndPoint + '\'' +
                ", usuario='" + usuario + '\'' +
                ", ocorrencia='" + ocorrencia + '\'' +
                ", ultimaOcorrencia='" + ultimaOcorrencia + '\'' +
                ", modulo='" + modulo + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", hash='" + hash + '\'' +
                ", ataqueSemArquivo='" + ataqueSemArquivo + '\'' +
                '}';
    }
}
