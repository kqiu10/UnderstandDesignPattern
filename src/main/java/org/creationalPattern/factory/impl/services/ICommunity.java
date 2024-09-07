package org.creationalPattern.factory.impl.services;

/**
 * interface used to initialize different factory classes.
 */
public interface ICommunity {

    String sendCommunity(String uId, String bizId) throws IllegalArgumentException;
}
