package fr.cpe.rest.impl;

import fr.cpe.jms.producer.IAdditionServiceMessaging;
import fr.cpe.rest.IAdditionRestService;
import fr.cpe.service.IAdditionService;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ubuntu on 9/10/16.
 */
public class AdditionRestService implements IAdditionRestService {

    Logger logger = Logger.getLogger(AdditionRestService.class.getName());

    @Inject
    IAdditionService additionService;

    @Inject
    IAdditionServiceMessaging additionServiceMessaging;

    @Override
    public Number add(List<Double> a) {
        logger.info("add() - " + a);
        return additionService.add(a.stream().toArray(Double[]::new));
    }

    @Override
    public void addJms(List<Double> a) {
        logger.info(">>> addJms() - " + a);
        additionServiceMessaging.add(a.stream().toArray(Double[]::new));
        logger.info("<<< addJms()");
    }


}
