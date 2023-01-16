package com.pontodata.relatorios.Services;

import com.pontodata.relatorios.Models.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface Services {
    //public List<AuditoriaSegurancaModel> auditoria(String nameFile) throws IOException;
    public List<IncidentesRedeModel> incidenteRede(String nameFile) throws IOException;
    public List<AuditoriaDeSeguranca> auditoriaDeSeguranca(String nameFile) throws IOException;
    public List<WebSitesBloqueadosModel> webSitesBloqueados(String nameFile) throws IOException;
    public AuditoriaSegurancaModel countAud();
    public RazaoBloqueio countRazaoBloqueio();
}
