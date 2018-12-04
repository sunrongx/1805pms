package com.zs.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	public String uploadFile(MultipartFile file,HttpServletRequest req){
		//获得upload文件夹的物理路径
		String path=req.getRealPath("/upload");
		//创建新文件名：目标文件
		//利用uuid算法随机生成32位码
		/**
		 * uuid算法
		 * 根据网卡、时间、IP地址等信息自动生成绝不重复的32位码
		 */
		UUID uuid = UUID.randomUUID();
		//目标文件名 32位码+文件后缀（源文件的原生文件名）
		String destfilename=uuid.toString()+file.getOriginalFilename();
		//创建新文件，物理路径/新文件名
		//url：upload/新文件名
		File destfile = new File(path+File.separator+destfilename);
		//将原始文件拷贝到新文件
		try {
			file.transferTo(destfile);
			return destfilename;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		
	}
}
