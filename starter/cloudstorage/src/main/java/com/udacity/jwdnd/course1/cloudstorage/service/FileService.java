package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FileService {
    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public void addFile(File file) {
        fileMapper.insert(file);
    }

    public void deleteFile(Integer fileid) {
        fileMapper.delete(fileid);
    }

    public List<File> getFiles() {
        return fileMapper.getFileList();
    }
}
