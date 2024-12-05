package servlet;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ColorResultServlet
 */
@WebServlet("/result")
public class ColorResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_result = "WEB-INF/jsp/result.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// アプリケーションスコープから全投票データを取得
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Map<String, Integer>> allVotes = (Map<String, Map<String, Integer>>) context.getAttribute("allVotes");

		// リクエストスコープに設定
		request.setAttribute("allVotes", allVotes);

		// 結果画面にフォワード
		request.getRequestDispatcher(PATH_result).forward(request, response);
	}
}