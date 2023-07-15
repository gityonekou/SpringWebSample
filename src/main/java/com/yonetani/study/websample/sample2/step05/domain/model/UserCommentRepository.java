/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * USER_COMMENTテーブルで使用するリポジトリです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 */
package com.yonetani.study.websample.sample2.step05.domain.model;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するUSER_COMMENTテーブルで使用するリポジトリです。
 * 「05：Mybatisを使ったデータの保存」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 * @author user
 *
 */
public interface UserCommentRepository {
	
	/**
	 * UserCommentオブジェクトの内容をUSER_COMMENTテーブルに出力します。
	 * @param userComment
	 */
	void save(UserComment userComment);

	/**
	 * USER_COMMENTテーブルに格納されているデータを全件取得します。
	 * 
	 * @return
	 */
	UserComments select();
}
