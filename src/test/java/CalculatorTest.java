import com.rest.app.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator;

    @Test
    public void testMultiply(){
        calculator = new Calculator();
        Assertions.assertEquals(20,calculator.multiply(5,4));
    }

    @Test
    public void testMultiply_deferanceParamaters(){
        calculator = new Calculator();
//        Assertions.assertEquals(20,calculator.multiply(2,4));
        Assertions.assertEquals(8,calculator.multiply(2,4));
//        Assertions.assertTrue(calculator.multiply(2,4)==8);
    }

    @Test
    public void testDivide(){
        calculator=new Calculator();
        Assertions.assertEquals(calculator.devide(4,2),2);
    }
}
