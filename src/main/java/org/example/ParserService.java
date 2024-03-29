package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserService<T> {


    private final ObjectMapper objectMapper = new ObjectMapper();


    public T getParsedData(String filePath, Class<T> ref) throws IOException {
        return objectMapper.readValue(new File(filePath), ref);
    }



}
