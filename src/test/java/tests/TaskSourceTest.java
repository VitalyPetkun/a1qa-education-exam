package tests;

import models.Token;
import models.Variant;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonConverter;
import utils.PropertiesManager;
import utils.SmartLogger;
import utils.api.APIUtils;
import utils.api.Response;

import static services.EndPointsApi.*;
import static services.TestDataVariables.*;

public class TaskSourceTest extends BaseTest {

    private final int variantValue = Integer.parseInt(PropertiesManager.getTestDataValue(VARIANT.getVariable()));
    private final Variant variant = new Variant(variantValue);

    private Response response;
    private Token token;

    @Test
    public void addTest() {
        SmartLogger.logStep(1, "Get token");
        response = APIUtils.doPost(TOKEN_GET.getPoint(), JsonConverter.getString(variant));
        token = JsonConverter.getObject(JsonConverter.getString(response.getBody()),Token.class);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Wrong status code returned");
        Assert.assertNotNull(token.getValue(), "Token is null");

        SmartLogger.logStep(2, "Authorization");
    }
}
