package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service;

public class ExeptionFile extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public ExeptionFile(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
