package com.pontodata.relatorios.Services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pontodata.relatorios.Models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService implements Services{
    private final AuditoriaSegurancaModel auditoriaSegurancaModel = new AuditoriaSegurancaModel();
    private final RazaoBloqueio razaoBloqueio = new RazaoBloqueio();
//    @Override
//    public List<AuditoriaSegurancaModel> auditoria(String nameFile) throws IOException {
//        List<AuditoriaSegurancaModel> auditoriaSegurancaModels = new ArrayList<>();
//        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
//        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
//
//        List<String[]> relatorio = csvReader.readAll();
//        List<Object[]> l = new ArrayList<>();
//        for (String[] relat : relatorio) {
//            AuditoriaSegurancaModel asm = new AuditoriaSegurancaModel(relat[0], relat[1], relat[2], relat[3],
//                    relat[4], relat[5], relat[6]);
//            auditoriaSegurancaModels.add(asm);
//        }
//        return auditoriaSegurancaModels;
//    }

    @Override
    public List<IncidentesRedeModel> incidenteRede(String nameFile) throws IOException {
        List<IncidentesRedeModel> incidentesRedeModels = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        List<Object[]> l = new ArrayList<>();
        for (String[] relat : relatorio) {
            IncidentesRedeModel asm = new IncidentesRedeModel(relat[0], relat[1], relat[2], relat[3],
                    relat[4], relat[5], relat[6],relat[7],relat[8],relat[9],relat[10],relat[11],relat[12]);
            asm.setCount();
            incidentesRedeModels.add(asm);
        }
        return incidentesRedeModels;
    }

    @Override
    public AuditoriaSegurancaModel countAud() {
        return this.auditoriaSegurancaModel;
    }

    @Override
    public RazaoBloqueio countRazaoBloqueio() {
        return this.razaoBloqueio;
    }

    @Override
    public List<AuditoriaDeSeguranca> auditoriaDeSeguranca(String nameFile) throws IOException {
        System.out.println(nameFile);
        List<AuditoriaDeSeguranca> webSitesModels = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        List<Object[]> l = new ArrayList<>();
        for (String[] relat : relatorio) {
            this.checkOcorrencia(relat[5]);
            AuditoriaDeSeguranca asm = new AuditoriaDeSeguranca(relat[0], relat[1], relat[2],
                    relat[3], relat[4], relat[5], relat[6], relat[7], relat[8],relat[9]);
            webSitesModels.add(asm);
        }
        return webSitesModels;
    }

    public List<WebSitesBloqueadosModel> webSitesBloqueados(String nameFile) throws IOException {
        System.out.println(nameFile);
        List<WebSitesBloqueadosModel> webSitesModels = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        boolean pule = false;
        for (String[] relat : relatorio) {

            if (relat.length > 3){
                if (relat[2].equals("URL"))
                    continue;
                this.checkRazaoBloqueio(relat[4]);
                WebSitesBloqueadosModel asm = new WebSitesBloqueadosModel(relat[0], relat[1], relat[2],
                        relat[3], relat[4], relat[5], relat[6], relat[7]);
                this.razaoBloqueio.setQtVezesBloqueados(Integer.parseInt(relat[6]));
                webSitesModels.add(asm);
            }

        }
        return webSitesModels;
    }

    public void checkRazaoBloqueio(String razao){
        switch (razao){
            case "Anúncios":
                this.razaoBloqueio.setAnuncios();
                break;
            case "Vídeo, Entretenimento":
                this.razaoBloqueio.setVidioEntrterimento();
                break;
            case "Jogos":
                this.razaoBloqueio.setJogos();
                break;
            case "Hobbies":
                this.razaoBloqueio.setHobbies();
                break;
            case "Rede Social":
                this.razaoBloqueio.setRedeSocial();
                break;
            case "Vídeo":
                this.razaoBloqueio.setVidio();
                break;
            case "Jogos de azar":
                this.razaoBloqueio.setJogosAzar();
                break;
            default:
                this.razaoBloqueio.setOutros();
                this.razaoBloqueio.setInfoOutros(razao);
        }
    }

    public void checkOcorrencia(String modulo){
        switch (modulo){
            case "Antimalware":
                this.auditoriaSegurancaModel.setAntimalware();
                break;
            case "Defesa de Ataque em Rede":
                this.auditoriaSegurancaModel.setDefesaAtaque();
                break;
            case "Controle de Dispositivos":
                this.auditoriaSegurancaModel.setControleDispositivo();
                break;
            case "Controle de Conteúdo":
                this.auditoriaSegurancaModel.setControleConteudo();
                break;
            case "Firewall":
                this.auditoriaSegurancaModel.setFirewall();
                break;
            case "Detecção antiexploit avançado":
                this.auditoriaSegurancaModel.setDeteccaoAntiexploit();
                break;
            case "Mitigação de Ransomware":
                this.auditoriaSegurancaModel.setMitigracaoRansomware();
                break;
            case "ATC/IDS":
                this.auditoriaSegurancaModel.setAtcIds();
                break;
            default:
                System.out.println(modulo);
        }
    }
}
