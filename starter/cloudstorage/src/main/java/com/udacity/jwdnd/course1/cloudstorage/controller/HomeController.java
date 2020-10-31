package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {
    private FileService fileService;
    private UserService userService;

    public HomeController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping
    public String homeView() {
        return "home";
    }

    @GetMapping("/delete/{fileId}")
    public String deleteFile(Integer fileId) {
        fileService.deleteFile(fileId);
        return "home";
    }

    @PostMapping
    public String postFile(MultipartFile fileUpload, Authentication authentication, Model model) throws IOException {
        File file = new File(null, fileUpload.getOriginalFilename(), fileUpload.getContentType(), String.valueOf(fileUpload.getSize()), userService.getUserId(authentication.getName()), fileUpload.getBytes());
        fileService.addFile(file);
        model.addAttribute("files", fileService.getFiles());
        return "home";
    }
}
