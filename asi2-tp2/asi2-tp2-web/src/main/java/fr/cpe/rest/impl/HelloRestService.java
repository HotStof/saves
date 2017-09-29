package fr.cpe.rest.impl;

import fr.cpe.jms.producer.IHelloWorldJmsProducer;
import fr.cpe.rest.IHelloRestService;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by ubuntu on 9/10/16.
 */
public class HelloRestService implements IHelloRestService {

    Logger logger = Logger.getLogger(HelloRestService.class.getName());

    @Inject
    IHelloWorldJmsProducer helloWorldJmsProducer;

    @Override
    public String helloJms() {
        logger.info(">>> helloJms()");

        helloWorldJmsProducer.sendHelloWord();

        logger.info("<<< helloJms()");
        return "Hello in the Q...";
    }

    @Override
    public String hello() {
        logger.info(">>> hello()");
        logger.info("<<< hello()");
        return "Hello !!";
    }


}
