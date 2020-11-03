package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE fileid = #{fileId}")
    File getFile(Integer fileId);

    @Select("SELECT * FROM FILES")
    List<File> getFileList();

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES " +
            "(#{filename}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    Integer insert(File file);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileId}")
    void delete(Integer fileId);
}