package nicebank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AtmServer {

    private final Server server;

    public AtmServer(int port, CashSlot cashSlot, Account account) {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new AtmServlet()), "/");
        context.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot,account)),"/withdraw");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception{
        server.stop();
        System.out.println("Server shutdown");
    }

    public static void main(String[] args) throws Exception{
        //new AtmServer(8887).start();
    }
}