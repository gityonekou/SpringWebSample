/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step5/
 * 
 * service登録用のインタフェース「Sample1Step05Service」を実装したコンクリートクラス１です。
 * 
 */
package com.yonetani.study.websample.sample1.step05.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

/**
 * service登録用のインタフェース「Sample1Step05Service」を実装したコンクリートクラス１です。
 * 
 * @author user
 *
 */
@Service
public class Sample1Step05ServiceImpl1 implements Sample1Step05Service {

	private static final String DECORATOR = "*";
	
	/**
	 *引数で指定した文字列の先頭・最後をアスタ「*」で修飾して返します。
	 *
	 */
	@Override
	public String decorate(String target) {
		if(Objects.isNull(target)) {
			return "";
		}
		return DECORATOR + target + DECORATOR;
	}

}
