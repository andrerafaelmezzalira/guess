package guess.servlet;

import guess.Node;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		config.getServletContext().setAttribute("base", new Node());
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Node base = (Node) request.getSession().getServletContext()
				.getAttribute("base");

		Node node = base.startNode();

		String nodeJson = new Gson().toJson(node);

		request.getSession().setAttribute("node", nodeJson);

		request.getRequestDispatcher("/question.jsp")
				.forward(request, response);
	}
}
