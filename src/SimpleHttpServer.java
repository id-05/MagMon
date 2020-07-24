import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    HttpServer server;


    public void main(int WebPort, HttpServer server) throws Exception {
        this.server = server;
        server = HttpServer.create();
        server.bind(new InetSocketAddress(WebPort), 0);
        HttpContext context = server.createContext("/", new EchoHandler());
        HttpContext context2 = server.createContext("/json", new AndroidHandler());
        context.setAuthenticator(new Auth());
        server.setExecutor(null);
        server.start();
    }

    static class EchoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();
            Headers headers = exchange.getRequestHeaders();
//            for (String header : headers.keySet()) {
//                builder.append("<p>").append(header).append("=")
//                        .append(headers.getFirst(header)).append("</p>");
//            }
            builder.append("<head>");
            builder.append("<title>MAGNET MONITOR REMOTE VIEWER</title>");
                    builder.append("<style type=\"text/css\">");

                            builder.append("</style>");
                                    builder.append("</head>");
                                            builder.append("<body bgcolor = \"#ffffcc\" text = \"#000000\">");

                                                    builder.append("<p style=\"text-align: center;\">&nbsp;</p>");
            builder.append("<h1 style=\"text-align: center;\"><strong>MAGNET MONITOR REMOTE VIEWER</strong></h1>");
            builder.append("<p style=\"text-align: center;\">&nbsp;</p>");
            builder.append("<table style=\"height: 68px; border-color: black; width: 800px; margin-left: auto; margin-right: auto;\" border=\"6\" cellpadding=\"6\"><caption>&nbsp;</caption>");
            builder.append("<tbody>");
                    builder.append("<tr>");
                            builder.append("<td style=\"width: 41px; text-align: center;\">Name</td>");
            builder.append("<td style=\"width: 46px; text-align: center;\">HePress</td>");
            builder.append("<td style=\"width: 31px; text-align: center;\">He %</td>");
            builder.append("<td style=\"width: 38px; text-align: center;\">W.T. 1</td>");
            builder.append("<td style=\"width: 23px; text-align: center;\">W.F. 1</td>");
            builder.append("<td style=\"width: 32px; text-align: center;\">W.T. 2</td>");
            builder.append("<td style=\"width: 32px; text-align: center;\">W.F. 2</td>");
            builder.append("<td style=\"width: 55px; text-align: center;\">STATUS</td>");
            builder.append("<td style=\"width: 92px; text-align: center;\">LAST UPDATE</td>");
            builder.append("</tr>");

                for(int i=0;i<MainForm.MagMonList.size();i++) {
                    builder.append("<tr>");
                    builder.append("<td style=\"width: 41px; text-align: center;\">" + MainForm.MagMonList.get(i).getName() + "</td>");
                    builder.append("<td style=\"width: 46px; text-align: center;\">" + MainForm.MagMonList.get(i).getHePress() + "</td>");
                    builder.append("<td style=\"width: 31px; text-align: center;\">" + MainForm.MagMonList.get(i).getHeLevel() + "</td>");
                    builder.append("<td style=\"width: 38px; text-align: center;\">" + MainForm.MagMonList.get(i).getWaterTemp1() + "</td>");
                    builder.append("<td style=\"width: 23px; text-align: center;\">" + MainForm.MagMonList.get(i).getWaterFlow1() + "</td>");
                    builder.append("<td style=\"width: 32px; text-align: center;\">" + MainForm.MagMonList.get(i).getWaterTemp2() + "</td>");
                    builder.append("<td style=\"width: 32px; text-align: center;\">" + MainForm.MagMonList.get(i).getWaterFlow2() + "</td>");
                    builder.append("<td style=\"width: 55px; text-align: center;\">" + MainForm.MagMonList.get(i).getStatus() + "</td>");
                    builder.append("<td style=\"width: 92px; text-align: center;\">" + MainForm.MagMonList.get(i).getLastTime() + "</td>");
                    builder.append("</tr>");
                }
                    builder.append("</tbody>");
                            builder.append("</table>");
                                    builder.append("<p>&nbsp;</p>");
                                            builder.append("<p style=\"text-align: center;\">THANKS</p>");
            builder.append("<p style=\"text-align: center;\"><a href=\"http://bit-service.org\" target=\"_blank\" rel=\"noopener\">bit-service.org</a></p>");
            //builder.append("<p style=\"text-align: center;\"><a href=\"mailto:id-05@mail.ru\">id-05@mail.ru</a></p>");
            builder.append("<p style=\"text-align: center;\"><a title=\"@malinin_vs\" href=\"https://www.instagram.com/malinin_vs/\" target=\"_blank\" rel=\"noopener\">@malinin_vs</a></p>");
            builder.append("<p style=\"text-align: center;\"><input type=\"button\" onclick='window.location.reload()' value=\"RELOAD\" /></p>");
            builder.append("</body>");
            builder.append("</html>");
            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    static class AndroidHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();
            Headers headers = exchange.getRequestHeaders();
//            for (String header : headers.keySet()) {
//                builder.append("<p>").append(header).append("=")
//                        .append(headers.getFirst(header)).append("</p>");
//            }
            builder.append("<head>");
            builder.append("<title>MAGNET MONITOR REMOTE VIEWER</title>");
            builder.append("<style type=\"text/css\">");

            builder.append("</style>");
            builder.append("</head>");
            builder.append("<body bgcolor = \"#ffffcc\" text = \"#000000\">");

            builder.append("<p style=\"text-align: center;\">&nbsp;</p>");
            builder.append("<h1 style=\"text-align: center;\"><strong>SALUT</strong></h1>");
            builder.append("<p style=\"text-align: center;\">&nbsp;</p>");
            builder.append("<table style=\"height: 68px; border-color: black; width: 800px; margin-left: auto; margin-right: auto;\" border=\"6\" cellpadding=\"6\"><caption>&nbsp;</caption>");
            builder.append("<tbody>");

            builder.append("</tbody>");
            builder.append("</table>");
            builder.append("<p>&nbsp;</p>");
            builder.append("<p style=\"text-align: center;\">THANKS</p>");
            builder.append("<p style=\"text-align: center;\"><a href=\"http://bit-service.org\" target=\"_blank\" rel=\"noopener\">bit-service.org</a></p>");
            //builder.append("<p style=\"text-align: center;\"><a href=\"mailto:id-05@mail.ru\">id-05@mail.ru</a></p>");
            builder.append("<p style=\"text-align: center;\"><a title=\"@malinin_vs\" href=\"https://www.instagram.com/malinin_vs/\" target=\"_blank\" rel=\"noopener\">@malinin_vs</a></p>");
            builder.append("<p style=\"text-align: center;\"><input type=\"button\" onclick='window.location.reload()' value=\"RELOAD\" /></p>");
            builder.append("</body>");
            builder.append("</html>");
            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    static class Auth extends Authenticator {
        @Override
        public Result authenticate(HttpExchange httpExchange) {
            if ("/android".equals(httpExchange.getRequestURI().toString()))
                return new Success(new HttpPrincipal("c0nst", "realm"));
            else
                return new Success(new HttpPrincipal("c0nst", "realm"));
        }
    }

    public void stop(){

    }
}
