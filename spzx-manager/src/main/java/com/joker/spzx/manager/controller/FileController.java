package com.joker.spzx.manager.controller;


import com.joker.spzx.manager.service.FileService;
import com.joker.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/system")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/fileUpload")
    public Result<String> fileUploadService(@RequestParam MultipartFile file) {
        String fileUrl = fileService.fileUpload(file);
        return Result.build(fileUrl);
    }
}
