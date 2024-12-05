package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ColorVoteServlet
 */
@WebServlet("/ColorVoteServlet")
public class ColorVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_vote = "WEB-INF/jsp/vote.jsp";
	private final String URL_resultServlet = "result";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ランダムなRGBカラーを生成
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		String color = String.format("#%02x%02x%02x", red, green, blue);

		// セッションスコープに現在の色を保存
		HttpSession session = request.getSession();
		session.setAttribute("currentColor", color);

		// アプリケーションスコープから色データを取得または初期化
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Map<String, Integer>> allVotes = (Map<String, Map<String, Integer>>) context.getAttribute("allVotes");
		if (allVotes == null) {
			allVotes = new HashMap<>();
		}

		// 現在の色に対する投票マップを初期化
		allVotes.putIfAbsent(color, createInitialVoteMap());
		context.setAttribute("allVotes", allVotes);

		// 投票画面にフォワード
		request.getRequestDispatcher(PATH_vote).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ユーザーが選択した色を取得
		String selectedColor = request.getParameter("color");

		// 現在の投票対象色をセッションスコープから取得
		HttpSession session = request.getSession();
		String currentColor = (String) session.getAttribute("currentColor");

		// アプリケーションスコープから全投票データを取得
		ServletContext context = getServletContext();
		@SuppressWarnings("unchecked")
		Map<String, Map<String, Integer>> allVotes = (Map<String, Map<String, Integer>>) context.getAttribute("allVotes");

		// 現在の色の投票を更新
		if (allVotes != null && currentColor != null) {
			Map<String, Integer> voteCounts = allVotes.get(currentColor);
			voteCounts.put(selectedColor, voteCounts.get(selectedColor) + 1);
		}

		// アプリケーションスコープに保存
		context.setAttribute("allVotes", allVotes);

		// ColorResultServlet にリダイレクト
		response.sendRedirect(URL_resultServlet);
	}

	private Map<String, Integer> createInitialVoteMap() {
		Map<String, Integer> initialMap = new HashMap<>();
		initialMap.put("red", 0);
		initialMap.put("blue", 0);
		initialMap.put("yellow", 0);
		return initialMap;
	}
}