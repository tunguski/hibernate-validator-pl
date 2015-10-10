package pl.matsuo.validator;

import javax.validation.ConstraintValidatorContext;


/**
 * Hibernet Validator for PWZ (Prawo Wykonywania Zawodu)
 * http://www.nil.org.pl/rejestry/centralny-rejestr-lekarzy/zasady-weryfikowania-nr-prawa-wykonywania-zawodu
 * @author tunguski <tunguskii@gmail.com>
 */
public class PWZValidator extends ValidatorBase<PWZ, String> {


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
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || Validators.isValidPWZ(removeNonDigit(value));
	}
}
