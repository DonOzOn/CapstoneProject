package com.realestatebrokerage.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestatebrokerage.service.StorageService;
import com.realestatebrokerage.web.rest.errors.StorageFileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class FileUploadResource {
    private final Logger log = LoggerFactory.getLogger(FileUploadResource.class);

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/upload" , produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        log.debug("REST request to upload file : {}", file.getOriginalFilename());
        String fileName = storageService.store(file);
        return new ResponseEntity<>(JSONObject.quote(fileName), HttpStatus.OK);
    }

    @PostMapping("/upload/list")
    public ResponseEntity<String> uploadList(@RequestBody List<MultipartFile> files) {
        log.debug("REST request to upload list file : {}", files);
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(files);
            System.out.println(jsonInString2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MultipartFile f: files) {
            storageService.store(f);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @GetMapping("/upload")
    public ResponseEntity<List<String>> listUploadedFiles() {
        List<String> listFileName = storageService.loadAll().map(
            path -> MvcUriComponentsBuilder.fromMethodName(FileUploadResource.class,
                    "serveFile", path.getFileName().toString()).build().toString())
            .collect(Collectors.toList());
        return new ResponseEntity<>(listFileName, HttpStatus.OK);
    }
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/upload/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("/upload")
    public ResponseEntity<String> delete(String filename) {
        storageService.delete(filename);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
