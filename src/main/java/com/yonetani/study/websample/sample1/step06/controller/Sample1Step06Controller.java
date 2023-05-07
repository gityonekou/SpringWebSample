/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Data JPAでデータベース操作」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step6/
 * 
 * ORM(Object-Relational Mapping)には「Spring Data JPA」を使用しています。
 * 
 */
package com.yonetani.study.websample.sample1.step06.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yonetani.study.websample.sample1.step06.service.Sample1Step06Service;

import lombok.RequiredArgsConstructor;

/**
 * 「Spring Boot入門:Spring Data JPAでデータベース操作」を表示するコントローラーです。
 * 
 * @author user
 *
 */
@Controller
@RequestMapping("/sample1/step06")
@RequiredArgsConstructor
public class Sample1Step06Controller {
	
	private final Sample1Step06Service service;
	
	/**
	 * 「Spring Boot入門：Spring Data JPAでデータベース操作」を初期表示します。
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String step06Index(Model model) {
		model.addAttribute("booksList", this.service.findAll());
		return "/sample1/step06/sample106index";
	}
	
	/**
	 * 本登録時のアクションです。
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/action/")
	public String step06Action(@RequestParam(required = false) String title, Model model) {
		// タイトルが入力されたらデータベースに登録する
		if(!Objects.isNull(title) && !title.isBlank()) {
			this.service.save(title);
		}
		model.addAttribute("booksList", this.service.findAll());
		return "/sample1/step06/sample106index";
	}
}
