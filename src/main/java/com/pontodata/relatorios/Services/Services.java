package com.pontodata.relatorios.Services;

import com.pontodata.relatorios.Models.AuditoriaSegurancaModel;
import com.pontodata.relatorios.Models.IncidentesRedeModel;
import com.pontodata.relatorios.Models.WebSitesBloqueadosModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface Services {
    public List<AuditoriaSegurancaModel> auditoria(String nameFile) throws IOException;
    public List<IncidentesRedeModel> incidenteRede(String nameFile) throws IOException;
    public List<WebSitesBloqueadosModel> webSites(String nameFile) throws IOException;
}
