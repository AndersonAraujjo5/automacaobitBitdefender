package com.pontodata.relatorios;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pontodata.relatorios.Models.AuditoriaSegurancaModel;
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

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	private final RelatorioService relatorioService;
	@Autowired
	public FileUploadController(StorageService storageService, RelatorioService relatorioService) {
		this.storageService = storageService;
		this.relatorioService = relatorioService;
	}

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
						path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
								"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("auditoria") MultipartFile auditoria,
								   @RequestParam("incidenteRede") MultipartFile incidenteRede,
								   @RequestParam("webSites") MultipartFile webSites,
								   RedirectAttributes redirectAttributes) {

		storageService.store(auditoria, "auditoria-de-seguranca");
		storageService.store(incidenteRede, "incidente-de-rede");
		storageService.store(webSites, "web-sites-bloquados");


		return "redirect:/";
	}



	@GetMapping("/relatorio")
	public ModelAndView RelatorioAuditoria() throws IOException {
		ModelAndView mv = new ModelAndView("uploadForm");
		File file = new File("./upload-dir");
		File afile[] = file.listFiles();
		System.out.println();
		List<WebSitesBloqueadosModel> web = this.relatorioService.webSites(afile[afile.length-1].getName());
		int webBlockCount = web.size();
		System.out.println(webBlockCount);
		mv.addObject("qwb", webBlockCount);
		return mv;
	}


	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
