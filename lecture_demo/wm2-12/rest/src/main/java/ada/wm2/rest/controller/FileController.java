package ada.wm2.rest.controller;

import ada.wm2.rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("myFile") MultipartFile imageFile) {
        fileService.saveImageDB(1, imageFile);

        /*
        String fileName = imageFile.getOriginalFilename();
        String extension = fileName.substring(fileName.indexOf("."));

        fileService.saveImageFile(fileName, imageFile);
         */

        return "success";
    }


}
