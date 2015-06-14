package course.common;

import javax.ejb.Remote;

@Remote
public interface TimeService {

	public String getTime();

}
