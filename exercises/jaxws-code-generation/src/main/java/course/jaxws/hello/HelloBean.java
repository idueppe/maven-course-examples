package course.jaxws.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name="Hello",serviceName="HelloService",targetNamespace="http://course/hello")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public class HelloBean {
	
	@WebMethod(operationName="sayOperation",action="sayHello")
	public @WebResult(
			name="greeting",
			partName="body",
			targetNamespace="http://course/hello") String say(@WebParam(name="name",partName="body")Name name) throws EmptyNameException {
		if (name == null || name.getFirsName().isEmpty() || name.getLastName().isEmpty()) {
			throw new EmptyNameException();
		}
		return "Hello "+name.getFirsName()+" "+name.getLastName()+"!";
	}

}
