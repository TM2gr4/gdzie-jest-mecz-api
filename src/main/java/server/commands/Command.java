package server.commands;

import server.requests.Request;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface Command<T, K extends Request> {
    T handle(K k) throws GeneralSecurityException, IOException;
}
