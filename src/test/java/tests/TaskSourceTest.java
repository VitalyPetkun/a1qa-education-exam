package tests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.EndPointsApi;
import utils.JsonConverter;
import utils.PropertiesManager;
import utils.SmartLogger;
import utils.api.APIUtils;
import utils.api.Response;

import static services.TestDataVariables.*;

public class TaskSourceTest extends BaseTest {

    private final String variant = PropertiesManager.getTestDataValue(VARIANT.getVariable());
    private String token;
    private Response response;

    @Test
    public void addTest() {
        SmartLogger.logStep(1, "Get token");
        response = APIUtils.doPost(EndPointsApi.TOKEN_GET.getPoint(), variant);
        token = JsonConverter.getString(response.getBody());
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Wrong status code returned");
        Assert.assertNotNull(token, "Token is null");

        SmartLogger.logStep(2, "Authorization");
    }
}
