/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * 使用するフォームで入力されたメールアドレス項目の値を表すバリュー値を定義したクラスです。
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
 * の以下サンプルで使用するバリュー値：メールアドレスを表すクラスです。
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
public class MailAddress {
	
	// フォームのメールアドレス欄に入力された値です。
	private final String value;
	
	/**
	 * 引数の値をもとにMailAddressを生成します。
	 * @param mailAddress
	 * @return
	 */
	public static MailAddress from(String mailAddress) {
		return new MailAddress(mailAddress);
	}

	@Override
	public String toString() {
		if(Objects.isNull(value)) {
			return "";
		}
		return value;
	}
	
	
}
