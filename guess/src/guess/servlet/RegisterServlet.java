package guess.servlet;

import guess.Node;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Node base = (Node) request.getSession().getServletContext()
				.getAttribute("base");

		String inputJsonNode = (String) request.getSession().getAttribute(
				"node");

		Node node = new Gson().fromJson(inputJsonNode, Node.class);

		String typeAnimal = request.getParameter("typeAnimal");
		String nameAnimal = request.getParameter("nameAnimal");

		base.addNode(node, typeAnimal, nameAnimal);
		base.restartNode();

		request.getSession().removeAttribute("node");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
}
