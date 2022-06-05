package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import modelo.User;
import dao.UserDAOnotas;
import modelo.Notas;
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private UserDAOnotas userDAOnotas;
	

	public void init() {
		userDAO = new UserDAO();
		userDAOnotas =new UserDAOnotas();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/notas":
			listNotas(request,response);
			break;
			case "/newnotas":
				showNewFormNotas(request,response);
				break;
			case "/insertNotas":
				insertNotas(request,response);
				break;
			case "/editNotas":
				showEditFormNotas(request, response);
				break;
			case "/updateNotas":
				
				updateNotas(request, response);
				break;
			case "/deleteNotas":
				deleteNotas(request, response);
				break;
			default:
				listUser(request, response);
				
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	private void listNotas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Notas> listNotas = userDAOnotas.selectAllNotas();
		request.setAttribute("listNotas", listNotas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-Notas.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewFormNotas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("notas-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}
	private void showEditFormNotas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
		System.out.println(id_estudiante);

		Notas existingNotas = userDAOnotas.selectNotas(id_estudiante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("notas-form.jsp");
		request.setAttribute("nota", existingNotas);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		// convertir caracteres a UTF-8 
		request.setCharacterEncoding("UTF-8"); 
		String name = request.getParameter("name"); 
		String curso =request.getParameter("curso");
		String años = request.getParameter("años");
		User newUser = new User(name, curso, años);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");

	}
	private void insertNotas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		// convertir caracteres a UTF-8 
		request.setCharacterEncoding("UTF-8"); 
		float nota1 =Float.parseFloat( request.getParameter("nota1")); 
		float nota2 =Float.parseFloat( request.getParameter("nota2")); 
		float nota3 = Float.parseFloat( request.getParameter("nota3")); 
		float promedio = (nota1+nota2+nota3)/3;
		int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
		Notas newNota = new Notas(nota1,nota2,nota3,promedio,id_estudiante);
		userDAOnotas.insertNotas(newNota);
		response.sendRedirect("notas");

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8 
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String curso = request.getParameter("curso");
		String años = request.getParameter("años");

		User book = new User(id, name, curso, años);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void updateNotas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// convertir caracteres a UTF-8 
		request.setCharacterEncoding("UTF-8");
		float nota1 =Float.parseFloat( request.getParameter("nota1")); 
		float nota2 =Float.parseFloat( request.getParameter("nota2")); 
		float nota3 = Float.parseFloat( request.getParameter("nota3")); 
		float promedio = (nota1+nota2+nota3)/3;
		int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
		
		Notas book = new Notas(nota1,nota2,nota3,promedio,id_estudiante);
		userDAOnotas.updateNotas(book);
		response.sendRedirect("notas");
		
	}

	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	}
	private void deleteNotas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id_estudiante"));
		userDAOnotas.deleteNota(id);
		response.sendRedirect("notas");

	}
}
