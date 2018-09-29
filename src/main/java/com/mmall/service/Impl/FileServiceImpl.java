package com.mmall.service.Impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @auther 李明浩
 * @date 9/29/2018 10:42 AM
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {
    //想要打印文件
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    public String upload(MultipartFile file,String path){
        //上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        //使用substring切割string，lastIndexOf从后面获取
        //在后面 + 1是往后偏移一位
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //拼接一下上传后的文件名，随机数+文件名后缀
        String uploadFileName = UUID.randomUUID().toString() + fileExtensionName;
        logger.info("开始文件上传,上传文件的文件名：{}，上传的路径：{}，新文件名：{}",fileName,path);
        File fileDir = new File(path);
        //
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            //创建多级目录
            fileDir.mkdirs();
        }
        //目标文件
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
            //上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除已经上传至ftp服务器的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上面文件异常" + e);
        }

        return targetFile.getName();
    }
}
