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

@WebServlet("/fetchall")
public class FetchAll extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DAO dao = new DAO();
		List<DTO> list = dao.fetchAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetchAll.jsp").include(req, res);

	}
}
