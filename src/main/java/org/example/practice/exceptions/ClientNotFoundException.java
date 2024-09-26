package org.example.practice.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(int clientId) {
        super("Client with id " + clientId + " not found.");
    }
}