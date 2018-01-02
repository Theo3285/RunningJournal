

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import static java.net.HttpURLConnection.HTTP_OK;

public class RunningJournalServer {
    public static void main(String... args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(9897), 0);
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange httpExchange) throws IOException {
                String response = "";
                httpExchange.sendResponseHeaders(HTTP_OK, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.start();
    }
}
