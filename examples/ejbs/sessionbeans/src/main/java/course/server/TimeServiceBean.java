package course.server;

import java.text.DateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import course.common.TimeService;
import course.common.TimeServiceLocal;

@Stateless(mappedName="my/Timer",name="MyTimer")
public class TimeServiceBean implements TimeService, TimeServiceLocal{
	
	private static DateFormat df = DateFormat.getDateTimeInstance();
	
	public String getTime() {
		String message = "Die Zeit ist jetzt: " + df.format(new Date());
		System.out.println(this+" - ??? - "+message);
		return message;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("TimeService init");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("TimeService close");
	}

}
