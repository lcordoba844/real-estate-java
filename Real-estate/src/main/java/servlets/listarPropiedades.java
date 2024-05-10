package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessClasses.DataCliente;
import dataAccessClasses.DataPropiedad;
import model.Cliente;
import model.Propiedad;

@WebServlet("/listarPropiedades")
public class listarPropiedades extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listarPropiedades() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("holaLucas");
		List<Propiedad> listPropiedades = DataPropiedad.getAllPropiedades();
		if (listPropiedades != null) {
			request.setAttribute("listPropiedades", listPropiedades);
			request.getRequestDispatcher("listarTodasPropiedades.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorSolicitud.jsp").forward(request, response);
		}
	}
}
