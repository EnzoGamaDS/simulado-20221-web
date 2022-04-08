package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		UsuarioDAO u = new UsuarioDAO();
		UsuarioListController c = new UsuarioListController();
		Usuario us = u.findByLogin(login);
		
		try {
			if (us.getLogin().equals(login) && us.getSenha().equals(senha)) {
				c.doGet(req, resp);
			}

		} catch (Exception e) {
			resp.sendRedirect("/login.jsp");
		}
	}

}
