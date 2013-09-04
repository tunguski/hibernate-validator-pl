package com.tunguski.validator;

import static java.util.Arrays.*;

import java.util.List;


/**
 * Walidatory NIP, PESEL, REGON, PWZ.
 * @author marian <mariuszs@gmail.com>
 * @author Klaudiusz Kulik <kulikk(at)monstrum.org>
 * @author tunguski <tunguskii@gmail.com>
 */
public class Validators {


	public static boolean isValidREGON(String regon) {
	  if (regon.length() == 9) {
	    return tenToZero(countSummary(regon,
	        asList(8, 9, 2, 3, 4, 5, 6, 7)) % 11) == control(regon);
	  } else if (regon.length() == 14) {
      return tenToZero(countSummary(regon,
          asList(2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8)) % 11) == control(regon);
	  } else {
	    return false;
	  }
	}


	public static boolean isValidPESEL(String pesel) {
    Integer sum = 10 - countSummary(pesel, asList(1, 3, 7, 9, 1, 3, 7, 9, 1, 3)) % 10;
    return tenToZero(sum) == control(pesel);
	}


	public static boolean isValidNIP(String nip) {
    return elevenValidation(nip, asList(6, 5, 7, 2, 3, 4, 5, 6, 7));
	}


  public static boolean isValidPWZ(String pwz) {
    Integer sum = countSummary(pwz.substring(1) + "X", asList(1, 2, 3, 4, 5, 6));
    return sum % 11 == Integer.valueOf("" + pwz.charAt(0));
  }


  protected static Integer tenToZero(Integer sum) {
    return sum == 10 ? 0 : sum;
  }


  protected static boolean elevenValidation(String number, List<Integer> weights) {
    return countSummary(number, weights) % 11 == control(number);
  }


  protected static Integer control(String number) {
	  return Integer.valueOf(number.substring(number.length() - 1));
	}


  protected static Integer countSummary(String number, List<Integer> weights) {
    int length = weights.size();
    if (number.length() != length + 1) {
      return null;
    }

    int sum = 0;

    for (int i = 0; i < length; i++) {
      sum += Integer.valueOf("" + number.charAt(i)) * weights.get(i);
    }

    return sum;
  }
}

