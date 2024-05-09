package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessClasses.DataCliente;
import model.Cliente;
import model.Propiedad;

@WebServlet("/listarPropiedades")
public class listarPropiedades extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listarPropiedades() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
		request.getParameter("nombre");
		
		Cliente cActual = new Cliente();
		cActual = DataCliente.getOne(idCliente);
		List<Propiedad> listPropiedades = cActual.getMis_propiedades();
		
		if (listPropiedades != null) {
			request.setAttribute("listPropiedades", listPropiedades);
			request.getRequestDispatcher("webapp/listarPropiedadesCliente.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("webapp/errorSolicitud.jsp").forward(request, response);
		}
	}
}
