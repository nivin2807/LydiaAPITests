package Lydia.LydiaAPI.tests;


import Lydia.LydiaAPI.APIClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ExtentManager;

public class GetUser extends ExtentManager {

    APIClient client = new APIClient();

    @Test
    public void testGetUser() {

        Response response = client.get("/users/2");

        test.info("Status Code: " + response.getStatusCode());
        test.info("Response: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
        
        test.pass("GET /users/2 validated successfully.");
    }
}
