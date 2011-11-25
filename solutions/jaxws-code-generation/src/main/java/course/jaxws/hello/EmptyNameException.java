package course.jaxws.hello;

import javax.xml.ws.WebFault;

@WebFault(name = "EmptyName", targetNamespace = "http://course/hello", faultBean = "course.jaxws.hello.FaultType")
public class EmptyNameException extends Exception {

	private static final long serialVersionUID = -8675072513037040388L;

	private FaultType faultInfo;
	
	public EmptyNameException() {
		super();
	}

	public EmptyNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyNameException(String message) {
		super(message);
	}

	public EmptyNameException(Throwable cause) {
		super(cause);
	}

	public EmptyNameException(String message, FaultType faultInfo) {
		super(message);
	}

	public EmptyNameException(String message, FaultType faultInfo, Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public FaultType getFaultInfo() {
		return faultInfo;
	}

}
