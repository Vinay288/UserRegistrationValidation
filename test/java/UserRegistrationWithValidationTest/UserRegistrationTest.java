
package UserRegistrationWithValidationTest;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Assert;

public class UserRegistrationTest {
    @Test 
 public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserRegistrationValidator validator=new UserRegistrationValidator();
        boolean result=validator.validateName("Vinay");
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void givenFirstName_WhenShort_ShouldReturnFalse() {
    	 UserRegistrationValidator validator=new UserRegistrationValidator();
         boolean result=validator.validateName("Vi");
         Assert.assertEquals(false, result);
    }
    
    @Test
    public void givenFirstName_WhenStartWithSpecialChars_ShouldReturnFalse() {
    	 UserRegistrationValidator validator=new UserRegistrationValidator();
         boolean result=validator.validateName("$Vinay");
         Assert.assertEquals(false, result);
    }
    
    @Test
    public void givenFirstName_WhenStartWithSmallLetter_ShouldReturnFalse() {
    	 UserRegistrationValidator validator=new UserRegistrationValidator();
         boolean result=validator.validateName("vinay");
         Assert.assertEquals(false, result);
    }
    
    @Test
    public void givenFirstName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
    	 UserRegistrationValidator validator=new UserRegistrationValidator();
         boolean result=validator.validateName("Vinayshhshsh");
         Assert.assertEquals(true, result);
    }
}
