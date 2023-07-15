/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * USER_COMMENTテーブルへのINSERTに使用するDTOです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.dto;

import com.yonetani.study.websample.sample2.step05.domain.model.UserComment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するUSER_COMMENTテーブルへのINSERTに使用するDTOです。
 * 「05：Mybatisを使ったデータの保存」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 * @author user
 *
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentWriteDto {
	// 名前
	private final String name;
	
	// メールアドレス
	private final String mailAddress;
	
	// 投稿内容
	private final String comment;
	
	/**
	 * ドメインオブジェクトを元にUserCommentDtoを生成して返します。
	 * @param userComment
	 * @return
	 */
	public static UserCommentWriteDto from (UserComment userComment) {
		return new UserCommentWriteDto(
				userComment.getName().toString(),
				userComment.getMailAddress().toString(),
				userComment.getComment().toString());
	}
}
