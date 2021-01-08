package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

//http://localhost:8088/guestbook2/gbc
@WebServlet("/gbc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 컨트롤러 테스트
		System.out.println("controller");

		// 파라미터 action값 읽기
		String action = request.getParameter("action");
		System.out.println(action);

		// action = addList
		if ("addList".equals(action)) {
			System.out.println("리스트 처리");
			// 리스트 출력처리
			GuestBookDao guestDao = new GuestBookDao();
			List<GuestBookVo> guestList = guestDao.getList();

			// 데이터전달
			request.setAttribute("gList", guestList);

			// jsp에 포워드
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addList.jsp");
			rd.forward(request, response);

		} else if ("insert".equals(action)) {
			System.out.println("리스트 저장");

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			GuestBookVo guestVo = new GuestBookVo(name, password, content);

			GuestBookDao guestDao = new GuestBookDao();
			// 저장
			guestDao.insert(guestVo);

			response.sendRedirect("/guestbook2/gbc?action=addList");
		} else if ("deleteForm".equals(action)) {
			System.out.println("리스트 삭제 폼");

			int no = Integer.parseInt(request.getParameter("no"));
			
			
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deleteForm.jsp");
			rd.forward(request, response);

		} else if ("delete".equals(action)) {
			System.out.println("삭제");

			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");

			GuestBookDao guestDao = new GuestBookDao();
			GuestBookVo guestVo = new GuestBookVo(no, password);

			guestDao.delete(guestVo);

			response.sendRedirect("/guestbook2/gbc?action=addList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
