package fr.cpe;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import fr.cpe.IHello;
import fr.cpe.IHelloRestService;	
public class HelloRestService implements IHelloRestService{
	
	Logger logger = Logger.getLogger(HelloRestService.class.getName());
	@Inject
	IHello helloService;

	
	public String hello(){
		logger.info(">>>hello()");
		return helloService.sayHello();
	}

}
