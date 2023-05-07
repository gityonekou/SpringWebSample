/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Thymeleafのファイル分割」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step3/
 * 
 * この章では2章「Thymeleafの基本」にて一覧に挙げたThymeleafのファイルを複数に分割する方法を３章として解説します。
 * 共通部分を切り出してDRY原則をHTMLにも適応できるようになります。
 * DRY原則：同じようなコードを重複させないという意味ではないので注意
 * (場合によっては、差分プログラミングのためだけに継承を使わないということと:Java Silverより)
 * DRY原則：ソフトウェア開発全体において情報を重複させない
 * 
 * Thymeleafファイルの分割にはpom.xmlに「nz.net.ultraq.thymeleaf」に依存関係を追加する必要があります。
 * 
 */
package com.yonetani.study.websample.sample1.step03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 「Spring Boot入門:Thymeleafのファイル分割」を表示するコントローラーです。
 * @author user
 *
 */
@Controller
public class Sample1Step03Controller {

	/**
	 * 「Spring Boot入門：Thymeleafのファイル分割」を初期表示します。
	 * @param model
	 * @return
	 */
	@GetMapping("/sample1/step03/")
	public String step03Index(Model model) {
		model.addAttribute("title", "コンテンツページ");
		return "sample1/step03/sample103contents";
	}
}
