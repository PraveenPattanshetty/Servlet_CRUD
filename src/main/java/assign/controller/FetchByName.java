package assign.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.DAO;
import assign.dto.DTO;

@WebServlet("/fetchbyname")
public class FetchByName extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		DAO dao = new DAO();
		DTO dto = dao.fetch(name);
		if (dto==null) {
			resp.getWriter().print("<h1>Incorrect Name Or Name Does Not Exists</h1>");
			req.getRequestDispatcher("Info.html").include(req, resp);
		} else {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("FetchByName.jsp").include(req, resp);
		}
		
	}
}
