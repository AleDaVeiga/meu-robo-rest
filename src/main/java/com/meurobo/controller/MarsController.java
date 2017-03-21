package com.meurobo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meurobo.exception.BadRequestException;
import com.meurobo.model.MeuRobo;

@RestController
public class MarsController {
	@RequestMapping("/mars/{movimento}")
	String hello(@PathVariable String movimento) {
		return new MeuRobo().movimentar(movimento);
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleIndexNotFoundException(BadRequestException re, HttpServletRequest request,
			HttpServletResponse resp) {
		return re.getMensagem();
	}
}