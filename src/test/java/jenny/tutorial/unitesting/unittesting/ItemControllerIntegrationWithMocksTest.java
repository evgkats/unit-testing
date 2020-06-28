package jenny.tutorial.unitesting.unittesting;

import jenny.tutorial.unitesting.unittesting.data.ItemRepository;
import jenny.tutorial.unitesting.unittesting.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationWithMocksTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemRepository repository;

    @Test
    public void contextLoadsWithMock() throws JSONException {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1, "test", 10, 10)));

        String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:1}]", response, false);
    }
}
