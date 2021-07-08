package com.example.s3demo.controller;

import com.example.s3demo.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/s3operation")
public class FileController {

    @Autowired
    private AmazonClient amazonClient;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file, Model model) {
        String imageUrl = this.amazonClient.uploadFile(file);
        model.addAttribute("imageUrl",imageUrl);
        return "image";
    }
}
