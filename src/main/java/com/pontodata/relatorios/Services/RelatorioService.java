package com.pontodata.relatorios.Services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pontodata.relatorios.Models.AuditoriaSegurancaModel;
import com.pontodata.relatorios.Models.IncidentesRedeModel;
import com.pontodata.relatorios.Models.WebSitesBloqueadosModel;
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
    @Override
    public List<AuditoriaSegurancaModel> auditoria(String nameFile) throws IOException {
        List<AuditoriaSegurancaModel> auditoriaSegurancaModels = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        List<Object[]> l = new ArrayList<>();
        for (String[] relat : relatorio) {
            AuditoriaSegurancaModel asm = new AuditoriaSegurancaModel(relat[0], relat[1], relat[2], relat[3],
                    relat[4], relat[5], relat[6]);
            auditoriaSegurancaModels.add(asm);
        }
        return auditoriaSegurancaModels;
    }

    @Override
    public List<IncidentesRedeModel> incidenteRede(String nameFile) throws IOException {
        List<IncidentesRedeModel> incidentesRedeModels = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        List<Object[]> l = new ArrayList<>();
        for (String[] relat : relatorio) {
            IncidentesRedeModel asm = new IncidentesRedeModel(relat[0], relat[1], relat[2], relat[3],
                    relat[4], relat[5], relat[6],relat[7],relat[8],relat[9],relat[10],relat[12],relat[13]);
            incidentesRedeModels.add(asm);
        }
        return incidentesRedeModels;
    }

    @Override
    public List<WebSitesBloqueadosModel> webSites(String nameFile) throws IOException {
        List<WebSitesBloqueadosModel> webSitesBloqueadosModel = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("./upload-dir/"+nameFile));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> relatorio = csvReader.readAll();
        List<Object[]> l = new ArrayList<>();
        for (String[] relat : relatorio) {
            WebSitesBloqueadosModel asm = new WebSitesBloqueadosModel(relat[0], relat[1], relat[2]);
            webSitesBloqueadosModel.add(asm);
        }
        return webSitesBloqueadosModel;
    }
}
