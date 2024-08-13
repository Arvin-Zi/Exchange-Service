package com.adak.order_mng.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static class RequestNotApprovedException extends RuntimeException {
        public RequestNotApprovedException(String message) {
            super(message);
        }
    }
}
