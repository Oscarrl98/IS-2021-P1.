package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service;

import java.io.IOException;

public interface IFormat {
    public void convertCsvToJson(String from,String archive) throws IOException;
}
