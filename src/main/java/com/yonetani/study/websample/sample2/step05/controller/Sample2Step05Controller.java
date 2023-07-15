/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプルを表示するためのコントローラーです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 * 
 */
package com.yonetani.study.websample.sample2.step05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yonetani.study.websample.sample2.step05.domain.model.UserComments;
import com.yonetani.study.websample.sample2.step05.form.Sample2Step05CommentForm;
import com.yonetani.study.websample.sample2.step05.usecase.Sample2Step05UserCommentUseCase;

import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルを表示するためのコントローラーです。
 * 「05：Mybatisを使ったデータの保存」
 * 「06：MyBatisを使ったデータの取得、その表示」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 *  
 * @author user
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/sample2/step05/")
public class Sample2Step05Controller {
	
	private final Sample2Step05UserCommentUseCase userCommentUseCase;
	
	/**
	 * 「05：Mybatisを使ったデータの保存」「06：MyBatisを使ったデータの取得、その表示」の掲示板入力画面を初期表示します。
	 * 
	 * @return 遷移先画面のModelとView
	 */
	@GetMapping("/board/")
	public ModelAndView viewBoard() {
		ModelAndView modelAndView = new ModelAndView("sample2/step05/sample205board");
		modelAndView.addObject("action", "/sample2/step05/board/");
		modelAndView.addObject("sample2Step05CommentForm", new Sample2Step05CommentForm());
		// 画面に表示する投稿データを取得
		UserComments userComments = userCommentUseCase.read();
		modelAndView.addObject("comments", userComments.getValues());
		
		return modelAndView;
	}
	
	/**
	 * 掲示板入力の送信(POST)を処理します。
	 * 処理後、/sample2/step05/board/のgetにリダイレクトされます。
	 * 
	 * @param comment 画面から受け取った入力情報(Sample2Step05CommentForm)
	 * @param bindingResult Sample2Step05CommentFormのバリデーションチェック結果
	 * @return 遷移先画面のModelとView
	 */
	@PostMapping("/board/")
	public ModelAndView postComment(@ModelAttribute @Validated Sample2Step05CommentForm commentForm,
			BindingResult bindingResult) {
		
		// formの値をデバック出力
		System.out.println("/sample2/step05/ form=" + commentForm);
		
		// 画面表示のModelとViewを生成
		ModelAndView modelAndView = new ModelAndView();
		// actionのURLを設定
		modelAndView.addObject("action", "/sample2/step05/board/");
		
		// バリデーションチェック結果を判定する
		if(bindingResult.hasErrors()) {
			// バリデーションチェック結果がNGの場合
			// 画面入力内容を設定し、POST画面に戻る
			modelAndView.setViewName("sample2/step05/sample205board");
			// form入力情報をセット
			modelAndView.addObject("sample2Step05CommentForm", commentForm);
			
		} else {
			// バリデーションチェック結果がOKの場合
			userCommentUseCase.write(commentForm);
			
			// POST処理後はGETにリダイレクトして２重送信への対処とする
			// get時に現在登録されている投稿内容を取得するので、登録した内容も
			// 表示される点に注目
			modelAndView.setViewName("redirect:/sample2/step05/board/");
		}
		
		return modelAndView;
	}
}
