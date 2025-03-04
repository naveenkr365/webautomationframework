package com.web.exceptions;

public class IOException extends FrameworkException {

    public IOException(String message){
        super(message);
    }

    public IOException(String message, Throwable cause){
        super(message, cause);
    }
}
