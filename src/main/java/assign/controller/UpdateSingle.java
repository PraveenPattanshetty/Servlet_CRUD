package assign.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dao.DAO;
import assign.dto.DTO;

@WebServlet("/update1")
public class UpdateSingle extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DTO dto = new DTO();
		dto.setId(Integer.parseInt(req.getParameter("id")));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setName(req.getParameter("name"));

		DAO dao = new DAO();
		dao.update(dto);

		resp.getWriter().print("<h1> Data Updated Succesfully </h1>");
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("Home.jsp").include(req, resp);

	}

}
