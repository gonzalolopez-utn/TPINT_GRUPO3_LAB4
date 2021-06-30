package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dominio.Cliente;
import daoImpl.ClienteDaoImpl;

/**
 * Servlet implementation class ServletClientes
 */
@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletClientes() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean filas=false;
		if(request.getParameter("aceptarCliente")!=null)
		{
			Cliente c = new Cliente();
			c.setDni(Integer.valueOf(request.getParameter("txtDNI")));
			c.setCuil(request.getParameter("txtCuil"));
			c.setNombre(request.getParameter("txtNombreCli"));
			c.setApellido(request.getParameter("txtApellido"));
			c.setSexo(request.getParameter("rbtnSexo"));
			c.setNacionalidad(request.getParameter("txtNacionalidad"));
			c.setFechaNac(request.getParameter("txtfecNac"));
			c.setDireccion(request.getParameter("txtLocalidad"));
			c.setLocalidad(request.getParameter("txtLocalidad"));
			c.setProvincia(request.getParameter("Provincia"));
			c.setCorreoElectronico(request.getParameter("txtCorreo"));
			c.setTelefono(request.getParameter("txtTelefono"));
			c.setUsuario(request.getParameter("txtUsuario"));
			c.setPassword(request.getParameter("txtPass"));
			c.setTipoUsuario(1);
			ClienteDaoImpl cd = new ClienteDaoImpl();
			filas=cd.insert(c);	
		}
		request.setAttribute("Fila", filas);
		RequestDispatcher rd = request.getRequestDispatcher("/ABMClientes.jsp");
	    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
