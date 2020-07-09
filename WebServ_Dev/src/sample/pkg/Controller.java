package sample.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.test.Model;

/**
 * Servlet implementation class Controller
 * GET・POST例用クラス
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nameで複数取得
	    String[] boughtCount = request.getParameterValues("Hard");
	    //新要素設定
	    request.setAttribute("Count", boughtCount.length);
	    String disp = "/forward.jsp";
	    RequestDispatcher dispatch = request.getRequestDispatcher(disp);

	    dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doGet(request, response);

	    String name = request.getParameter("name");


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>あなたの回答</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>あなたの名前は</h1>");
        out.println("<h1>" + Model.appendMr(name) + "</h1>");
        out.println("</body>");
        out.println("</html>");
	}
}
