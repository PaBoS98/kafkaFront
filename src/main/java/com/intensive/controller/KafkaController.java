package com.intensive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.google.gson.Gson;
import com.intensive.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intensive.producer.KafkaProducerDemo;

@Controller
public class KafkaController {

	@Resource(name = "kafkaProducerDemo")
	KafkaProducerDemo producer;

	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		System.out.println("--------welcome--------");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(value = "/sendmessage", method = RequestMethod.GET)
	public ModelAndView sendMessage() {
		System.out.println("--------sendmessage--------");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(date);

		ModelAndView mv = new ModelAndView();
		mv.addObject("time", now);
		mv.setViewName("kafka_send");
		return mv;
	}

	@RequestMapping(value = "/onsend", method = RequestMethod.POST)
	public ModelAndView onsend(@RequestParam("age") String age, @RequestParam("name") String name) {
		System.out.println("--------onsend--------");
		UserDto user = new UserDto(Integer.parseInt(age), name);
		Gson gson = new Gson();
		producer.sendMessage(gson.toJson(user));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}
}
