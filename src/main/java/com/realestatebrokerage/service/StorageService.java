package com.realestatebrokerage.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.realestatebrokerage.config.ApplicationProperties;
import com.realestatebrokerage.web.rest.errors.StorageException;
import com.realestatebrokerage.web.rest.errors.StorageFileNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private final Path rootLocation;

    public StorageService(ApplicationProperties properties) {
        this.rootLocation = Paths.get(properties.getBaseLocation());
    }


    public String store(MultipartFile file) {
        long currentTS = Long.valueOf(String.valueOf(System.currentTimeMillis()/1000));
        String filename = "" + currentTS + "."+file.getOriginalFilename();
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                    "Cannot store file with relative path outside current directory "
                        + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
                return filename;
            }
        }
        catch (IOException ex) {
            throw new StorageException("Failed to store file " + filename);
        }
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException a) {
            throw new StorageException("Failed to read stored files" + a);
        }
    }
    public Stream<Path> loadListAsResource(List<String> filename) {
        List<Path> resources = new ArrayList<>();
        for (String fname: filename) {
            try {
                Path file = load(fname);
                Resource resource = new UrlResource(file.toUri());
                if (resource.exists() || resource.isReadable()) {
                    resources.add(file);
                }
                else {
                    throw new StorageFileNotFoundException(
                        "Could not read file: " + fname);
                }
            }
            catch (MalformedURLException b) {
                throw new StorageFileNotFoundException("Could not read file: " + fname);
            }
        }
        return resources.stream().map(this.rootLocation::relativize);
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                    "Could not read file: " + filename);
            }
        }
        catch (MalformedURLException c) {
            throw new StorageFileNotFoundException("Could not read file: " + filename);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void delete(String filename) {
        try {
            Path file = load(filename);
            FileSystemUtils.deleteRecursively(file);
        }
        catch (MalformedURLException d) {
            throw new StorageFileNotFoundException("Could not read file: " + filename);
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException x) {
            throw new StorageException("Could not initialize storage");
        }
    }
}
