/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 */
package com.yonetani.study.websample.sample2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample2メニュー画面のコントローラーです。
 * 表示するメニューはZenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * 
 * @author user
 *
 */
@Controller
@RequestMapping("/sample2/")
public class Sample2MenuController {
	
	/**
	 * Sample2メニューページを初期表示します。
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getSample2Menu(Model model) {
		model.addAttribute("titleMessage", "Zenn あしたば");
		model.addAttribute("titleText", "Javaの基礎を学び終えたアナタに贈る、 SpringBoot/SpringSecurityによる掲示板開発ハンズオン");
		return "sample2/sample2menu";
	}
}
