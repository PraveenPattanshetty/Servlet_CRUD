package assign.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.DAO;
import assign.dto.DTO;

@WebServlet("/save")
public class Save extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		DTO dto = new DTO();
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setName(req.getParameter("name"));
		dto.setId(Integer.parseInt(req.getParameter("empid")));

		DAO dao = new DAO();
		dao.insert(dto);

		res.getWriter().print("<h1>Data Added Succesfully</h1>");
		req.getRequestDispatcher("Info.html").include(req, res);
	}

}
