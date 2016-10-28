package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa{
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
//		req.getSession().removeAttribute("usuarioLogado");
////		req.getSession().invalidate();
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
//		dispatcher.forward(req, resp);		
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getSession().getAttribute("usuarioLogado")==null){
			req.getSession().removeAttribute("usuarioLogado");
			return "/WEB-INF/paginas/logout.html";			
		}
		Usuario deslogado = (Usuario) req.getSession().getAttribute("usuarioLogado");
		req.setAttribute("deslog", deslogado);		
		req.getSession().removeAttribute("usuarioLogado");
//		Cookie cookie = new Cookie("usuarioDeslogado", deslogado.getEmail());
//		resp.addCookie(cookie); não consegui pegar o cookie na jsp
		return "/WEB-INF/paginas/logout.jsp";
	}

}
