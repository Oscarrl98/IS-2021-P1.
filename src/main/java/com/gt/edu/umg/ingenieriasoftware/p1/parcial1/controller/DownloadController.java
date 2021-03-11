package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.controller;


import com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;


@Controller
public class DownloadController {
    private static final String DIRECTORY = "/tmp";

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile1(@RequestParam String from,@RequestParam String as) throws IOException {

        MediaType mediaType = MediaCompatibility.getMediaTypeForFileName(this.servletContext, as);

        String[] parts = from.split("\\.");
        String archive = parts[0];
        String extention = parts[1];

        ConverterService convert1=new ConverterService();
        convert1.convertFile(extention,as,from,archive);

        File file = new File(DIRECTORY + "/" + archive+"."+as);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length()) //
                .body(resource);
    }

}

