package course.client;

import course.common.TimeService;
import course.util.JNDI;

public class TimeServiceClient {
	public static void main(String[] args) throws Exception {
//		TimeService timeService = (TimeService) JNDI.lookup(JNDI.GLASSFISH_ENV,"course.common.TimeService");
		TimeService timeService = (TimeService) JNDI.lookup(JNDI.GLASSFISH_ENV,"my/Timer");
//		TimeService timeService = (TimeService) JNDI.lookup(JNDI.JBOSS_ENV,"course.client.TimeService");
		String time = timeService.getTime();
		System.out.println(time);
	}
}
