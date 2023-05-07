/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門:ThymeleafとController」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step1/
 * 
 * 入力画面のformデータを受け取るデータクラスです。
 * 
 * [lombok]ロンボック／ ロンボク
 * @Dataアノテーション
 * SetterとGetter、toString、equals、hashCodeを生成するアノテーション
 * 
 */
package com.yonetani.study.websample.sample1.step01.controller.form;

import lombok.Data;

/**
 * @author user
 *
 */
@Data
public class Sample1Step01InputForm {
	// text2
	private String text2;
	
	// text3
	private String text3;
	
}
