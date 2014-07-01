package com.tunguski.validator;

import java.util.List;

import static java.util.Arrays.*;


/**
 * Walidatory NIP, PESEL, REGON, PWZ.
 * @author marian <mariuszs@gmail.com>
 * @author Klaudiusz Kulik <kulikk(at)monstrum.org>
 * @author tunguski <tunguskii@gmail.com>
 */
public class Validators {


	private static final List<Integer> PWZ_WEIGHTS = asList(1, 2, 3, 4, 5, 6);
  private static final List<Integer> PESEL_WEIGHTS = asList(1, 3, 7, 9, 1, 3, 7, 9, 1, 3);
  private static final List<Integer> REGON_14__WEIGHTS = asList(2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8);
  private static final List<Integer> REGON_9_WEIGHTS = asList(8, 9, 2, 3, 4, 5, 6, 7);
  private static final List<Integer> NIP_WEIGHTS = asList(6, 5, 7, 2, 3, 4, 5, 6, 7);


  public static boolean isValidREGON(String regon) {
    if (regon == null) {
      return false;
    } else if (regon.length() == 9) {
	    return tenToZero(countSummary(regon,
	        REGON_9_WEIGHTS) % 11) == control(regon);
	  } else if (regon.length() == 14) {
      return tenToZero(countSummary(regon,
          REGON_14__WEIGHTS) % 11) == control(regon);
	  } else {
	    return false;
	  }
	}


	public static boolean isValidPESEL(String pesel) {
	  if (pesel != null && pesel.length() == PESEL_WEIGHTS.size() + 1) {
	    Integer sum = 10 - countSummary(pesel, PESEL_WEIGHTS) % 10;
	    return tenToZero(sum) == control(pesel);
	  } else {
	    return false;
	  }
	}


	public static boolean isValidNIP(String nip) {
	  if (nip != null && nip.length() == NIP_WEIGHTS.size() + 1) {
	    return elevenValidation(nip, NIP_WEIGHTS);
    } else {
      return false;
    }
	}


  /**
   * <h1>Zasady weryfikowania nr prawa wykonywania zawodu</h1>
   * <h2>Numer PWZ spełnia następujące warunki:</h2>
   * <ul>
   *   <li>jest unikalny,</li>
   *   <li>nie przenosi żadnej informacji (np. dotyczącej kolejnego numeru lekarza w rejestrze, rozróżnienia lekarz - lekarz dentysta, płci),</li>
   *   <li>składa się z siedmiu cyfr,</li>
   *   <li>zawiera cyfrę kontrolną,</li>
   *   <li>nie rozpoczyna się od cyfry 0.</li>
   * </ul>
   *
   * <h2>Struktura numeru PWZ:</h2>
   *
   * <pre>KABCDEF gdzie K - cyfra kontrolna, A do F - cyfry od 0 do 9</pre>
   *
   * <h2>Wyznaczenie cyfry kontrolnej:</h2>
   *
   * Cyfra kontrolna wyznaczana jest jako modulo 11 sumy cyfr od A do F pomnożonych przez wagi o wartościach od 1 do 6
   * <br/>
   * Np. dla cyfr od A do F, będących odpowiednio: 4, 2, 5, 7, 4, 0
   * <br/>
   * Suma: 4*1+2*2+5*3+7*4+4*5+0*6=71
   * <br/>
   * Modulo: 71 mod 11 = 5
   * <br/>
   * Cyfra kontrolna: 5
   * <br/>
   * Numer PWZ: 5425740
   */
  public static boolean isValidPWZ(String pwz) {
    if (pwz != null && pwz.length() == PWZ_WEIGHTS.size() + 1) {
      Integer sum = countSummary(pwz.substring(1) + "X", PWZ_WEIGHTS);
      return sum % 11 == Integer.valueOf("" + pwz.charAt(0));
    } else {
      return false;
    }
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

