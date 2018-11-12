package com.baizhi.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.FileParm;

public class UploadUtil {
	public static final String FILE="FIEL";
	public static final String IMG="IMG";
	public static FileParm uploadFile(MultipartFile multipartFile,HttpServletRequest request,String type){
		String projectPath=request.getSession().getServletContext().getRealPath("/");
		File file=new File(projectPath);
		String webappPath=file.getParent();
		
		File uploadPath;
		if (type.equals(FILE)) {
			uploadPath=new File(webappPath+"/chimingfowang/back/img/upload");
		}else{
			uploadPath=new File(webappPath+"/chimingfowang/back/img/upload");
		}
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		String oldFileName=multipartFile.getOriginalFilename();
		String extName=FilenameUtils.getExtension(oldFileName);
		
		UUID uuid=UUID.randomUUID();
		String newName=uuid.toString();
		newName=newName+"."+extName;
		try {
			multipartFile.transferTo(new File(uploadPath, newName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new FileParm(uploadPath+File.separator+newName, oldFileName);
	}
}
