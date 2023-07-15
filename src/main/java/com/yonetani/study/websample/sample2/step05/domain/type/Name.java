/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * 使用するフォームで入力された名前項目の値を表すバリュー値を定義したクラスです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.domain.type;

import java.util.Objects;

import groovy.transform.EqualsAndHashCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するバリュー値：名前を表すクラスです。
 * 「05：Mybatisを使ったデータの保存」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 * @author user
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Name {
	
	// フォームの名前欄に入力された値です。
	private final String value;
	
	/**
	 * 引数の値をもとにNameを生成します。
	 * 
	 * @param name
	 * @return
	 */
	public static Name from(String name) {
		return new Name(name);
	}

	/**
	 * 引数で渡された値とNameがラップする値が等しいかどうかを判定します。
	 * 
	 * 引数がStringになっているので、Object#equals(Object obj)メソッドのオーバーライドではない点に注意
	 * 
	 * @param name
	 * @return
	 */
	public boolean equals(String name) {
		return value.equals(name);
	}

	@Override
	public String toString() {
		if(Objects.isNull(value)) {
			return "名無しさん";
		}
		return value;
	}

	
}
