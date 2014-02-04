package guess.servlet;

import org.apache.jasper.servlet.JspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

	public static void main(String[] args) throws Exception {

		System.setProperty("org.apache.jasper.compiler.disablejsr199", "true");
		ServletContextHandler handler = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		handler.setContextPath("/");
		handler.setResourceBase("web");
		handler.setClassLoader(Thread.currentThread().getContextClassLoader());
		handler.addServlet(DefaultServlet.class, "/");
		ServletHolder jsp = handler.addServlet(JspServlet.class, "*.jsp");
		jsp.setInitParameter("classpath", handler.getClassPath());
		handler.addServlet(InitServlet.class, "/init");
		handler.addServlet(YesServlet.class, "/yes");
		handler.addServlet(NoServlet.class, "/no");
		handler.addServlet(RegisterServlet.class, "/register");
		handler.addServlet(EndServlet.class, "/end");
		handler.setWelcomeFiles(new String[] { "/index.jsp" });
		final Server server = new Server(8080);
		server.setHandler(handler);
		
		try {
			server.start();
			System.out.println("Server running...");
			while (true)
				server.join();
		} catch (Exception e) {
			System.out.println("Failed to start server!");
		}
	}
}
