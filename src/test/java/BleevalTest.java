import com.github.bloiseleo.Bleeval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BleevalTest {
    @Test
    public void test_correct_sum() {
        Bleeval bleeval = new Bleeval("1+2");
        Assertions.assertEquals(3,bleeval.evaluate());
        bleeval.setExpression("1+2+3");
        Assertions.assertEquals(6, bleeval.evaluate());
    }
}
