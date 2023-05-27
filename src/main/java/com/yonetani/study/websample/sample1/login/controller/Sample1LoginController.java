/**
 * SpringBootの勉強用プロジェクトです
 * 土谷の備忘録(びぼうろく)ブログ内サンプルに遷移するための認証で、
 * ログインページ初期表示用コントローラーです。
 * ログインページ初期表示のget要求を処理します。
 * 
 * 土谷の備忘録(びぼうろく)
 * https://www.tsuchiya.blog/spring-boot-tutorial/
 * 
 */
package com.yonetani.study.websample.sample1.login.controller;

/**
 * ログインページ初期表示用コントローラーです。
 * ログインページ初期表示のget要求を処理します。
 * 
 * @author user
 *
 */
public class Sample1LoginController {

//	/**
//	 * ログインページを初期表示します。
//	 * (get要求時にこのメソッドが呼ばれます。
//	 * ログイン認証時(post要求時)はSample1LoginSecurityConfigの設定内容が処理されます
//	 * (つまり、コントローラーで処理することはできません)
//	 * 
//	 * @return
//	 */
	// .sample1.login.controller配下でこのマッピングを登録するloginのリダイレクトが循環してしまいます。
	// /login/のGetマッピングはSample1MenuControllerで定義するとこの問題は回避できるみたい、
	// なぜこうなるのかは、よくわからないので調べる必要あり
//	@GetMapping("/login/")
//	public String getLogin() {
//		return "login";
//	}
}
