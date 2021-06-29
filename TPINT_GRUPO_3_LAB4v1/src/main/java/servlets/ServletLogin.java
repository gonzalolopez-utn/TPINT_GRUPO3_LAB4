package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Usuario;
import dominio.UsuarioDao;
import interfaz.IUsuarioDao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnIngresar") != null){
            Usuario usuario = new Usuario();
            usuario.setUsuario(request.getParameter("txtNombreUsuario"));
            usuario.setContra(request.getParameter("txtContra"));

            IUsuarioDao usuarioDao = new UsuarioDao();
            try {
				if(usuarioDao.validate(usuario).equals("1")){
				    //Requestdistpacher
				    RequestDispatcher rd = request.getRequestDispatcher("/PrincipalAdministrador.jsp");
				    rd.forward(request, response);
				}else if (usuarioDao.validate(usuario).equals("2")){
				    RequestDispatcher rd = request.getRequestDispatcher("/PrincipalUsuario.jsp");
				    rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("/ErrorLogin.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        }
	}

}
