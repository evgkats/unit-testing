package jenny.tutorial.unitesting.unittesting.business;

import jenny.tutorial.unitesting.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int[] data = someDataService.retrieveAllData();
        return calculateSum(data);
    }
}
