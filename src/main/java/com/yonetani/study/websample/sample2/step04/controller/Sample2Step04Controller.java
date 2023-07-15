/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「04：PRGパターンの適用とバリデーション」のサンプルを表示するためのコントローラーです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/104c03
 * 
 * [PRGパターン]
 * PRGパターン(POST-Redirect-GETパターン)とは、
 * 
 * POSTで要求を行った後に画面のリロード(最新の情報に更新)を行うと再度同じPOSTが行われてしまう問題です。
 * この問題を解決する方法にはクッキーを使う、javascriptで対処するなど様々な方法があるが、この章では
 * RPPパターン(POST-Redirect-Getパターン)を使った方法を解説する
 * 
 * PRGパターンではPOST処理を行った後に強制リダイレクトを行いGETページを案内することでリロード問題を対処します。
 * 
 * ★バリデーション利用時の注意事項★
 * バリデーションのチェック結果のエラー情報が格納される名前はバリデーションを行ったクラスのクラス名(先頭が小文字)となるので
 * フォームデータの名前も必然的に以下のようにしないといけない。
 * 別の名前にすると、htmlの方でバリデーション結果が受け取れずに空が表示されることになるので注意(つまり、コンパイルエラーとはならない)
 * 
 */
package com.yonetani.study.websample.sample2.step04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yonetani.study.websample.sample2.step04.form.Sample2Step04CommentForm;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルを表示するためのコントローラーです。
 * 「04：PRGパターンの適用とバリデーション」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/104c03
 *  
 * @author user
 *
 */
@Controller
@RequestMapping("/sample2/step04/")
public class Sample2Step04Controller {
	
	/**
	 * 「03：掲示板の入力フォームを作る」の掲示板入力画面を初期表示します。
	 * 
	 * @return 遷移先画面のModelとView
	 */
	@GetMapping("/board/")
	public ModelAndView viewBoard() {
		ModelAndView modelAndView = new ModelAndView("sample2/step04/sample204board");
		modelAndView.addObject("action", "/sample2/step04/board/");
		modelAndView.addObject("sample2Step04CommentForm", new Sample2Step04CommentForm());
		return modelAndView;
	}
	
	/**
	 * 掲示板入力の送信(POST)を処理します。
	 * 処理後、/sample2/step04/board/のgetにリダイレクトされます。
	 * 
	 * @param comment 画面から受け取った入力情報(Sample2Step04CommentForm)
	 * @param bindingResult Sample2Step04CommentFormのバリデーションチェック結果
	 * @return 遷移先画面のModelとView
	 */
	@PostMapping("/board/")
	public ModelAndView postComment(@ModelAttribute @Validated Sample2Step04CommentForm commentForm,
			BindingResult bindingResult) {
		
		// formの値をデバック出力
		System.out.println("/sample2/step04/ form=" + commentForm);
		
		// 画面表示のModelとViewを生成
		ModelAndView modelAndView = new ModelAndView();
		// actionのURLを設定
		modelAndView.addObject("action", "/sample2/step04/board/");
		
		// バリデーションチェック結果を判定する
		if(bindingResult.hasErrors()) {
			// バリデーションチェック結果がNGの場合
			// 画面入力内容を設定し、POST画面に戻る
			modelAndView.setViewName("sample2/step04/sample204board");
			// ★注意事項 バリデーションのチェック結果のエラー情報が格納される名前は
			// バリデーションを行ったクラスのクラス名(先頭が小文字)となるので
			// フォームデータの名前も必然的に以下のようにしないといけない・
			// 別の名前にすると、htmlの方でバリデーション結果が受け取れずに空が表示されること
			// になるので注意(つまり、コンパイルエラーとはならない)
			// 
			modelAndView.addObject("sample2Step04CommentForm", commentForm);
			
		} else {
			// バリデーションチェック結果がOKの場合
			// POST処理後はGETにリダイレクトして２重送信への対処とする
			modelAndView.setViewName("redirect:/sample2/step04/board/");
		}
		
		return modelAndView;
	}
}
