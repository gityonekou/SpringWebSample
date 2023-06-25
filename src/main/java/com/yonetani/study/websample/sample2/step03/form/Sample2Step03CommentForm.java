/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * のうち、作成したサンプルをメニュー表示します。
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「03：掲示板の入力フォームを作る」のフォーム入力データです。
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/3adab0
 */
package com.yonetani.study.websample.sample2.step03.form;

import lombok.Data;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するフォームデータです。
 * 「03：掲示板の入力フォームを作る」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/3adab0
 *  
 * @author user
 *
 */
@Data
public class Sample2Step03CommentForm {
	private String name;
	private String mailAddress;
	private String comment;
}
