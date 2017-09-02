package com.yonyou.web.shiro;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.component.shiro.Constants;
import com.yonyou.component.shiro.UsernamePasswordToken;
import com.yonyou.component.shiro.VerifyCodeUtil;

/**
 * @author abel.lin
 */
@Controller
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest request){
		
		return "page/login";
	}
	@RequestMapping("success")
	public String index(HttpServletRequest request){
		return "page/index";
	}	
	@RequestMapping("login/auth")
	public String doLogin(HttpServletRequest request){
		String username = request.getParameter("loginname");
		String pwd = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd, captcha); 
		Subject currentUser = SecurityUtils.getSubject(); 
		try{
			currentUser.login(token);
		}catch(Exception e){
			return "redirect:/login";
		}
		  
		return "redirect:/success";
	}
	
	@ResponseBody
	@RequestMapping("admin/channel")
	public String channel(HttpServletRequest request){
		return "wellcome channel";
	}
	@ResponseBody
	@RequestMapping("admin/content")
	public String content(HttpServletRequest request){
		return "wellcome content";
	}
	@ResponseBody
	@RequestMapping("admin/sys")
	public String sys(HttpServletRequest request){
		return "wellcome sys";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		SecurityUtils.getSubject().logout();  
		return "redirect:/login";
	}
	
	/** 
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中) 
     */  
    @RequestMapping("/genCaptcha")  
    public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        //设置页面不缓存  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);  
        //将验证码放到HttpSession里面  
        request.getSession().setAttribute(Constants.VALIDATE_CODE, verifyCode);  
        System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");  
        //设置输出的内容的类型为JPEG图像  
        response.setContentType("image/jpeg");  
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 5, true, Color.WHITE, null, null);  
        //写给浏览器  
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());  
    }  
    
}
