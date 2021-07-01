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
import dominio.Usuario;

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
		boolean creado=false;
		if(request.getParameter("aceptarCliente")!=null)
		{
			Cliente c = new Cliente();
			Usuario usuario = new Usuario();
			c.setDni(request.getParameter("txtDNI"));
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
			usuario.setUsuario(request.getParameter("txtUsuario"));
			usuario.setContra(request.getParameter("txtPass"));
			usuario.setDni(c.getDni());
			usuario.setEstado(1);
			c.setUsuario(usuario);
			ClienteDaoImpl cd = new ClienteDaoImpl();
			if(cd.insert(c)){
				if(cd.insertUsuario(c)){
					creado = true;
				}
			};
		}
		request.setAttribute("Creado", creado);
		RequestDispatcher rd = request.getRequestDispatcher("/AMBClientes.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("validarCliente")!=null){
		 	String dniValidar = request.getParameter("txtVerificarDni");
		 	ClienteDaoImpl clienteDao = new ClienteDaoImpl();
		 	Cliente cliente = clienteDao.getClientePorDni(dniValidar);
			 request.setAttribute("ClienteValidado", cliente);
			 RequestDispatcher rd = request.getRequestDispatcher("/AMBClientes.jsp");
			 rd.forward(request, response);
		 }
		 if(request.getParameter("btnModificarCliente")!=null){
			 Cliente c = new Cliente();
			 c.setDni(request.getParameter("txtDNI"));
			 c.setCuil(request.getParameter("txtCuil"));
			 c.setNombre(request.getParameter("txtNombreCli"));
			 c.setApellido(request.getParameter("txtApellido"));
			 c.setSexo(request.getParameter("rbtnSexo"));
			 c.setNacionalidad(request.getParameter("txtNacionalidad"));
			 c.setFechaNac(request.getParameter("txtfecNac"));
			 c.setDireccion(request.getParameter("txtDireccion"));
			 c.setLocalidad(request.getParameter("txtLocalidad"));
			 c.setProvincia(request.getParameter("Provincia"));
			 c.setCorreoElectronico(request.getParameter("txtCorreo"));
			 c.setTelefono(request.getParameter("txtTelefono"));
			 ClienteDaoImpl clienteDao = new ClienteDaoImpl();
			 Boolean clienteModificado = clienteDao.modify(c);
			 request.setAttribute("ClienteModificado", clienteModificado);
			 RequestDispatcher rd = request.getRequestDispatcher("/AMBClientes.jsp");
			 rd.forward(request, response);
		}
	}

}
