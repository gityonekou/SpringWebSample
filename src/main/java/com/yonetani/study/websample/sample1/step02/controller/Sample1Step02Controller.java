/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門:Thymeleafの基本」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step2/
 * 
 * この章ではThymeleafの基本として、前回「ThymeleafとController」からより複雑なThymeleafの基本的な機能
 * を解説します。（メインはhtmlの解説になります）
 * この章での解説内容
 * ・フォームに初期値などの値を渡す方法
 * 　→Controlelr側からFormデータに初期値を設定して画面に渡します。
 * ・制御文
 * ・テキストでの出力方法
 * ・属性の扱い方
 * ・ファイルの分割方法(step03にて解説)
 * 
 */
package com.yonetani.study.websample.sample1.step02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonetani.study.websample.sample1.step01.controller.form.Sample1Step01InputForm;
import com.yonetani.study.websample.sample1.step02.controller.form.Sample1Step02InputForm;

/**
 * 「Spring Boot入門:Thymeleafの基本」を表示するコントローラーです。
 * @author user
 *
 */
@Controller
public class Sample1Step02Controller {
	
	/**
	 * 「Spring Boot入門:Thymeleafの基本」画面を初期表示します。
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/sample1/step02/")
	public String step02Index(Model model) {
		
		model.addAttribute("inputForm", createForm());
		
		return "sample1/step02/sample102index";
	}

	/**
	 * 入力したフォームの内容をそのままレスポンスボディにJSON形式で出力します。
	 * 
	 * @param input
	 * @return
	 */
	@PostMapping("/sample1/step02/input")
	@ResponseBody
	public Sample1Step02InputForm step02FormInput(Sample1Step02InputForm input) {
		
		System.out.println(input);
		
		return input;
	}
	
	/**
	 * 「★リスト表示サンプル★」のリンクをクリック時に呼ばれます。
	 * @param model
	 * @return
	 */
	@GetMapping("/sample1/step02/listview")
	public String step02ListView(Model model) {
		
		model.addAttribute("forEach", createList());
		model.addAttribute("nullValue", null);
		model.addAttribute("nonNullValue", "Nullではありません");
		
		return "sample1/step02/sample102listview";
	}

	/**
	 * step02のDTOの初期値を設定して返します。
	 * 
	 * @return
	 */
	private Sample1Step02InputForm createForm() {
		
		// step02 DTO
		Sample1Step02InputForm result = new Sample1Step02InputForm();
		// header data 
		Sample1Step01InputForm hd = new Sample1Step01InputForm();
		hd.setText2("test had add");
		result.setHeaderform(hd);
		// input data
		result.setText("テキストサンプル");
		result.setTextarea("テキストエリア\nサンプル");
		result.setSelect(2);
		result.setRadio("radioTest1");
		result.setCheckbox("one");
		
		return result;
	}
	
	/**
	 * リスト画面に表示するリストの情報を作成して返します。
	 * 
	 * @return
	 */
	private List<String> createList() {
		
		// 画面に表示するリスト情報を作成
		List<String> list = new ArrayList<>();
		list.add("<span>テスト１</span>");
		list.add("<span>テスト２</span>");
		list.add("<span>テスト３　（20文字以上なので画面に出力されない）</span>");
		list.add("<span>テスト４</span>");
		// 逆に、短い文字列を設定
		list.add("<span>1</span>");
		
		return list;
	}
	
}
