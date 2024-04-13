package net.gafah.microservicios.commons.microservicios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import net.gafah.microservicios.commons.microservicios.repository.IGenericRepository;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T t)  {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t)  {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar()  {		
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id)  {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id)  {
		getRepo().deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<T> listar(Pageable pageable) {
		return getRepo().findAll(pageable);
	}

}
