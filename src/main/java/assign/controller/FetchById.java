package assign.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.DAO;
import assign.dto.DTO;

@WebServlet("/fetchById")
public class FetchById extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		DAO dao = new DAO();
		DTO dto = dao.fetch(id);
		if (dto == null) {
			res.getWriter().print("<h1>Incorrect ID OR ID Does Not Exits</h1>");
			req.getRequestDispatcher("Info.html").include(req, res);
		} else {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("Home.jsp").include(req, res);
		}

	}
}
