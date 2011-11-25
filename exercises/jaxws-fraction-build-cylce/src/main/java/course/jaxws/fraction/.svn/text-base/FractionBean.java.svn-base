package course.jaxws.fraction;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "BruchDienst", targetNamespace = "http://course/fraction")
public class FractionBean implements Fraction {

	private long numerator;
	private long denominator;
	
	@WebMethod(operationName="addiere")
	public void add(@WebParam(name="wert") long summand) {
		numerator = numerator + summand * denominator;
	}

	@WebMethod(operationName="aktuellerWert")
	public @WebResult(name="wert") double getValue() {
		return (double)numerator / (double) denominator;
	}

	@WebMethod(operationName="istNull")
	public @WebResult(name="isNull") boolean isNull() {
		return denominator == 0 || numerator == 0;
	}

	@WebMethod(operationName="multipliziere")
	public void mult(@WebParam(name="faktor")long factor) {
		numerator = numerator * factor;
	}

	@WebMethod(operationName="setzeWert")
	public void setValue(@WebParam(name="zaehler")long numerator, @WebParam(name="nenner")long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

}
