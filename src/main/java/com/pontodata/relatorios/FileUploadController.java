package com.pontodata.relatorios;


import com.pontodata.relatorios.Models.AuditoriaDeSeguranca;
import com.pontodata.relatorios.Models.IncidentesRedeModel;
import com.pontodata.relatorios.Models.WebSitesBloqueadosModel;
import com.pontodata.relatorios.Services.RelatorioService;
import com.pontodata.relatorios.storage.StorageFileNotFoundException;
import com.pontodata.relatorios.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	private final RelatorioService relatorioService;
	private List<AuditoriaDeSeguranca> auditoriaDeSegurancas;
	private List<IncidentesRedeModel> incidentesRedeModels;
	private List<WebSitesBloqueadosModel> webSitesBloqueadosModels;
	private List<AuditoriaDeSeguranca> audiPesquisa;
	private List<IncidentesRedeModel> incidePesquisa;
	private List<WebSitesBloqueadosModel> webBloPesquisa;
	private final Date data = new Date();
	private final SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
	private final String date = dataFormatada.format(data);
	private final String[] nameFile = {
			"auditoria-de-seguranca.csv",
			"incidente-de-rede.csv",
			"web-sites-bloquados.csv"
	};

	@Autowired
	public FileUploadController(StorageService storageService, RelatorioService relatorioService) {
		this.storageService = storageService;
		this.relatorioService = relatorioService;
	}

	@GetMapping("/")
	public ModelAndView listUploadedFiles(){
		return new ModelAndView("uploadForm");
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("auditoria") MultipartFile auditoria,
								   @RequestParam("incidenteRede") MultipartFile incidenteRede,
								   @RequestParam("webSites") MultipartFile webSites,
								   RedirectAttributes redirectAttributes) throws IOException {

		storageService.store(auditoria, nameFile[0]);
		storageService.store(incidenteRede, nameFile[1]);
		storageService.store(webSites, nameFile[2]);

		this.auditoriaDeSegurancas = this.relatorioService.auditoriaDeSeguranca(date+"/"+nameFile[0]);
		this.webSitesBloqueadosModels = this.relatorioService.webSitesBloqueados(date+"/"+nameFile[2]);
		this.incidentesRedeModels = this.relatorioService.incidenteRede(date+"/"+nameFile[1]);

		return "redirect:/relatorio";
	}

	@GetMapping("/relatorio")
	public ModelAndView index() throws IOException {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("auditoria", this.relatorioService.countAud());
		mv.addObject("webBloquedos", this.relatorioService.countRazaoBloqueio());
		mv.addObject("incidente",
				this.relatorioService.incidenteRede(date+"/"+nameFile[1]).size());
		return mv;
	}


	@GetMapping("/relatorio/auditoria")
	public ModelAndView auditoria(){
		ModelAndView mv = new ModelAndView("auditoria");
		List<AuditoriaDeSeguranca> audi = new ArrayList<>();
		for (int i =0; i<20;i++) {
			System.out.println(this.auditoriaDeSegurancas.get(i));
			audi.add(this.auditoriaDeSegurancas.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countAud());
		return mv;
	}

	@GetMapping("/relatorio/auditoria/{page}")
	public ModelAndView auditoriaPage(@PathVariable("page") int page){
		ModelAndView mv = new ModelAndView("auditoria");
		List<AuditoriaDeSeguranca> audi = new ArrayList<>();
		int countDados = this.auditoriaDeSegurancas.size();
		Integer[] countPaginas = {(page+1)>=(countDados/100) ? null: page+1,
				(page+2)>=(countDados/100) ? null: page+2 ,
				(page+3)>=(countDados/100) ? null: page+3};
		int pagina = (page == 1) ? 0: (page*100)-100;
		for (int i = pagina; i<=((countPaginas[0] == null)?countDados:page*100);i++) {
			if(i == this.auditoriaDeSegurancas.size()) break;
			audi.add(this.auditoriaDeSegurancas.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countAud());
		mv.addObject("page", countPaginas);
		return mv;
	}

	@GetMapping("/relatorio/auditoria/pesquisa/{modulo}")
	public ModelAndView pesquisaAuditoria(@PathVariable("modulo") String modulo){
		this.audiPesquisa = new ArrayList<>();
		String pesquisa = modulo.replace("-", " ");
		Collator collator = Collator.getInstance(new Locale("pt","BR"));
		collator.setStrength(Collator.PRIMARY);
		for (int i=0; i< this.auditoriaDeSegurancas.size();i++){
			if (collator.compare(pesquisa, this.auditoriaDeSegurancas.get(i).getModulo()) == 0){
				System.out.println(this.auditoriaDeSegurancas.get(i));
				this.audiPesquisa.add(this.auditoriaDeSegurancas.get(i));
			}
		}
		return new ModelAndView("redirect:/relatorio/auditoria/"+modulo+"/1");
	}

	@GetMapping("/relatorio/auditoria/{modulo}/{page}")
	public ModelAndView auditoriaPagePesquisa(@PathVariable("page") int page,
									  @PathVariable("modulo") String modulo){
		ModelAndView mv = new ModelAndView("auditoria");
		List<AuditoriaDeSeguranca> audi = new ArrayList<>();
		int countDados = this.audiPesquisa.size();
		Integer[] countPaginas = {(page+1)>=(countDados/100) ? null: page+1,
				(page+2)>=(countDados/100) ? null: page+2 ,
				(page+3)>=(countDados/100) ? null: page+3};
		int pagina = (page == 1) ? 0: (page*100)-100;
		for (int i = pagina; i<=((countPaginas[0] == null)?countDados:page*100);i++) {
			if(i == countDados) break;
			audi.add(this.audiPesquisa.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countAud());
		mv.addObject("page", countPaginas);
		return mv;
	}

	@GetMapping("/relatorio/websites")
	public ModelAndView website(){
		ModelAndView mv = new ModelAndView("webbloqueados");
		List<WebSitesBloqueadosModel> audi = new ArrayList<>();
		for (int i =0; i<20;i++) {
			audi.add(this.webSitesBloqueadosModels.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countRazaoBloqueio());
		return mv;
	}

	@GetMapping("/relatorio/websites/{page}")
	public ModelAndView websitesPage(@PathVariable("page") int page){
		ModelAndView mv = new ModelAndView("webbloqueados");
		List<WebSitesBloqueadosModel> audi = new ArrayList<>();
		int countDados = this.webSitesBloqueadosModels.size();
		Integer[] countPaginas = {(page+1)>=(countDados/100) ? null: page+1,
				(page+2)>=(countDados/100) ? null: page+2 ,
				(page+3)>=(countDados/100) ? null: page+3};
		int pagina = (page == 1) ? 0: (page*100)-100;
		for (int i = pagina; i<=((countPaginas[0] == null)?countDados:page*100);i++) {
			if(i == this.webSitesBloqueadosModels.size()) break;
			audi.add(this.webSitesBloqueadosModels.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countRazaoBloqueio());
		mv.addObject("page", countPaginas);
		return mv;
	}

	@GetMapping("/relatorio/websites/pesquisa/{modulo}")
	public ModelAndView pesquisaWebBloqueados(@PathVariable("modulo") String modulo){
		this.webBloPesquisa = new ArrayList<>();
		String pesquisa = modulo.replace("-", " ");
		Collator collator = Collator.getInstance(new Locale("pt","BR"));
		collator.setStrength(Collator.PRIMARY);
		for (int i=0; i< this.webSitesBloqueadosModels.size();i++){
			String texto =this.webSitesBloqueadosModels.get(i).getReasaoBloqueio().replace(",","");
			texto = texto.replace(".", "");
			if (collator.compare(pesquisa, texto) == 0){

				this.webBloPesquisa.add(this.webSitesBloqueadosModels.get(i));
			}
			if (modulo.contains("outros")){
				if (this.relatorioService.outrosRazaoBloqueio(this.webSitesBloqueadosModels.get(i)) != null)
					this.webBloPesquisa.add(this.relatorioService.outrosRazaoBloqueio(this.webSitesBloqueadosModels.get(i)));
			}
		}
		return new ModelAndView("redirect:/relatorio/websites/"+modulo+"/1");
	}

	@GetMapping("/relatorio/websites/{modulo}/{page}")
	public ModelAndView webPagePesquisa(@PathVariable("page") int page,
											  @PathVariable("modulo") String modulo){
		ModelAndView mv = new ModelAndView("webbloqueados");
		List<WebSitesBloqueadosModel> audi = new ArrayList<>();
		int countDados = this.webBloPesquisa.size();
		Integer[] countPaginas = {(page+1)>=(countDados/100) ? null: page+1,
				(page+2)>=(countDados/100) ? null: page+2 ,
				(page+3)>=(countDados/100) ? null: page+3};
		int pagina = (page == 1) ? 0: (page*100)-100;
		for (int i = pagina; i<=((countPaginas[0] == null)?countDados:page*100);i++) {
			if(i == countDados) break;
			audi.add(this.webBloPesquisa.get(i));
			System.err.println(this.webBloPesquisa.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("auditoria", this.relatorioService.countRazaoBloqueio());
		mv.addObject("page", countPaginas);
		return mv;
	}

	@GetMapping("/relatorio/incidentes")
	public ModelAndView incidentes(){
		ModelAndView mv = new ModelAndView("incidente");
		List<IncidentesRedeModel> audi = new ArrayList<>();
		int cont = Math.min(this.incidentesRedeModels.size(), 100);
		for (int i =0; i<cont;i++) {
			audi.add(this.incidentesRedeModels.get(i));
		}
		mv.addObject("relatorios", audi);
		return mv;
	}

	@GetMapping("/relatorio/incidentes/{page}")
	public ModelAndView incidentesRede(@PathVariable("page") int page){
		ModelAndView mv = new ModelAndView("incidentes");
		List<IncidentesRedeModel> audi = new ArrayList<>();
		int countDados = this.incidentesRedeModels.size();
		Integer[] countPaginas = {(page+1)>=(countDados/100) ? null: page+1 ,
				(page+2)>=(countDados/100) ? null: page+2 ,
				(page+3)>=(countDados/100) ? null: page+3};
		int pagina = (page == 1) ? 0: (page*100)-100;
		for (int i = pagina; i<=((countPaginas[0] == null)?countDados:page*100);i++) {
			if(i == this.incidentesRedeModels.size()) break;
			audi.add(this.incidentesRedeModels.get(i));
		}
		mv.addObject("relatorios", audi);
		mv.addObject("page", countPaginas);
		return mv;
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
