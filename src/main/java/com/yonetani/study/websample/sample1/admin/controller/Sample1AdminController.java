/**
 * SpringBootの勉強用プロジェクトです。
 * 
 * ユーザ登録画面のコントローラーです。
 * 
 * 以下を参考に作成しています。
 * 「Zenn あしたば」
 * 「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/1c1ebe
 * 
 */
package com.yonetani.study.websample.sample1.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yonetani.study.websample.sample1.admin.form.Sample1UserForm;

/**
 * ユーザ登録画面のコントローラーです。
 * 
 * @author user
 *
 */
@Controller
@RequestMapping("/sample1/")
public class Sample1AdminController {

//	// 管理画面(ユーザ登録画面)選択時
//	@GetMapping("/sample1/admin/")
//	public String getAdminPage() {
//		return "sample1/admin/adminpage";
//	}
	
	// 管理画面(ユーザ登録画面)選択時
	// 上記は以下のように定義することもできるみたい
	// 戻り値のviewオブジェクトにreturnで返す文字列(ビュー名)と同じようにすること
	@GetMapping("/admin/")
	public ModelAndView getAdminPage(ModelAndView modelAndView) {
		modelAndView.setViewName("sample1/admin/adminpage");
		modelAndView.addObject("sample1UserForm", new Sample1UserForm());
		return modelAndView;
	}
	
	// 管理画面(ユーザ登録画面)よりユーザ登録実行時
	@PostMapping("/admin/")
	public ModelAndView postUser(ModelAndView modelAndView) {
		modelAndView.setViewName("sample1/admin/adminpage");
		modelAndView.addObject("sample1UserForm", new Sample1UserForm());
		return modelAndView;
	}
	
}
