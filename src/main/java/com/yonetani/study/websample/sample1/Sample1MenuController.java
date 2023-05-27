/**
 * SpringBootの勉強用プロジェクトです
 * 土谷の備忘録(びぼうろく)ブログ内サンプルのトップページ用コントローラークラスです。
 * 各章をメニュー表示します。
 * 
 * 土谷の備忘録(びぼうろく)
 * https://www.tsuchiya.blog/spring-boot-tutorial/
 * 
 * アプリケーション内URL：root/sample1/***
 * トップページURL：root/sample1/
 * 
 */
package com.yonetani.study.websample.sample1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author user
 *
 */
@Controller
public class Sample1MenuController {
	
	// 土谷の備忘録(びぼうろく)トップページ(/sample1)にアクセス時:http get
	@GetMapping("/sample1/")
	public String getSample1TopMenu(Model model) {
		// messageキーに"土谷の備忘録(びぼうろく)ブログ内サンプル"を追加します。
		model.addAttribute("message", "土谷の備忘録(びぼうろく)ブログ内サンプル");
		
		// リンクのテキストを設定
		model.addAttribute("linktext", "入力サンプルへ[Thymeleafのth:hrefを使う2]");
		
		// 戻り値はThymeleaf(タイムリーフ)テンプレートファイルの名称(拡張子を除く)
		// src/main/resources/templatesからのパスを書く。また、ファイルの拡張子(html)は記述不要です。
		// むしろ、書いたらダメ
		return "sample1/sample1menu";
	}
	
	/**
	 * ログインページを初期表示します。
	 * (get要求時にこのメソッドが呼ばれます。
	 * ログイン認証時(post要求時)はSample1LoginSecurityConfigの設定内容が処理されます
	 * (つまり、コントローラーで処理することはできません)
	 * 
	 * @return
	 */
	@GetMapping("/login/")
	public String getLogin() {
		return "login";
	}
}
