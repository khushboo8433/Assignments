package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.TestService;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceTest {

    @Mock


    @InjectMocks
    TestService testService;

    @Test
    public void testFirstMethod() {
        assertEquals(1, testService.test());
    }
}
