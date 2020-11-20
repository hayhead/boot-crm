package com.core.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.core.utils.CodeUtil;

@Controller
public class CheckCodeController {
	
	 private static final long serialVersionUID = 1L;
	 
	 @GetMapping("/checkCode")
	 public void getCheckCode(HttpServletRequest req, HttpServletResponse resp) {
		 // ���ù��������ɵ���֤�����֤��ͼƬ
	        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

	        // ����λ���ֵ���֤�뱣�浽Session�С�
	        HttpSession session = req.getSession();
	        session.setAttribute("code", codeMap.get("code").toString());

	        // ��ֹͼ�񻺴档
	        resp.setHeader("Pragma", "no-cache");
	        resp.setHeader("Cache-Control", "no-cache");
	        resp.setDateHeader("Expires", -1);

	        resp.setContentType("image/jpeg");

	        // ��ͼ�������Servlet������С�
	        ServletOutputStream sos;
	        try {
	            sos = resp.getOutputStream();
	            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
	            sos.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 }

}
