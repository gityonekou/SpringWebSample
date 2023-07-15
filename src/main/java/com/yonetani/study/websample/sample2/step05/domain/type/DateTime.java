/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * 表示する投稿日時の値を表すバリュー値を定義したクラスです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/5ef08e
 * 
 */
package com.yonetani.study.websample.sample2.step05.domain.type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用する投稿日時の値を表すバリュー値です。
 * 「06：MyBatisを使ったデータの取得、その表示」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/5ef08e
 *  
 * @author user
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTime {
	// 投稿日時
	private final LocalDateTime value;
	
	/**
	 * 日付の値からDateTimeのインスタンスを生成して返します。
	 * 
	 * @param dateTime
	 * @return
	 */
	public static DateTime from(LocalDateTime dateTime) {
		return new DateTime(dateTime);
	}
	
	@Override
	public String toString() {
		return value.format(DateTimeFormatter.ISO_DATE_TIME);
	}
}
