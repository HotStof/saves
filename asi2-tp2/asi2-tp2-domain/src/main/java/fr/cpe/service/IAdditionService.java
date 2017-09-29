package fr.cpe.service;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * Created by ubuntu on 9/11/16.
 */
@Local
public interface IAdditionService {
    double add(Double... a);

    double addJms(Double... a);
}
