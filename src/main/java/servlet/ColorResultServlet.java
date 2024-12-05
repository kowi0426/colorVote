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

/**
 * Servlet implementation class ColorResultServlet
 */
@WebServlet("/ColorResultServlet")
public class ColorResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColorResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アプリケーションスコープから投票データを取得
        ServletContext context = getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, Integer> voteCounts = (Map<String, Integer>) context.getAttribute("voteCounts");

        // 投票データが存在しない場合の初期化
        if (voteCounts == null) {
            voteCounts = new HashMap<>();
            voteCounts.put("red", 0);
            voteCounts.put("blue", 0);
            voteCounts.put("yellow", 0);
            context.setAttribute("voteCounts", voteCounts);
        }

        // リクエストスコープに投票データを設定
        request.setAttribute("voteCounts", voteCounts);

        // 結果画面にフォワード
        request.getRequestDispatcher("results.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
