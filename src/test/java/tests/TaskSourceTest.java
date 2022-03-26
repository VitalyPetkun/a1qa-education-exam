package tests;

import models.Token;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonConverter;
import utils.PropertiesManager;
import utils.SmartLogger;
import utils.api.Response;
import utils.api.WebApiUtils;

import static services.TestDataVariables.*;

public class TaskSourceTest extends BaseTest {

    private final String variant = PropertiesManager.getTestDataValue(VARIANT.getVariable());

    private Response response;
    private Token token;

    @Test
    public void addTest() {
        SmartLogger.logStep(1, "Get token");
        response = WebApiUtils.getToken(variant);
        token = JsonConverter.getObject(JsonConverter.getString(response.getBody()),Token.class);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Wrong status code returned");
        Assert.assertNotNull(token.getToken(), "Token is null");

        SmartLogger.logStep(2, "Authorization");
    }
}
