/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Formと入力チェック(バリデーション)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step4/
 * 
 * 以下入力チェック(バリデーション)についてのサンプルです。
 * ・アノテーションを使った入力チェック(バリデーション)
 * ・複数項目が関連する場合の入力チェック(バリデーション)
 * ・Thymeleafでの入力エラー表示
 * 
 * また、DTOクラスに入力チェック用のアノテーションを有効とするためにSpring>スターターの追加を選択し
 * 「スタータープロジェクトの依存関係」ウインドウを表示後、「Validation(バリデーション)」(または、I/O→Validation)を
 * 依存関係に追加してください。
 * 
 */
package com.yonetani.study.websample.sample1.step04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yonetani.study.websample.sample1.step04.controller.form.Sample1Step04InputForm;

import jakarta.validation.Valid;

/**
 * 「Spring Boot入門:Formと入力チェック(バリデーション)」を表示するコントローラーです。
 * 
 * @author user
 *
 */
@Controller
public class Sample1Step04Controller {

	// 初期表示画面
	private static final String INDEX_PAGE_URL = "/sample1/step04/sample104index";
	
	// チェック結果OK画面
	private static final String CHECK_OK_PAGE_URL = "/sample1/step04/sample104checkOK";
	
	/**
	 * 「Spring Boot入門：Formと入力チェック(バリデーション)」を初期表示します。
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/sample1/step04/")
	public String step04Index(Model model) {
		model.addAttribute("sample1Step04InputForm", new Sample1Step04InputForm());
		return INDEX_PAGE_URL;
	}
	
	/**
	 * 入力内容のチェック結果画面を表示します。
	 * ・チェックOK：OK画面
	 * ・チェックNG：初期表示画面
	 * 
	 * @param model
	 * @param form
	 * @param result
	 * @return
	 */
	// @Validアノテーションを付けた引数は入力チェックが行われる
	// 結果は直後のBindingResult型の引数に格納されるため、BindingResultは@Validのすぐ後でなければならない
	// @ModelAttributeアノテーションで自動でmodelにSample1Step04InputFormの値を格納する。キーは変数名となります
	//
	@PostMapping("/sample1/step04/action")
	public String step04Action(Model model, @ModelAttribute @Valid Sample1Step04InputForm inputForm, BindingResult result) {
		// 入力チェック結果がNGの場合は初期表示画面に戻る。それ以外はOK画面に遷移する
		if(result.hasErrors()) {
			return INDEX_PAGE_URL;
		}
		return CHECK_OK_PAGE_URL;
	}
}
