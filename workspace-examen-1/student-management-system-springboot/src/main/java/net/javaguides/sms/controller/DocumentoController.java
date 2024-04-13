package net.javaguides.sms.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import net.javaguides.sms.entity.Documento;
import net.javaguides.sms.service.DocumentoService;

@Controller
@AllArgsConstructor

public class DocumentoController {
	private DocumentoService documentoService;
//static	Long res = 0l;
	// handler method to handle list students and return mode and view
	@GetMapping("/documentos")
	public String listDocumentos(Model model) {
//		System.out.println("xxxxx"+documentoService.getAllDocumentos().size());
		
		List<Documento> documentos = documentoService.getAllDocumentos();
		
		System.out.println(documentos);
//		System.out.println(res);
		model.addAttribute("documentos", documentos);
		return "documentos";
	}

	@GetMapping("/documentos/new")
	public String createDocumentoForm(Model model) {

		// create student object to hold student form data
		Documento documento = new Documento();
		model.addAttribute("documento", documento);
		return "create_documento";

	}

	@PostMapping("/documentos")
	public String saveDocumento(@ModelAttribute("documento") Documento documento) {
		//@Query("SELECT name,apellidos,fechaturno,medico FROM persona c INNER JOIN turnos c1 ON c.id = c1.idturno")
		documentoService.saveDocumento(documento);
		return "redirect:/documentos";
	}

	@GetMapping("/documentos/edit/{id}")
	public String editDocumentoForm(@PathVariable Long id, Model model) {
		model.addAttribute("documento", documentoService.getDocumentoById(id));
		return "edit_documento";
	}

	@PostMapping("/documentos/{id}")
	public String updateDocumento(@PathVariable Long id, @ModelAttribute("documento") Documento documento, Model model) {

		// get student from database by id
		Documento existingDocumento = documentoService.getDocumentoById(id);
		existingDocumento.setId(id);
		existingDocumento.setFechaRegistro(LocalDate.now());
		existingDocumento.setDescripcion(documento.getDescripcion());
		existingDocumento.setNit(documento.getNit());
		existingDocumento.setFechaRespuesta(documento.getFechaRespuesta());
		
		// save updated student object
		documentoService.updateDocumento(existingDocumento);
		return "redirect:/documentos";
	}

	// handler method to handle delete student request

	@GetMapping("/documentos/{id}")
	public String deleteDocumento(@PathVariable Long id) {
		documentoService.deleteDocumentoById(id);
		return "redirect:/documentos";
	}
}
