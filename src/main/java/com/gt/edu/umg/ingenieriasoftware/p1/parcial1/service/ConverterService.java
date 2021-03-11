package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service;

import java.io.IOException;

public class ConverterService {

    public void convertFile(String extention,String as,String from,String archive) throws IOException {
            switch (extention){
                case "xml":
                    break;
                case "csv":
                    switch (as){
                        case "json":
                            new CsvFormat().convertCsvToJson(from,archive);break;
                        case "xml":
                            break;
                    }
                    break;
                case "json":
                    break;
                case "psv":
                    break;
                case "tsv":
                    break;
                    default:
            }
    }
}
