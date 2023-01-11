package com.pontodata.relatorios.Models;

public class AuditoriaSegurancaModel {
    private String antimalware;
    private String atcIds;
    private String controleConteudo;
    private String firewall;
    private String deteccaoAntiexploit;
    private String defesaAtaque;
    private String mitigracaoRansomware;

    public AuditoriaSegurancaModel(String antimalware, String atcIds, String controleConteudo, String firewall, String deteccaoAntiexploit, String defesaAtaque, String mitigracaoRansomware) {
        this.antimalware = antimalware;
        this.atcIds = atcIds;
        this.controleConteudo = controleConteudo;
        this.firewall = firewall;
        this.deteccaoAntiexploit = deteccaoAntiexploit;
        this.defesaAtaque = defesaAtaque;
        this.mitigracaoRansomware = mitigracaoRansomware;
    }

    public String getAntimalware() {
        return antimalware;
    }

    public void setAntimalware(String antimalware) {
        this.antimalware = antimalware;
    }

    public String getAtcIds() {
        return atcIds;
    }

    public void setAtcIds(String atcIds) {
        this.atcIds = atcIds;
    }

    public String getControleConteudo() {
        return controleConteudo;
    }

    public void setControleConteudo(String controleConteudo) {
        this.controleConteudo = controleConteudo;
    }

    public String getFirewall() {
        return firewall;
    }

    public void setFirewall(String firewall) {
        this.firewall = firewall;
    }

    public String getDeteccaoAntiexploit() {
        return deteccaoAntiexploit;
    }

    public void setDeteccaoAntiexploit(String deteccaoAntiexploit) {
        this.deteccaoAntiexploit = deteccaoAntiexploit;
    }

    public String getDefesaAtaque() {
        return defesaAtaque;
    }

    public void setDefesaAtaque(String defesaAtaque) {
        this.defesaAtaque = defesaAtaque;
    }

    public String getMitigracaoRansomware() {
        return mitigracaoRansomware;
    }

    public void setMitigracaoRansomware(String mitigracaoRansomware) {
        this.mitigracaoRansomware = mitigracaoRansomware;
    }

    @Override
    public String toString() {
        return "RelatorioAuditoriaModel{" +
                "antimalware='" + antimalware + '\'' +
                ", atcIds='" + atcIds + '\'' +
                ", controleConteudo='" + controleConteudo + '\'' +
                ", firewall='" + firewall + '\'' +
                ", deteccaoAntiexploit='" + deteccaoAntiexploit + '\'' +
                ", defesaAtaque='" + defesaAtaque + '\'' +
                ", mitigracaoRansomware='" + mitigracaoRansomware + '\'' +
                '}';
    }
}
