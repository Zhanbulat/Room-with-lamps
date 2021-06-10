package app.entities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void getCountryByIp() throws IOException {
        String ip="178.88.77.31";
        assertEquals("Kazakhstan",Utility.getCountryByIp(ip));
    }

    @Test
    void connectToDB() throws SQLException, ClassNotFoundException {
        assertNotNull(Utility.connectToDB());
    }
}