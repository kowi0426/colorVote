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
 * Servlet implementation class ColorVoteServlet
 */
@WebServlet("/ColorVoteServlet")
public class ColorVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColorVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ランダムなRGBカラーを生成
	    int red = (int) (Math.random() * 256);
	    int green = (int) (Math.random() * 256);
	    int blue = (int) (Math.random() * 256);

	    String color = String.format("#%02x%02x%02x", red, green, blue);
	    request.setAttribute("randomColor", color);

	    // 投票画面にフォワード
	    request.getRequestDispatcher("vote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedColor = request.getParameter("color");

        // アプリケーションスコープからデータ取得
        ServletContext context = getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, Integer> voteCounts = (Map<String, Integer>) context.getAttribute("voteCounts");
        
        if (voteCounts == null) {
            voteCounts = new HashMap<>();
            voteCounts.put("red", 0);
            voteCounts.put("blue", 0);
            voteCounts.put("yellow", 0);
        }

        // 投票数を更新
        voteCounts.put(selectedColor, voteCounts.get(selectedColor) + 1);
        context.setAttribute("voteCounts", voteCounts);

        // 結果画面へリダイレクト
        response.sendRedirect("results");
	}

}
