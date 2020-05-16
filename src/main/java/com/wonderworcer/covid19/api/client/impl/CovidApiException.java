package com.wonderworcer.covid19.api.client.impl;

public class CovidApiException extends RuntimeException {
    public CovidApiException(String message) {
        super(message);
    }

    public CovidApiException(Throwable cause) {
        super(cause);
    }
}
