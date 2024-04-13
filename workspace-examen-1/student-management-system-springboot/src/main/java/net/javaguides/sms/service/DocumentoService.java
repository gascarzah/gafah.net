package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Documento;

public interface DocumentoService {

	public List<Documento> getAllDocumentos();


	public Documento saveDocumento(Documento documento);

	
	public Documento getDocumentoById(Long id);

	
	public Documento updateDocumento(Documento documento);


	public void deleteDocumentoById(Long id) ;
}
