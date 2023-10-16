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
    @Test
    public void test_correct_difference() {
        Bleeval bleeval = new Bleeval("2-1");
        Assertions.assertEquals(1, bleeval.evaluate());
        bleeval.setExpression("2-1-1");
        Assertions.assertEquals(0, bleeval.evaluate());
        bleeval.setExpression("1+3-2+2-2");
        Assertions.assertEquals(2, bleeval.evaluate());
        bleeval.setExpression("-1+3-2+2-2");
        Assertions.assertEquals(0, bleeval.evaluate());
        bleeval.setExpression("212-1+3-2+2-2");
        Assertions.assertEquals(212, bleeval.evaluate());
        bleeval.setExpression("-1-1-1-1");
        Assertions.assertEquals(-4, bleeval.evaluate());
    }
    @Test
    public void test_correct_multiply() {
        Bleeval bleeval = new Bleeval("2*2");
        Assertions.assertEquals(4, bleeval.evaluate());
        bleeval.setExpression("2*2+1");
        Assertions.assertEquals(5, bleeval.evaluate());
        bleeval.setExpression("1+2*2");
        Assertions.assertEquals(5, bleeval.evaluate());
        bleeval.setExpression("2+2*2");
        Assertions.assertEquals(6, bleeval.evaluate());
        bleeval.setExpression("2*2+1+2*2");
        Assertions.assertEquals(9, bleeval.evaluate());
        bleeval.setExpression("2*2+1-2*2");
        Assertions.assertEquals(1, bleeval.evaluate());
        bleeval.setExpression("-2*2+1-2*2");
        Assertions.assertEquals(-7, bleeval.evaluate());
    }
}
