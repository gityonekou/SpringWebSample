/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * 使用するフォームで入力されたコメント項目の値を表すバリュー値を定義したクラスです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.domain.type;

import groovy.transform.EqualsAndHashCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するバリュー値：コメントを表すクラスです。
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
public class Comment {

	// フォームのコメント欄に入力された値です。
	private final String value;
	
	/**
	 * 引数の値をもとにCommentを生成します。
	 * 
	 * @param comment
	 * @return
	 */
	public static Comment from(String comment) {
		return new Comment(comment); 
	}

	@Override
	public String toString() {
		return value;
	}
	
	
}
