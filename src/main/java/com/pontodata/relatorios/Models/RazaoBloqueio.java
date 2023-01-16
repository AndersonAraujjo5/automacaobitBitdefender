package com.pontodata.relatorios.Models;

import java.util.ArrayList;
import java.util.List;

public class RazaoBloqueio {
    private int anuncios;
    private int vidioEntrterimento;
    private int vidio;
    private int jogos;
    private int hobbies;
    private int redeSocial;
    private int tabloides;
    private int jogosAzar;
    private int entretenimento;

    private int qtBloqueio;
    private int qtVezesBloqueados;
    private int outros;
    private List<String> infoOutros = new ArrayList<>();


    public int getAnuncios() {
        return anuncios;
    }

    public void setAnuncios() {
        this.anuncios++;
    }

    public int getVidioEntrterimento() {
        return vidioEntrterimento;
    }

    public void setVidioEntrterimento() {
        this.vidioEntrterimento++;
    }

    public int getVidio() {
        return vidio;
    }

    public void setVidio() {
        this.vidio++;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos() {
        this.jogos++;
    }

    public int getHobbies() {
        return hobbies;
    }

    public void setHobbies() {
        this.hobbies++;
    }

    public int getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial() {
        this.redeSocial++;
    }

    public int getTabloides() {
        return tabloides;
    }

    public void setTabloides() {
        this.tabloides++;
    }

    public int getJogosAzar() {
        return jogosAzar;
    }

    public void setJogosAzar() {
        this.jogosAzar++;
    }

    public int getEntretenimento() {
        return entretenimento;
    }

    public void setEntretenimento() {
        this.entretenimento++;
    }

    public int getOutros() {
        return outros;
    }

    public List<String> getInfoOutros() {
        return infoOutros;
    }

    public int getQtBloqueio() {
        return anuncios+vidioEntrterimento+vidio+jogos+hobbies+redeSocial+tabloides+jogosAzar+entretenimento+outros;
    }


    public int getQtVezesBloqueados() {
        return qtVezesBloqueados;
    }

    public void setQtVezesBloqueados(int qtVezesBloqueados) {
        this.qtVezesBloqueados += qtVezesBloqueados;
    }

    public void setInfoOutros(String infoOutros) {
        this.infoOutros.add(infoOutros);
    }

    public void setOutros() {
        this.outros++;
    }

    @Override
    public String toString() {
        return "RazaoBloqueio{" +
                "anuncios=" + anuncios +
                ", vidioEntrterimento=" + vidioEntrterimento +
                ", vidio=" + vidio +
                ", jogos=" + jogos +
                ", hobbies=" + hobbies +
                ", redeSocial=" + redeSocial +
                ", tabloides=" + tabloides +
                ", jogosAzar=" + jogosAzar +
                ", entretenimento=" + entretenimento +
                ", outros=" + outros +
                '}';
    }
}
