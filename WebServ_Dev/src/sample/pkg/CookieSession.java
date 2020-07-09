package sample.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieSession
 * Cookie・Session例用クラス
 */
@WebServlet("/CookieSession")
public class CookieSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie cook = new Cookie("Cookie", "I'm from cookie!");
    	 cook.setMaxAge(60*60*24);
    	 response.addCookie(cook);

         HttpSession session = request.getSession();
         String sessionId = session.getId();
         session.setAttribute("SessionId", sessionId);

         String disp = "/cookiesession.jsp";
         RequestDispatcher dispatch = request.getRequestDispatcher(disp);

         dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
