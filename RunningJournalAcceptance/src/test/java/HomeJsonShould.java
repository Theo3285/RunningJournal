import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HomeJsonShould {

    @Test
    public void returnOkStatusCode() throws IOException {
        RunningJournalServer.main();
        final URL url = new URL("http://localhost:9897/");
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int reponseCode = conn.getResponseCode();
        assertThat(reponseCode, is(HTTP_OK));
    }

}
