package Lydia.LydiaAPI.tests;



import Lydia.LydiaAPI.APIClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExtentManager;

public class CreateUser extends ExtentManager {

     APIClient client = new APIClient();

    @Test
    public void testCreateUser() {

        var payload = """
                {
                    "username": "testuser",
        			"email": "test@gmail.Com",
        			"password": "pass123"
                }
                """;

        Response response = client.post("/register", payload);

        test.info("Status Code: " + response.getStatusCode());
        test.info("Response: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("username"), "testuser");
        Assert.assertEquals(response.jsonPath().getString("email"), "testuser@example.com");
        
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertNotNull(response.jsonPath().getString("createdAt"));

        test.pass("POST /register validated successfully.");
    }
}
