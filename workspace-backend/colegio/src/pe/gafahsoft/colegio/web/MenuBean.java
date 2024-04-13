package pe.gafahsoft.colegio.web;

import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import pe.gafahsoft.colegio.modelo.Menu;
import pe.gafahsoft.colegio.util.Constantes;

@ManagedBean
@ViewScoped
public class MenuBean extends GeneralBean<Menu>{

	private static final long serialVersionUID = -5109731824745749817L;
	
	private MenuModel menumodel = new DefaultMenuModel();
	
	public MenuBean() {
//		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
//		if(session.getAttribute("menumodel")==null){
			getConstruirMenu();
//		}
		
	}

	public void getConstruirMenu() {
		System.out.println("construye menu ");
		DefaultSubMenu menuPrincipal = null;
		
		Menu parametros = new Menu();
		parametros.setMenuId(Constantes.MENU_PADRE_ORIGEN_ID);
		parametros.setOpcion(Constantes.BUSCAR_POR_PADRE);
//		parametros.setEstado(Constantes.ACTIVO);
		List<Menu> menus = getGeneraServiceRemote().listar(parametros); //obtiene los menus principales
		
		if(!menus.isEmpty()){
			
			for (Menu menu : menus) {
//				padre = new DefaultTreeNode(bHijo, root);
				menuPrincipal = new DefaultSubMenu();
				menuPrincipal.setLabel(menu.getDescLarga());
				
				this.menumodel.addElement(menuPrincipal);
//				getSession().setAttribute("menumodel",menumodel);
				System.out.println("menu padre que entra "+ menu.getMenuId() +" desc : "+menu.getDescLarga());
				obtenerHijos(menu,menuPrincipal);
        	
			}

		}
		
		
		

	}
	
	private void obtenerHijos(Menu menu, DefaultSubMenu menuPrincipal){
//		menu.setOpcion(Constantes.BUSCAR_POR_ID_CON_PADRE);
		menu.setOpcion(Constantes.BUSCAR_POR_PADRE);
//		menu.setEstado(Constantes.ACTIVO);
		List<Menu> menus = getGeneraServiceRemote().listar(menu); //obtiene todos los menus del sub hijo
		
		
		if(!menus.isEmpty()){
			System.out.println("menu padre que entra "+ menu.getMenuId() +" desc : "+menu.getDescLarga());
			
			for(Iterator<Menu> it =  menus.iterator(); it.hasNext();){
				Menu menuHijo = it.next();
				obtenerHijos(menuHijo,menuPrincipal);
			}
		}else{ 
			DefaultMenuItem item = new DefaultMenuItem();
			item.setValue(menu.getDescLarga());
			item.setUrl(menu.getUrl());
//			item.setTitle("xxxx");
//			item.setIcon(icoOpcion);
			menuPrincipal.addElement(item);
			 
		}
			
	}

	
	public MenuModel getMenumodel() {
		return menumodel;
	}

	public void setMenumodel(MenuModel menumodel) {
		this.menumodel = menumodel;
	}

	@Override
	public void agregar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Menu parametro) {
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


	
}
