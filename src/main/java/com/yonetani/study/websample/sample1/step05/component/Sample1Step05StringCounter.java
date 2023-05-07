/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step5/
 * 
 */
package com.yonetani.study.websample.sample1.step05.component;

import java.util.Objects;

import org.springframework.stereotype.Component;

/**
 * 文字列の長さをカウントして返します。
 * コンポーネント(部品)としてSpringBootに登録します
 * 
 * @author user
 *
 */
@Component
public class Sample1Step05StringCounter {
	
	/**
	 * 引数で指定した文字列の長さを返します。
	 * @param str
	 * @return
	 */
	public int length(String str) {
		if(Objects.isNull(str)) {
			return 0;
		}
		return str.length();
	}
}
