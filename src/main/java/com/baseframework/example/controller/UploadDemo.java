package com.baseframework.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baseframework.example.uploadProgress.Progress;

@Controller
public class UploadDemo {
	@RequestMapping("toUpload")
	public String toUpload() {
		return "upload";

	}

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public boolean upload(// 确定上传文件个数 添加参数即可 @RequestParam("file") MultipartFile
							// uploadFile,
			HttpServletRequest request) throws IllegalStateException,
			IOException {
		// 传多文件模式(不定个数)
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> files = multiRequest.getFileMap();

		System.out.println(files);

		for (MultipartFile file : files.values()) {

			file.transferTo(new File("C:\\Users\\yeahmobi\\Desktop\\upload\\"
					+ file.getOriginalFilename()));
		}

		return true;
	}

	/**
	 * 定时请求 获取已上传信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "progress", method = RequestMethod.POST)
	@ResponseBody
	public Progress initCreateInfo(HttpServletRequest request) {
		Progress status = (Progress) request.getSession()
				.getAttribute("status");
		return status;
	}
}
