package pe.gafahsoft.colegio.dao;

import java.util.List;

import pe.gafahsoft.colegio.bean.MatriculadoBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Matricula;


public interface MatriculaBeanDAOLocal {
	public List<Matricula> listar(Matricula parametros);

	public int grabar(Matricula parametros);

	public List<MatriculadoBean> listarMatriculados(Alumno parametros);

	public List<MatriculadoBean> listarAlumnos(Alumno parametro);
}
