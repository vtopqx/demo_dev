package com.sam.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sam.common.JacobWord;

/**
 * @ClassName: MarkController
 * @Description: 文档水印服务
 * @author mqx
 * @date 2018年6月1日 上午8:34:00
 */
@Controller
@RequestMapping("/mark")
public class MarkController {

	// 文件格式支持类型
	@SuppressWarnings("serial")
	public final static Map<String, String> FORMAT_MAP = new HashMap<String, String>() {
		{
			put("doc", "doc");
			put("docx", "docx");
			put("jpg", "jpg");
			put("png", "png");
			put("bmp", "bmp");
		}
	};

	/**
	 * @Description: 水印设置
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/doAdd",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String doAdd(@RequestParam("name") String name, HttpServletRequest request) {
		String result = "非法请求!";
		try {
			if (request instanceof MultipartHttpServletRequest) {
				MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
				// 获取上传的文件
				Map<String, MultipartFile> fileMap = multipartHttpServletRequest.getFileMap();
				int index = 1;
				Map<String, String> pathMap = new HashMap<String, String>();
				// 判断格式
				boolean is_format = true;
				for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
					String fileName = entry.getValue().getOriginalFilename();
					String newName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
					if (!FORMAT_MAP.containsKey(newName.toLowerCase())) {
						is_format = false;
						result = "文件格式不合法,请重新上传";
						System.out.println("error:" + result);
						break;
					}
				}
				//如果文件格式合法进行处理
				if (is_format) {
					for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
						// 对文件进处理
						String fileName = entry.getValue().getOriginalFilename();
						String newName = System.currentTimeMillis()
								+ fileName.substring(fileName.indexOf("."), fileName.length());
						System.out.println("上传文件名称:" + fileName + ",新名称:" + newName);
						// 记录生成水印的文件名称
						if (index == 1) {
							result = newName;
						}
						// 文件保存路径
						// 获取文件需要上传到的路径
						String filePath = request.getSession().getServletContext().getRealPath("/") + "upload//" + newName;
						System.out.println("filePath:" + filePath);
						// 转存文件
						entry.getValue().transferTo(new File(filePath));
						pathMap.put("file" + index, filePath);
						index += 1;
					}
					System.out.println("upload success!");

					// 设置水印
					mark(pathMap, name);
				}
			}
		} catch (Exception e) {
			result = "文件过大，请上传小于5M文件!";
			System.out.println("error:" + result);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Description: 设置
	 * @param pathMap
	 * @param name
	 */
	public static void mark(Map<String, String> pathMap, String name) {
		System.out.println("start mark...");
		JacobWord jacob = JacobWord.getInstance();
		try {
			if (jacob.initWord()) {
				jacob.openDocument(pathMap.get("file1"));
				jacob.getActiveDoc();
				if (pathMap.size() >= 2) {
					jacob.setImgWaterMark(pathMap.get("file2"));
				} else {
					jacob.setTextWaterMark(name);
				}
				jacob.closeDocument();
				jacob.closeWord();
			}
			System.out.println("mark success!");
		} catch (Exception e) {
			e.printStackTrace();
			jacob.closeDocument();
			jacob.closeWord();
		}
	}

}
