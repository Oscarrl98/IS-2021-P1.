package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service;


import java.io.File;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

public class CsvFormat implements IFormat,ICsvActions {

    @Override
    public void convertCsvToJson(String from,String archive) throws IOException {

        File input = new File("/home/oscarlopez/"+from);
        File output = new File("/home/oscarlopez/"+archive+".json");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();

        ObjectMapper mapper = new ObjectMapper();

        // Write JSON formated data to output.json file
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);

        // Write JSON formated data to stdout
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
    }
}
