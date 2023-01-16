package com.pontodata.relatorios.Models;


public class AuditoriaSegurancaModel {
    private int antimalware;
    private int atcIds;
    private int controleConteudo;
    private int firewall;
    private int deteccaoAntiexploit;
    private int defesaAtaque;
    private int mitigracaoRansomware;
    private int controleDispositivo;
    private int totalBloqueio;

    public int getAntimalware() {
        return antimalware;
    }

    public void setAntimalware() {
        this.antimalware++;
    }

    public int getAtcIds() {
        return atcIds;
    }

    public void setAtcIds() {
        this.atcIds++;
    }

    public int getControleConteudo() {
        return controleConteudo;
    }

    public void setControleConteudo() {
        this.controleConteudo++;
    }

    public int getFirewall() {
        return firewall;
    }

    public void setFirewall() {
        this.firewall++;
    }

    public int getDeteccaoAntiexploit() {
        return deteccaoAntiexploit;
    }

    public void setDeteccaoAntiexploit() {
        this.deteccaoAntiexploit++;
    }

    public int getDefesaAtaque() {
        return defesaAtaque;
    }

    public void setDefesaAtaque() {
        this.defesaAtaque++;
    }

    public int getMitigracaoRansomware() {
        return mitigracaoRansomware;
    }

    public void setMitigracaoRansomware() {
        this.mitigracaoRansomware++;
    }

    public int getControleDispositivo() {
        return controleDispositivo;
    }

    public void setControleDispositivo() {
        this.controleDispositivo++;
    }

    public int getTotalBloqueio() {
        return antimalware+atcIds+controleConteudo+firewall+deteccaoAntiexploit+defesaAtaque+mitigracaoRansomware+controleDispositivo;
    }

    @Override
    public String toString() {
        return "AuditoriaSegurancaModel{" +
                "Antimalware=" + antimalware +
                ", ATC/IDS=" + atcIds +
                ", Controle de Conteudo=" + controleConteudo +
                ", Firewall=" + firewall +
                ", deteccaoAntiexploit=" + deteccaoAntiexploit +
                ", defesaAtaque=" + defesaAtaque +
                ", mitigracaoRansomware=" + mitigracaoRansomware +
                ", Controle deDispositivo=" + controleDispositivo +
                '}';
    }
}
