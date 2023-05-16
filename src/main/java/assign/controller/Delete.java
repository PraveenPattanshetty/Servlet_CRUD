package assign.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.DAO;
import assign.dto.DTO;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		DAO dao = new DAO();
		DTO dto = dao.fetch(id);
		dao.delete(dto);

		res.getWriter().print("<h1>Data Deleted Successfully</h1>");
		req.setAttribute("list", dao.fetchAll());
		req.getRequestDispatcher("FetchAll.jsp").include(req, res);
	}
}
