/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step5/
 * 
 * service登録用のインタフェースです。
 * サンプル用のサービス[@Serviceアノテーションで修飾したクラス]箱のインタフェースを実装してください。
 * 
 */
package com.yonetani.study.websample.sample1.step05.service;

/**
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」
 * サービスのコンクリートクラスで実装するインタフェースです。
 * （つまり、サービスについては独自のIFを定義できます）
 * 
 * @author user
 *
 */
public interface Sample1Step05Service {
	
	/**
	 * 引数で指定した文字列を修飾して返します。
	 * 
	 * @param target
	 * @return
	 */
	public String decorate(String target);
}
