package com.tunguski.validator;

import static com.tunguski.validator.Validators.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Testy poprawności walidacji.
 * @author Marek Romanowski
 * @since Sep 4, 2013
 */
public class TestValidators {


  @Test
  public void testPeselValidation() throws Exception {
    assertFalse(isValidPESEL("82030404950"));
    assertFalse(isValidPESEL("82030404951"));
    assertFalse(isValidPESEL("82030404952"));
    assertFalse(isValidPESEL("82030404953"));
    assertFalse(isValidPESEL("82030404954"));
    assertFalse(isValidPESEL("82030404955"));
    assertFalse(isValidPESEL("82030404956"));
    assertTrue(isValidPESEL("82030404957"));
    assertFalse(isValidPESEL("82030404958"));
    assertFalse(isValidPESEL("82030404959"));
  }


  @Test
  public void testRegonValidation() throws Exception {
    assertTrue(isValidREGON("017319027"));
    assertTrue(isValidREGON("277586360"));
    assertTrue(isValidREGON("390021764"));

    assertFalse(isValidREGON("017319025"));
    assertFalse(isValidREGON("277586362"));
    assertFalse(isValidREGON("390021767"));
  }


  @Test
  public void testNipValidation() throws Exception {
    assertTrue(isValidNIP("9542381960"));
    assertTrue(isValidNIP("1132316427"));
    assertTrue(isValidNIP("6920000013"));

    assertFalse(isValidNIP("9542381967"));
    assertFalse(isValidNIP("1132316421"));
    assertFalse(isValidNIP("6920000018"));
  }


  @Test
  public void testPwzValidation() throws Exception {
    assertTrue(isValidPWZ("8473565"));
    assertTrue(isValidPWZ("9864101"));
    assertTrue(isValidPWZ("8617664"));

    assertFalse(isValidPWZ("7473565"));
    assertFalse(isValidPWZ("3864101"));
    assertFalse(isValidPWZ("1617664"));
  }
}

