/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「04：PRGパターンの適用とバリデーション」のフォーム入力データです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/104c03
 * 
 * 入力データのバリデーションを実装しています。
 * なお、pomにバリデーションの依存を追加必要です
 * 			<groupId>org.springframework.boot</groupId>
 * 			<artifactId>spring-boot-starter-validation</artifactId>
 * 
 */
package com.yonetani.study.websample.sample2.step04.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するフォームデータです。
 * 「04：PRGパターンの適用とバリデーション」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/104c03
 *  
 * @author user
 *
 */
@Data
public class Sample2Step04CommentForm {
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
