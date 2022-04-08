package br.com.mariojp.condominio.controllers;

import java.io.IOException;

import org.apache.catalina.servlets.WebdavServlet;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormularioController extends HttpServlet{

		private static final long serialVersionUID = 77777777777777L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			
			Usuario u = new Usuario();
			UsuarioDAO dao = new UsuarioDAO();
			
			try {
				if (login != "" && senha != "") {
					u.setLogin(login);
					u.setSenha(senha);
					
					dao.save(u);
					
					resp.sendRedirect("/lista");
				}
			} catch (Exception e) {
				resp.sendRedirect("/");
			}
			
			
			
}
}
