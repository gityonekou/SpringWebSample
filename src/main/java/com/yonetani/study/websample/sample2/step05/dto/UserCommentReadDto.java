/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * USER_COMMENTテーブルの1行のデータを表す(select結果の1行を格納する)DTOです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/5ef08e
 * 
 */
package com.yonetani.study.websample.sample2.step05.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するUSER_COMMENTテーブルの1行のデータを表す(select結果の1行を格納する)DTOです。
 * 「06：MyBatisを使ったデータの取得、その表示」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/5ef08e
 *  
 * @author user
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentReadDto {
	// ID
	private final int id;
	
	// 名前
	private final String name;
	
	// メールアドレス
	private final String mailAddress;
	
	// 投稿内容
	private final String comment;
	
	// 登校時間
	private final LocalDateTime createdAt;
}
