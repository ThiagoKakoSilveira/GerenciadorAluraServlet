package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa implements Tarefa{
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
//		String nome = req.getParameter("nome");
//		Empresa empresa = new Empresa(nome);
//		new EmpresaDAO().adiciona(empresa);
//		req.setAttribute("empresa", empresa);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/novaEmpresa.jsp");
//		dispatcher.forward(req, resp);		
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		req.setAttribute("empresa", empresa);		
		return "WEB-INF/paginas/novaEmpresa.jsp";
	}

}
