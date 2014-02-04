package guess.servlet;

import guess.Node;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class NoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Node base = (Node) request.getSession().getServletContext()
				.getAttribute("base");

		String inputJsonNode = (String) request.getSession().getAttribute(
				"node");

		Node node = new Gson().fromJson(inputJsonNode, Node.class);

		Node resultNode = base.findNoNode(node);

		if (resultNode == null)
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		else {
			String resultJsonNode = new Gson().toJson(resultNode);
			request.getSession().setAttribute("node", resultJsonNode);
			request.getRequestDispatcher("/question.jsp").forward(request,
					response);
		}
	}
}
