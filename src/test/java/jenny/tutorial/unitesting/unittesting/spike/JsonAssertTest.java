package jenny.tutorial.unitesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":1, \"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
        // when strict is true, the expected must have the exact same structure, meaning that also the same fields must be present
        // spaces do not matter between the fields
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1, \"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters2() throws JSONException {
        String expectedResponse = "{id:1,name:\"Ball\",price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
        // escaping (\") is only needed when there is a space character in the value
    }
}
