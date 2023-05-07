/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step5/
 * 
 * service登録用のインタフェース「Sample1Step05Service」を実装したコンクリートクラス２です。
 * 
 * 内部でDIとして登録したコンポーネント「Sample1Step05StringCounter」を使用します。
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step05.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.yonetani.study.websample.sample1.step05.component.Sample1Step05StringCounter;

import lombok.RequiredArgsConstructor;

/**
 * service登録用のインタフェース「Sample1Step05Service」を実装したコンクリートクラス２です。
 * 内部でDIとして登録したコンポーネント「Sample1Step05StringCounter」を使用します。
 * 
 * @author user
 *
 */
@Service
// 「@RequiredArgsConstructor」はfinalなフィールドを引数にとるコンストラクターを自動で生成するアノテーションです
@RequiredArgsConstructor
public class Sample1Step05ServiceImpl2 implements Sample1Step05Service {

	// DIコンポーネント:文字列カウンター
	private final Sample1Step05StringCounter counter;
	
	/**
	 * 引数で指定した文字列の最後に文字列長を追加して返します。
	 * 指定した文字列がnullの場合は空文字列を返します。
	 * 
	 */
	@Override
	public String decorate(String target) {
		if(Objects.isNull(target)) {
			return "";
		}
		return target + counter.length(target);
	}

}
