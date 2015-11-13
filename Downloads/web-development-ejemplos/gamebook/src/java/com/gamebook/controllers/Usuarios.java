/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamebook.controllers;

import com.gamebook.exceptions.UsuarioNoEncontrado;
import com.gamebook.model.GestorUsuario;
import com.gamebook.model.Usuario;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igui
 */
public class Usuarios extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
			
		if(usuario == null) {
			// no se seteó el usuario (lista todos los usuarios)
			Collection<Usuario> usrs = GestorUsuario.getInstance().getUsuarios();
			request.setAttribute("usuarios", usrs);
			
			request.getRequestDispatcher("/WEB-INF/usuarios/listar.jsp").
					forward(request, response);
				
		} else {
			// ve el perfil de un solo usuario
			Usuario usr;
			try {
				usr = GestorUsuario.getInstance().buscarUsuario(usuario);
			} catch(UsuarioNoEncontrado ex){
				response.sendError(404); // el usuario no existe
				request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").
						include(request, response);
				return;
			}
			
			// setea el usuario
			request.setAttribute("usuario", usr);
			
			request.getRequestDispatcher("/WEB-INF/usuarios/perfil.jsp").
					forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
