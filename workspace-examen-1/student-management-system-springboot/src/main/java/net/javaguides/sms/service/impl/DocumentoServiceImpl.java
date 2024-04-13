package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.sms.entity.Documento;
import net.javaguides.sms.repository.DocumentoRepository;
import net.javaguides.sms.service.DocumentoService;

@Service
@AllArgsConstructor
public class DocumentoServiceImpl  implements DocumentoService{

	private DocumentoRepository documentoRepository;
	

	@Override
	public List<Documento> getAllDocumentos() {
		return documentoRepository.findAll();
	}

	@Override
	public Documento saveDocumento(Documento documento) {
		return documentoRepository.save(documento);
	}

	@Override
	public Documento getDocumentoById(Long id) {
		return documentoRepository.findById(id).get();
	}

	@Override
	public Documento updateDocumento(Documento documento) {
		return documentoRepository.save(documento);
	}

	@Override
	public void deleteDocumentoById(Long id) {
		documentoRepository.deleteById(id);	
	}
}
