package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dataAccessClasses.DataCliente;
import model.Cliente;

@WebServlet("/listarClientes")
public class listarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listarClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cliente> listClientes = DataCliente.getAll();
		if (listClientes != null) {
			request.setAttribute("listaClientes", listClientes);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("listarClientes.jsp");
			dispatcher1.forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorSolicitud.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
