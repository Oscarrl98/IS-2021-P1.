package com.gt.edu.umg.ingenieriasoftware.p1.parcial1.controller;

import com.gt.edu.umg.ingenieriasoftware.p1.parcial1.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String gotoindex() {
       return "index.html";
    }


@PostMapping("/upload")
    public String UploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){

    fileService.uploadFile(file);

    redirectAttributes.addFlashAttribute("message", "archivo cargado" + file.getOriginalFilename() + "!");

    return "redirect:/";
}
}
