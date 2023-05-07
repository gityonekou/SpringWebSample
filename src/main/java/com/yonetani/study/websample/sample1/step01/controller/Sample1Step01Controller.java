/**
 * SpringBootの勉強用プロジェクトです。
 * 
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門:ThymeleafとController」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step1/
 * 
 * まずは、簡単な画面⇔サーバー間の入出力(画面からの入力データを受け取り、編集して画面に返す）のサンプルです。
 * [依存関係設定内容]
 * Spring Web：Srping MVC
 * Lombok(ロンボック　or ロンボク)：ボイラープレートコード（単純で決まりきった記述/getter setterなど）をアノテーションで代用できます。
 * Thymeleaf(タイムリーフ)：テンプレートエンジンです。
 * 
 * 【補足】
 * 「@」アノテーション　とは
 * アノテーションとは注釈という意味です。
 * プログラミングでは、ソースコード中に登場する要素（クラスやメソッドなど）に対して、処理系に伝達したい
 * 付加的な情報（メタデータ）を注記する仕組みのことをアノテーションといいます。
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yonetani.study.websample.sample1.step01.controller.form.Sample1Step01InputForm;

/**
 * 「Spring Boot入門:ThymeleafとController」を表示するControllerです
 * @author user
 *
 */
@Controller
public class Sample1Step01Controller {
	
	// 入力画面を初期表示時(http getで/sample1/inputにアクセスした場合)
	@GetMapping("/sample1/step01/input")
	public String input() {
		// 戻り値はThymeleaf(タイムリーフ)テンプレートファイルの名称(拡張子を除く)
		// src/main/resources/templatesからのパスを書く
		return "sample1/step01/sample101input";
	}
	
	// input画面で入力した内容を受け取ります。
	// マッピング:http postで/sample1/outputにアクセスした場合)
	// 【ポイント】
	// SpringBootでは、@GetMappingや@PostMappingアノテーションを付けたメソッドの引数に自動的に入力フォーム
	// からの値を紐づけしてくれます。
	// 方法は2つありますが、基本は２のほうが使われます。（入力パラメーターが１つということはまずないので。。)
	// １．@RequestParamアノテーションを使う
	// ２．Setterを定義したクラスを引数にする
	
	@PostMapping("/sample1/step01/output")
	public String output(@RequestParam(required = false) String text1, Sample1Step01InputForm input, Model model) {
		// 引数に@RequestParamアノテーションをつけることで、引数名と同じ名前の入力パラメータの値が引数に格納されます
		// requiredパラメータの値にfalseを指定すると必須入力の項目ではないよという意味付けになります。
		// 指定のパラメータに値が設定されていない(キーがない)場合はnullが渡されます。
		model.addAttribute("output1", text1);
		model.addAttribute("output2", input);
		
		return "sample1/step01/sample101output";
	}
	
}
