package com.pontodata.relatorios.Models;

public class WebSitesBloqueadosModel {
    private String nomeEndPoint;
    private String fqdnEndpoint;
    private String sitesBloqueados;
    private int countSitesBloqueados;
    private String bloqueadoPor;
    private String reasaoBloqueio;
    private String usuario;
    private String tentativaBlqueio;
    private String ultimoBloqueio;

    public WebSitesBloqueadosModel(String nomeEndPoint, String fqdnEndpoint, String sitesBloqueados, int countSitesBloqueados) {
        this.nomeEndPoint = nomeEndPoint;
        this.fqdnEndpoint = fqdnEndpoint;
        this.sitesBloqueados = sitesBloqueados;
        this.countSitesBloqueados = countSitesBloqueados;
    }

    public WebSitesBloqueadosModel(String nomeEndPoint, String fqdnEndpoint, String sitesBloqueados, String bloqueadoPor, String reasaoBloqueio, String usuario, String tentativaBlqueio, String ultimoBloqueio) {
        this.nomeEndPoint = nomeEndPoint;
        this.fqdnEndpoint = fqdnEndpoint;
        this.sitesBloqueados = sitesBloqueados;
        this.bloqueadoPor = bloqueadoPor;
        this.reasaoBloqueio = reasaoBloqueio;
        this.usuario = usuario;
        this.tentativaBlqueio = tentativaBlqueio;
        this.ultimoBloqueio = ultimoBloqueio;
    }

    public String getNomeEndPoint() {
        return nomeEndPoint;
    }

    public void setNomeEndPoint(String nomeEndPoint) {
        this.nomeEndPoint = nomeEndPoint;
    }

    public String getFqdnEndpoint() {
        return fqdnEndpoint;
    }

    public void setFqdnEndpoint(String fqdnEndpoint) {
        this.fqdnEndpoint = fqdnEndpoint;
    }

    public String getSitesBloqueados() {
        return sitesBloqueados;
    }

    public void setSitesBloqueados(String sitesBloqueados) {
        this.sitesBloqueados = sitesBloqueados;
    }

    public String getBloqueadoPor() {
        return bloqueadoPor;
    }

    public void setBloqueadoPor(String bloqueadoPor) {
        this.bloqueadoPor = bloqueadoPor;
    }

    public String getReasaoBloqueio() {
        return reasaoBloqueio;
    }

    public void setReasaoBloqueio(String reasaoBloqueio) {
        this.reasaoBloqueio = reasaoBloqueio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTentativaBlqueio() {
        return tentativaBlqueio;
    }

    public void setTentativaBlqueio(String tentativaBlqueio) {
        this.tentativaBlqueio = tentativaBlqueio;
    }

    public String getUltimoBloqueio() {
        return ultimoBloqueio;
    }

    public void setUltimoBloqueio(String ultimoBloqueio) {
        this.ultimoBloqueio = ultimoBloqueio;
    }

    public int getCountSitesBloqueados() {
        return countSitesBloqueados;
    }

    public void setCountSitesBloqueados(int countSitesBloqueados) {
        this.countSitesBloqueados += countSitesBloqueados;
    }

    public String toBkMaquina() {
        return "WebSitesBloqueadosModel{" +
                "nomeEndPoint='" + nomeEndPoint + '\'' +
                ", fqdnEndpoint='" + fqdnEndpoint + '\'' +
                ", sitesBloqueados='" + sitesBloqueados + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "WebSitesBloqueadosModel{" +
                "nomeEndPoint='" + nomeEndPoint + '\'' +
                ", fqdnEndpoint='" + fqdnEndpoint + '\'' +
                ", sitesBloqueados='" + sitesBloqueados + '\'' +
                ", bloqueadoPor='" + bloqueadoPor + '\'' +
                ", reasaoBloqueio='" + reasaoBloqueio + '\'' +
                ", usuario='" + usuario + '\'' +
                ", tentativaBlqueio='" + tentativaBlqueio + '\'' +
                ", ultimoBloqueio='" + ultimoBloqueio + '\'' +
                '}';
    }
}
