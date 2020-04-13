package jenny.tutorial.unitesting.unittesting.business;

import jenny.tutorial.unitesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockRefactorTest {

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Mock
    private SomeDataService dataServiceMock;

    @Test
    void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, someBusiness.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someBusiness.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1, someBusiness.calculateSumUsingDataService());
    }
}
