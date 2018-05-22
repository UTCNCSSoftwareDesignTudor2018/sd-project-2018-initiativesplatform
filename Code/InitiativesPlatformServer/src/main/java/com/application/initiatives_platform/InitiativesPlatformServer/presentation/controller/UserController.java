package com.application.initiatives_platform.InitiativesPlatformServer.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.application.initiatives_platform.InitiativesPlatformServer.business.services.SecurityService;
import com.application.initiatives_platform.InitiativesPlatformServer.business.services.UserServiceImpl;
import com.application.initiatives_platform.InitiativesPlatformServer.data.entity.User;
import com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto.UserDto;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private SecurityService securityService;

	@GetMapping(value = "registration")
	ModelAndView register() {
		UserDto userDto = new UserDto();
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("user", userDto);
		return mv;
	}

	@PostMapping(value = "register")
	@ResponseBody
	public RedirectView registerUserAccount(@Valid final UserDto userDto, final HttpServletRequest request) {
		User registeredUser = userService.registerUser(userDto);
		if (registeredUser != null) {
			securityService.autologin(userDto.getUserName(), userDto.getPassword());
			return new RedirectView("registration-confirmed-page");
		} else {
			return new RedirectView("registration-failed-page");
		}
	}
}
