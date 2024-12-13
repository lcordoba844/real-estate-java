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

import dataAccessClasses.DataCliente;
import dataAccessClasses.DataPropiedad;
import model.Cliente;
import model.Propiedad;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarClientes(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
	        case "altaCliente":
	        	altaCliente(request, response);
	        	
	            break;
	            
	        case "derivarAUpdJsp" : 
	        	derivarAUpdJsp( request, response);
	        	break;
	        	
	        case "modificarCliente":	        	
	        	modificarCliente(request, response);
	            break;
	            
	       case "confirmarEliminacion":
	            confirmarEliminacion(request, response);
	            break;
	
	        case "eliminarCliente":
	            	eliminarCliente(request, response);
	            break;
	
	        default:
	            response.sendRedirect("errorSolicitud.jsp");
	            break;
	    }
	}
	private void altaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String mail = request.getParameter("mail");
        Cliente nuevoCliente = new Cliente(nombre, apellido, telefono, mail);
        try {
            DataCliente.newCliente(nuevoCliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);     
	}
	
	private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente clienteActualizado = new Cliente();
        clienteActualizado.setId_cliente(Integer.parseInt(request.getParameter("idCliente")));
        clienteActualizado.setNombre(request.getParameter("nombre"));
        clienteActualizado.setApellido(request.getParameter("apellido"));
        clienteActualizado.setTelefono(request.getParameter("telefono"));
        clienteActualizado.setMail(request.getParameter("mail"));
        DataCliente.update(clienteActualizado);
        doGet(request, response);
	}
	
	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clienteId = Integer.parseInt(request.getParameter("idCliente"));
		List<Propiedad> propiedadesCliente = DataPropiedad.getPropiedadesForCliente(clienteId);
		if (propiedadesCliente == null) {
			boolean eliminado = DataCliente.delete(clienteId);
			if (eliminado) {
				System.out.println("Cliente eliminado exitosamente.");
			} 
		} else {
            System.out.println("El cliente tiene propiedades a su nombre.");
            request.setAttribute("errorMessage", "El cliente tiene propiedades a su nombre.");
        }
        doGet(request, response);
	}
	
	private void derivarAUpdJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		Cliente clienteAModificar = DataCliente.getOne(idCliente);
		request.setAttribute("clienteAModificar", clienteAModificar);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formUpdCliente.jsp");
		dispatcher.forward(request, response);
	}
	
	private void confirmarEliminacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        request.setAttribute("idCliente", idCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmarEliminacion.jsp");
        dispatcher.forward(request, response);
	}
	
	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> listClientes = DataCliente.getAll();
		if (listClientes != null) {
			request.setAttribute("listaClientes", listClientes);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("listadoClientes.jsp");
			dispatcher1.forward(request, response);
		}
		else {
			request.getRequestDispatcher("errorSolicitud.jsp").forward(request, response);
		}
	}

}

