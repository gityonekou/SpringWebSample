/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のフォーム入力データです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するフォームデータです。
 * 「05：Mybatisを使ったデータの保存」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 *  
 * @author user
 *
 */
@Data
public class Sample2Step05CommentForm {
	// 名前
	@Nullable
	@Length(max = 20)
	private String name;
	
	// メールアドレス
	@Nullable
	@Email
	@Length(max = 100)
	private String mailAddress;
	
	// 投稿内容
	@NotNull
	@Length(min = 1, max = 400)
	private String comment;
}
