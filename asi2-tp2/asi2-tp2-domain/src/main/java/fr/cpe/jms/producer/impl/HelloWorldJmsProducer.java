package fr.cpe.jms.producer.impl;

import fr.cpe.jms.producer.IHelloWorldJmsProducer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Created by ubuntu on 9/18/16.
 */
@Stateless    // On crée un EJB parce que c'est cool !
public class HelloWorldJmsProducer implements IHelloWorldJmsProducer {

    @Resource(name = "java:/asi2-HelloWorld")    // On va injecte la queue déclarée sur le serveur via son nom JNDI
    private Queue queue;

    @Inject    // On injecte le contexte JMS
    // @JMSConnectionFactory(value = "java:comp/DefaultJMSConnectionFactory")    // On redéfinie la ConnectionFactory si on n'utilise pas celle par défaut.
    private JMSContext context;

    @Override
    public void sendHelloWord() {
        context.createProducer()
                .send(queue, "Hello world !");
    }
}
