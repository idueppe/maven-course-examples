package course.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

import course.common.TimeServiceLocal;
import course.common.Warenkorb;
import course.common.WarenkorbLocal;

@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class WarenkorbBean implements Warenkorb, WarenkorbLocal, Serializable{

	@Resource
	private SessionContext sessionContext;
	
	@Resource(mappedName="jdbc/MySql")
	private DataSource dataSource;
	
	@EJB
	private transient TimeServiceLocal timeService;
	
	private static final long serialVersionUID = 6704963843425298392L;
	
	private Map<String, Integer> map;
	
	public WarenkorbBean() {
		map = new HashMap<String, Integer>();
		System.out.println("Hier habe ich keine Referenzen!");
		System.out.println("DataSource "+dataSource);
		System.out.println("TimeService "+timeService );
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Init WarenkorbBean");
		System.out.println("DataSource "+dataSource);
		System.out.println("TimeService "+timeService );
	}
	
	public void kaufen(String produkt, int anzahl) {
		System.out.println(sessionContext.getCallerPrincipal().getName());
		System.out.println(timeService.getTime());
		if (map.containsKey(produkt)){
			int alt = map.get(produkt);
			int neu = alt + anzahl;
			map.put(produkt, neu);
		} else {
			map.put(produkt, anzahl);
		}
	}

	public Map<String, Integer> getInhalt() {
		return map;
	}
	
	@Remove
	public void abmelden() {
		System.out.println("Benutzer wird abgemeldet");
	}

}
