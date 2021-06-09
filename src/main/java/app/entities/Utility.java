package app.entities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
    public static String getCountryByIp(String ip) throws IOException {
        URL url = new URL("https://api.iplocation.net/?ip=" + ip);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String obj = in.readLine();
        in.close();
        con.disconnect();
        JsonObject jsonObject = new JsonParser().parse(obj).getAsJsonObject();
        return jsonObject.get("country_name").getAsString();
    }

    public static Connection connectToDB() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        return conn;
    }
}
