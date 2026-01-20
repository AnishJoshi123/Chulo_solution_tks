package Test_case;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class Normalize_phone_method_Test{


    /*Here below 3 Valid test cases of normalize phone method
     */
    @Test public void testValidPhoneNumbers() {
        assertEquals(PhoneUtil.normalizePhone("9812345678"), "+9779812345678");
        assertEquals(PhoneUtil.normalizePhone("+9779812345678"), "+9779812345678");
        assertEquals(PhoneUtil.normalizePhone("09812345678"), "+9779812345678");
    }



    // 3 Invalid testcases
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidPhoneLetters() {
        PhoneUtil.normalizePhone("98abc56789");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTooShort() {
        PhoneUtil.normalizePhone("12345");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidEmpty() {
        PhoneUtil.normalizePhone("");
    }



    // 2 Edge cases
    @Test public void testEdgeCaseFormatting() {
        assertEquals(PhoneUtil.normalizePhone("98-123 45678"), "+9779812345678");
    }

    @Test(expectedExceptions = IllegalArgumentException.class) public void testEdgeCaseTooLong() {
        PhoneUtil.normalizePhone("9812345678123");
    }
}
