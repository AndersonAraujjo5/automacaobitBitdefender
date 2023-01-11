package com.pontodata.relatorios.Models;

public class WebSitesBloqueadosModel {
    private String nomeEndPoint;
    private String fqdnEndpoint;
    private String sitesBloqueados;

    public WebSitesBloqueadosModel(String nomeEndPoint, String fqdnEndpoint, String sitesBloqueados) {
        this.nomeEndPoint = nomeEndPoint;
        this.fqdnEndpoint = fqdnEndpoint;
        this.sitesBloqueados = sitesBloqueados;
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

    @Override
    public String toString() {
        return "WebSitesBloqueadosModel{" +
                "nomeEndPoint='" + nomeEndPoint + '\'' +
                ", fqdnEndpoint='" + fqdnEndpoint + '\'' +
                ", sitesBloqueados='" + sitesBloqueados + '\'' +
                '}';
    }
}
