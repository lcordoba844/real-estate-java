package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataAccessClasses.DataPropiedad;
import model.Casa;
import model.Departamento;
import model.Propiedad;


@WebServlet("/PropiedadServlet")
public class PropiedadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PropiedadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
			case "listarTodasPropiedades": {
				listarTodasPropiedades(request, response);
				break;
			}
			case "listarPropiedadesCliente": {
				listarPropiedadesCliente(request, response);
				break;
			}
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		switch (action) {
			
			case "aFormAltaPropiedad": 
				aFormAltaPropiedad(request, response);
				break;
			case "aFormUpdPropiedad":
				aFormUpdPropiedad(request, response);
				break;
		
			case "altaPropiedad": {
				altaPropiedad(request, response);
	            break;
			}
			case "modificarPropiedad": 
				modificarPropiedad(request, response);
				break;
			case "eliminarPropiedad":
				eliminarPropiedad(request, response);
				break;
			default:
	            response.sendRedirect("errorSolicitud.jsp");
	            break;
		}
	}
	
	
	private void aFormUpdPropiedad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPropiedad = (String) request.getParameter("idPropiedad");
		if (idPropiedad != null) {
			int idPropiedadI = Integer.parseInt(idPropiedad);
			Propiedad propiedad = DataPropiedad.getOne(idPropiedadI);
			request.setAttribute("propiedad", propiedad);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("formUpdPropiedad.jsp");
		dispatcher.forward(request, response);
	}

	private void aFormAltaPropiedad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente;
		if (request.getParameter("idCliente") != null) {
			idCliente = Integer.parseInt(request.getParameter("idCliente"));
			request.setAttribute("idCliente", idCliente);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("formAltaPropiedad.jsp");
		dispatcher.forward(request, response);
	}

	private void listarPropiedadesCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("idCliente");
		int idCliente1 = Integer.parseInt(idCliente);
		List<Propiedad> listPropiedades = DataPropiedad.getPropiedadesForCliente(idCliente1);
		if (listPropiedades != null) {
			request.setAttribute("listaPropiedades", listPropiedades);
			request.setAttribute("idCliente", idCliente1);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("listadoTodasPropiedades.jsp");
			dispatcher1.forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorSolicitud.jsp").forward(request, response);
		}
	}
	private void listarTodasPropiedades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Propiedad> listPropiedades = DataPropiedad.getAllPropiedades();
		if (listPropiedades != null) {
			request.setAttribute("listaPropiedades", listPropiedades);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("listadoTodasPropiedades.jsp");
			dispatcher1.forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorSolicitud.jsp").forward(request, response);
		}
	}

	private void altaPropiedad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Propiedad nuevaPropiedad;
		String idPropietario = request.getParameter("idPropietario");
		String tipo = request.getParameter("tipo_propiedad");
        int cant_baños = Integer.parseInt(request.getParameter("cant_baños"));
        int cant_dormitorios = Integer.parseInt(request.getParameter("cant_dormitorios"));
        Double precio = Double.parseDouble(request.getParameter("Precio"));
        String cochera = request.getParameter("cochera");
        boolean cocheraChecked = cochera != null;
        String descripcion = request.getParameter("descripcion");
        int idPropietarioI = Integer.parseInt(idPropietario);
        String direccion = request.getParameter("direccion");
        String estado = request.getParameter("estado");
        double mts2tot_terreno = Double.parseDouble(request.getParameter("mts2tot_terreno"));
        String orientacion = request.getParameter("orientacion");
        
        if (tipo.equalsIgnoreCase("Casa")) {
        	int cant_pisos = Integer.parseInt(request.getParameter("cant_pisos"));
        	double mts2cubiertos = Double.parseDouble(request.getParameter("mts2cubiertos"));
        	nuevaPropiedad = new Casa(cant_baños, cant_dormitorios, tipo, precio,
                    cocheraChecked, descripcion, idPropietarioI, direccion, estado, cant_pisos, orientacion,
                    mts2cubiertos, mts2tot_terreno);
        } else {
        	boolean balconChecked = request.getParameter("balcon") != null;
            boolean terrazaChecked = request.getParameter("terraza") != null;
            nuevaPropiedad = new Departamento(cant_baños, cant_dormitorios, tipo,precio,cocheraChecked,descripcion,
            		idPropietarioI, direccion, estado, mts2tot_terreno, balconChecked, orientacion, terrazaChecked);
        }	            
        try {
            DataPropiedad.addNewPropiedad(nuevaPropiedad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
	}
	private void eliminarPropiedad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private void modificarPropiedad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
