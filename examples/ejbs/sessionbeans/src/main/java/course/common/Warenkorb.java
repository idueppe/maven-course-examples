package course.common;

import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface Warenkorb {

	public void kaufen(String produkt, int anzahl);

	public Map<String, Integer> getInhalt();

	public void abmelden();
}
