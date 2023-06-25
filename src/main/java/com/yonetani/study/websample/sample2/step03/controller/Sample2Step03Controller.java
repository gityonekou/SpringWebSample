/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「03：掲示板の入力フォームを作る」のサンプルを表示するためのコントローラーです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/3adab0
 * 
 */
package com.yonetani.study.websample.sample2.step03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yonetani.study.websample.sample2.step03.form.Sample2Step03CommentForm;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルを表示するためのコントローラーです。
 * 「03：掲示板の入力フォームを作る」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/3adab0
 *  
 * @author user
 *
 */
@Controller
@RequestMapping("/sample2/")
public class Sample2Step03Controller {
	
	/**
	 * 「03：掲示板の入力フォームを作る」のレイアウトサンプルページを表示します。
	 * 
	 * @return
	 */
	@GetMapping("/step03/layout/")
	public String getSample2Step03Index() {
		return "sample2/step03/sample203main";
	}
	
	/**
	 * 「03：掲示板の入力フォームを作る」の掲示板入力画面を表示します。
	 * 
	 * @param view
	 * @return
	 */
	@GetMapping("/step03/board/")
	public ModelAndView viewBoard(ModelAndView view) {
		view.setViewName("sample2/step03/sample203board");
		view.addObject("commentForm", new Sample2Step03CommentForm());
		return view;
	}
	
	/**
	 * 掲示板入力の送信(POST)を処理します。
	 * @param comment
	 * @return
	 */
	@PostMapping("/step03/board/")
	public String postComment(@ModelAttribute Sample2Step03CommentForm comment, Model model) {
		model.addAttribute("commentForm", comment);
		System.out.println(comment);
		return "sample2/step03/sample203board";
	}
}
