/**
 * SpringBootの勉強用プロジェクトです
 * 以下のブログサンプルをコーディンています。
 * 
 * 土谷の備忘録(びぼうろく)
 * https://www.tsuchiya.blog/spring-boot-tutorial/
 * 
 * アプリケーション内URL：root/sample1/***
 * 
 */
package com.yonetani.study.websample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author user
 *
 */
@Controller
public class SpringWebSampleApplicationController {
	
	// トップページ(/index)にアクセス時:http get
	@GetMapping
	public String index() {
		// 戻り値はThymeleaf(タイムリーフ)テンプレートファイルの名称(拡張子を除く)
		// src/main/resources/templatesからのパスを書く。また、ファイルの拡張子(html)は記述不要です。
		// むしろ、書いたらダメ
		return "index";
	}
	
	// トップページ(/index)にアクセス時:http get
	@GetMapping("/menu/")
	public String getSample1TopMenu() {
		// 戻り値はThymeleaf(タイムリーフ)テンプレートファイルの名称(拡張子を除く)
		// src/main/resources/templatesからのパスを書く。また、ファイルの拡張子(html)は記述不要です。
		// むしろ、書いたらダメ
		// return "index";
		return "menu";
	}
}
