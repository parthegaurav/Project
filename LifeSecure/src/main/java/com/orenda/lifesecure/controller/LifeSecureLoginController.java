package com.orenda.lifesecure.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.orenda.lifesecure.model.UserDetails;
import com.orenda.lifesecure.service.LifeSecureLoginService;

@Controller
@RequestMapping("/login")
@SessionAttributes
public class LifeSecureLoginController {

	@Autowired
	LifeSecureLoginService loginService;
    Random random = new Random(1000);

    //login code
    
	@GetMapping("/")
	public String loginPage() {

		return "login";
	}
	
	@GetMapping("/verifyUser")
	public ModelAndView verifyUser(@RequestParam("username") String username, @RequestParam("password") String password,
			 HttpSession session) {
		System.out.println("login method called::: username::" + username + "  password:: " + password);
		System.out.println("login sucess");

		 UserDetails userdetails = loginService.verifyUserCredentilas(username, password);
		 
		 ModelAndView model=null;
		 if(userdetails==null) {
			 model=new ModelAndView("login", "msg","Please Enter Correct username or password Please Try Again To Login ");
			 return model;
		 }

		if (userdetails.getUsertype().equalsIgnoreCase("admin")) {
			System.out.println(" admin login sucess");
			model=new ModelAndView("admin");
			return model;
		} else if (userdetails.getUsertype().equalsIgnoreCase("customer")) {
			System.out.println("customer login success");
			model=new ModelAndView("customer");
			return model;

		} else if (userdetails.getUsertype().equalsIgnoreCase("agent")) {
			System.out.println("agent login success");
			model=new ModelAndView("agent");
			return model;

		}

		else {
			System.out.println("your password or username is incorrect");
		}

		return model;

	}
	
	//forgot password code

	@GetMapping("/forgot")
	public String forgotPassword() {
		return "forgotPassword";

	}

	@GetMapping("/verifyusername")
	public ModelAndView verifyusername(@RequestParam("email") String emailId, HttpSession session) {
		
		ModelAndView model = null;
		boolean flag = loginService.getUserByEmail(emailId);
		if (flag) {
			int otp = random.nextInt(999999);
			System.out.println(otp);
			session.setAttribute("emailId", emailId);
			session.setAttribute("oldotp", otp);

			// we can send email to user

			String msg = "OTP for password reset :" + otp;
			String subject = "OTP From secure insurance";
			String form = "lifesecure2022@gmail.com";
			String to = emailId;
			loginService.sendEmail(msg, subject, form, to);
			model = new ModelAndView("verifyotp");
			return model;
		}

		model = new ModelAndView("forgotPassword", "msg", "you are not registered user");
		return model;
	}

	@GetMapping("/reset")
	public String resetpassword() {
		return "verifyotp";
	}

	

	@PostMapping("/verifyotp")
	public ModelAndView verifyOTP(@RequestParam("otp") int otp, HttpServletRequest request) {
        
		ModelAndView model = null;
		HttpSession session = request.getSession(false);
		int oldotp = (int) session.getAttribute("oldotp");

		System.out.println("the old otp is session:" + oldotp);
		

		// verify the otp
		if (otp == oldotp) {
		//	System.out.println("otp is correct");
			model = new ModelAndView("saveNewPassword", "msg", "OTP is correct");
			return model;
		} else {
		//	System.out.println("otp is wrong");
			model = new ModelAndView("verifyotp", "msg", "OTP is wrong");
			return model;
		}
		
		new method

	}

	@PostMapping("savepassword")
	public ModelAndView saveNewPassword(@RequestParam("newPassword") String newPassword, HttpServletRequest request) {

		//System.out.println(newPassword);
		ModelAndView model = null;
		HttpSession session = request.getSession(false);
		String emailId = (String) session.getAttribute("emailId");
		

		boolean flag = loginService.verifyOtp(emailId, newPassword);

		if (flag) {
			System.out.println("password saved successfully");
			model = new ModelAndView("login", "msg", "password is Successfully reset");
			return model;
		}
		return model = new ModelAndView("login", "msg", "please try again..");
	}

}
