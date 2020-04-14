package jenny.tutorial.unitesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", mock.get(0));
        assertEquals("in28minutes", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(0);
        verify(mock, atLeastOnce()).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        // System Under Test (SUT)
        mock.add("SomeString");

        // Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        // System Under Test (SUT)
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, atLeastOnce()).add(captor.capture());

        List<String> allCaptorValues = captor.getAllValues();
        assertEquals("SomeString1", allCaptorValues.get(0));
        assertEquals("SomeString2", allCaptorValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // returns null
        System.out.println(arrayListMock.size()); // returns 0
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size()); // still returns 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // returns 5
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test0");
        System.out.println(arrayListSpy.get(0)); // returns test0
        System.out.println(arrayListSpy.size()); // returns 1
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size()); // still returns 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // returns 5
        arrayListSpy.add("test4");
        System.out.println(arrayListSpy.size()); // STILL returns 5
        verify(arrayListSpy).add("test4");
    }
}
