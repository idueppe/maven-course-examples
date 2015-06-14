package course.jaxws.fraction;


public interface Fraction {
	/** Wert setzen mit Zaehler und Nenner */
	public void setValue(long z, long n);

	/** Aktuellen Wert abfragen */
	public double getValue();

	/** Addition einer Ganzzahl */
	public void add(long summand);

	/** Multiplikation einer Ganzzahl */
	public void mult(long factor);

	/** Pruefung, ob der Bruch 0 ist */
	public boolean isNull();
}
