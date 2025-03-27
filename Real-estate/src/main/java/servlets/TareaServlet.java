package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dataAccessClasses.DataPropiedad;
import dataAccessClasses.DataTarea;
import model.Propiedad;
import model.Tarea;
import model.Tarea.EstadoTarea;

@WebServlet("/TareaServlet")
public class TareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TareaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarTareas(request, response);
	        	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		
		case "asignarTarea" :
			asignarTarea(request, response);
		break;
		
//		case "modificarTarea" :
//					String descripcionS = request.getParameter("descripcion");
//					request.getParameter("estado");
//					boolean pagadoCheck = request.getParameter("pagado") != null;
//					Tarea tareaModificada = Tarea(descripcionS, estado, importe, pagadoCheck, fecha_asignacion, fecha_pago, DataPropiedad.getOne(idPropiedad));
//					DataTarea.updateTarea(tareaModificada, tareaModificada);
//			break;		
		
		case "completarTarea" :
			break;
		}
	}
	
	private void listarTareas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPropiedad = request.getParameter("idPropiedad");	               
		int idProp = Integer.parseInt(idPropiedad);
		List<Tarea> listTareas = DataTarea.getManyTareas(idProp);
		request.setAttribute("listaTareas", listTareas);
		request.setAttribute("idPropiedad", idPropiedad);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarTareas.jsp");
		dispatcher.forward(request, response);
	}
	private void listarTareasForPropiedad(HttpServletRequest request, HttpServletResponse response, int idPropiedad) throws ServletException, IOException {	               
		List<Tarea> listTareas = DataTarea.getManyTareas(idPropiedad);
		request.setAttribute("listaTareas", listTareas);
		request.setAttribute("idPropiedad", idPropiedad);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarTareas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void asignarTarea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPropiedad = Integer.parseInt((String) request.getParameter("idPropiedad"));
		Tarea.EstadoTarea estado = null;
		Date fecha_asignacion = null;
		java.sql.Date fechaSql = null;
		Propiedad prop = DataPropiedad.getOne(idPropiedad);
		String descripcion = (String) request.getParameter("descripcion");
		boolean pagado = request.getParameter("pagado") != null;
		 if (request.getParameter("estado").equalsIgnoreCase("PENDIENTE")) {
			 estado = Tarea.EstadoTarea.PENDIENTE;
		 } else if (request.getParameter("estado").equalsIgnoreCase("REALIZADO")) {
			 estado = Tarea.EstadoTarea.REALIZADO;
		 }
		double importe = Double.parseDouble((String) request.getParameter("importe"));
		String fechaAsigString = request.getParameter("fecha_asignacion");
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha_asignacionI = inputFormat.parse(fechaAsigString);
			String fecha_asignacionString = outputFormat.format(fecha_asignacionI);
			fecha_asignacion = outputFormat.parse(fecha_asignacionString);
			fechaSql = new java.sql.Date(fecha_asignacion.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Tarea tareaNueva = new Tarea(descripcion, estado, importe, pagado, fechaSql, null,  prop);
		try {
			DataTarea.addNewTarea(tareaNueva);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("idPropiedad", idPropiedad);
		listarTareasForPropiedad(request, response, idPropiedad);
	}
}
