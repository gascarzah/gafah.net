package pe.gafahsoft.colegio.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;

import pe.gafahsoft.colegio.modelo.Usuario;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.UWebUtil;

@ManagedBean
@SessionScoped
public class UsuarioBean extends GeneralBean<Usuario>{


	private static final long serialVersionUID = -639231058020780470L;
	private Usuario usuario = new Usuario();
	
	
	public UsuarioBean() {
	
	}
	
	public void login(){
		System.out.println("aqui");
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		try {
			
//			System.out.println("login "+usuario.getLogin());
//			System.out.println("clave "+usuario.getClave());
//			usuario.setLogin("juan"); 
//			usuario.setClave("123");
			usuario.setEstado(Constantes.ACTIVO);
			usuario.setOpcion(Constantes.LOGIN);;
			List<Usuario> listUsuario = getGeneraServiceRemote().listar(usuario);
			
			if(CollectionUtils.isNotEmpty(listUsuario)){
				System.out.println("entro a login");
//				session.setAttribute("usuario", listUsuario.get(0));
				UWebUtil.establecerObjetoSession("usuario",listUsuario.get(0));
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
//				return "index";
			}else{
				System.out.println("no entro a login");
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
//				return "login";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return null;
	}

	@Override
	public void agregar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grabar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
