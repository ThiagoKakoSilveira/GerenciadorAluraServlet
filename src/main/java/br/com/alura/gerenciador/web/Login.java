package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login implements Tarefa{
		
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
//		String email = req.getParameter("email");
//		String senha = req.getParameter("senha");
//		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
//		PrintWriter writer = resp.getWriter();		
//		if(usuario == null){
//			writer.println("<html><body> Usuário inválido </body></html>");
//		} else{
//			HttpSession session = req.getSession();
//			session.setAttribute("usuarioLogado", usuario);
//			writer.println("<html><body> Usuário logado: " + usuario.getEmail() + "</body></html>");
//		}
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
//		req.setAttribute("usuario", usuario);
		if(usuario == null){
			return "WEB-INF/paginas/erroDeLogin.html";
		} else{
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
//			req.setAttribute("usuario", usuario);
//			Coloquei pq não sabia pegar da sessão mas agora estou pegando da sessão			
//			writer.println("<html><body> Usuário logado: " + usuario.getEmail() + "</body></html>");
			return "WEB-INF/paginas/login.jsp";
		}		
	}
}
