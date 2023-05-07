/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門:Thymeleafの基本」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step2/
 * 
 * 入力画面のformデータを受け取るデータクラス(DTO)です。
 * 
 * [DAOとDTO]
 * DAO：Data Access Object
 * 　データベースなどのデータストアを操作するインターフェイスを提供するオブジェクトのことです。
 * DTO：Data Transfer Object
 * 　名前の通りデータを転送する目的で定義されるクラスのことです。
 * 　プロパティとアクセサーのみで定義されているクラスで、まさにLombok(ロンボック／ロンボク)にて定義すべきクラスとなります。
 * 　以前はValue Object(値を保持するオブジェクト)と呼ばれていたこともありますが、
 * 　現在はDTOと呼ぶのが基本なので忘れないようように
 * 
 */
package com.yonetani.study.websample.sample1.step02.controller.form;

import com.yonetani.study.websample.sample1.step01.controller.form.Sample1Step01InputForm;

import lombok.Data;

/**
 * formタグの入力に対応するDTO(Data Transfer Object)
 * 
 * @author user
 *
 */
@Data
public class Sample1Step02InputForm {
	
	private Sample1Step01InputForm headerform;
	
	private String text;
	
	private String textarea;
	
	private Integer select;
	
	private String radio;
	
	private String checkbox;
	
}
