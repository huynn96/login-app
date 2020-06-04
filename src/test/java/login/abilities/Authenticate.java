package login.abilities;

import net.serenitybdd.screenplay.Ability;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Authenticate implements Ability {
    private String email;
    private String password;

    public Authenticate(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static Authenticate LoadTestData(String actorName) {
        try {
            Reader dataReader = new FileReader("src/test/resources/TestData/user." + actorName.toLowerCase() + ".properties");
            Properties dataProperties = new Properties();
            dataProperties.load(dataReader);

            return new Authenticate(
                    dataProperties.getProperty("email", ""),
                    dataProperties.getProperty("password", "")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
