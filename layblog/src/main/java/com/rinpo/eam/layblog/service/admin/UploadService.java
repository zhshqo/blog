package com.rinpo.eam.layblog.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rinpo.eam.layblog.model.TUpload;
import com.rinpo.eam.layblog.utils.TokenProccessor;
import com.rinpo.eam.layblog.vo.R;

import cn.hutool.core.io.FileUtil;

@Service
public class UploadService {
	
	private final Logger logger = LoggerFactory.getLogger(UploadService.class);
	
    @Autowired
    private Environment environment;

    public Map<String, Object> upload(MultipartFile qrCodeImg, String type) {
        String path = "/img";
        String fileName = qrCodeImg.getOriginalFilename();
        //扩展名，包括点符号
        String ext = fileName.substring(fileName.lastIndexOf("."));
        fileName = TokenProccessor.getInstance().makeTokenURLSafe().concat(ext);
        try {
            File targetFile = new File(path);
            boolean m = true;
            if (!targetFile.exists()) {
                m = targetFile.mkdirs();
            }
            if (m) {
                String filePath = saveFile(path, fileName, qrCodeImg.getBytes());
                if(filePath==null) {
                	return R.err2Map("文件创建失败！");
                }
                String virtualPath = path + "/" + fileName;
                //保存到数据库
                TUpload upload = new TUpload();
                upload.setDiskPath(filePath);
                upload.setVirtualPath(virtualPath);
                upload.setFileType(qrCodeImg.getContentType());
                upload.setUpload(new Date());
                
                return R.ok2Map("上传成功！", virtualPath);
            } else {
            	return R.err2Map("文件创建失败！");
            }
        } catch (IOException e) {
        	logger.error("文件IO出错，出错信息：{}", e.getLocalizedMessage());
            return R.err2Map("文件IO出错，出错信息：" + e.getLocalizedMessage());
        } catch (Exception e) {
            return R.err2Map("上传出错，出错信息：" + e.getLocalizedMessage());
        }
    }

    private String saveFile(String path, String fileName, byte[] fileBytes) throws Exception {
        String prefix = environment.getProperty("web.upload-path");
        String filePath = prefix + path + "/" + fileName;
        File targetFolder = new File(FileUtil.getAbsolutePath(prefix + path));
        File targetFile = new File(FileUtil.getAbsolutePath(filePath));
        boolean m = true;
        if (!targetFolder.exists()) {
        	m = targetFile.getParentFile().mkdirs();
        }
        if(m) {
            filePath = FileUtil.getAbsolutePath(filePath);
            FileOutputStream out = new FileOutputStream(filePath);
            out.write(fileBytes);
            out.flush();
            out.close();
            return filePath;
    	}else {
    		return null;
    	}
    }
}
