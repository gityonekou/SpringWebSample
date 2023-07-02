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
 * このサンプルのみ、ModelAndViewとModelの両方を使ています。
 * 以降はModelを使う方法で統一します
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
@RequestMapping("/sample2/step03/")
public class Sample2Step03Controller {
	
	/**
	 * 「03：掲示板の入力フォームを作る」のレイアウトサンプルページを表示します。
	 * 
	 * @return　thymeleafへのリンク
	 */
	@GetMapping("/layout/")
	public String getSample2Step03Index() {
		// 引数として受け取るのはModelAndViewとModelの２パターンがあるが、どちらを利用することもできる
		// ただ、プロジェクトでどちらを使うかは統一する必要がある。（そのほうが可視性が高い)
		// このソースではあくまでもサンプルとして両方の使い方で記載している。
		// 移行は、Modelで統一することとする
		return "sample2/step03/sample203main";
	}
	
	/**
	 * 「03：掲示板の入力フォームを作る」の掲示板入力画面を表示します。
	 * 
	 * @param view
	 * @return 　遷移先画面のModelとView
	 */
	@GetMapping("/board/")
	public ModelAndView viewBoard(ModelAndView modelAndView) {
		// 引数として受け取るのはModelAndViewとModelの２パターンがあるが、どちらを利用することもできる
		// ただ、プロジェクトでどちらを使うかは統一する必要がある。（そのほうが可視性が高い)
		// このソースではあくまでもサンプルとして両方の使い方で記載している。
		// 移行は、Modelで統一することとする
		modelAndView.setViewName("sample2/step03/sample203board");
		modelAndView.addObject("action", "/sample2/step03/board/");
		modelAndView.addObject("commentForm", new Sample2Step03CommentForm());
		return modelAndView;
	}
	
	/**
	 * 掲示板入力の送信(POST)を処理します。
	 * @param comment 画面から受け取った入力情報(Sample2Step03CommentForm)
	 * @param model 画面から受け取った入力情報(Modelデータ)
	 * @return　thymeleafへのリンク
	 */
	@PostMapping("/board/")
	public String postComment(@ModelAttribute Sample2Step03CommentForm comment, Model model) {
		// formの値をデバック出力
		System.out.println("/sample2/step03/ form=" + comment);
		
		// 引数として受け取るのはModelAndViewとModelの２パターンがあるが、どちらを利用することもできる
		// ただ、プロジェクトでどちらを使うかは統一する必要がある。（そのほうが可視性が高い)
		// このソースではあくまでもサンプルとして両方の使い方で記載している。
		// 移行は、Modelで統一することとする
		model.addAttribute("action", "/sample2/step03/board/");
		model.addAttribute("commentForm", comment);
		
		return "sample2/step03/sample203board";
	}
}
