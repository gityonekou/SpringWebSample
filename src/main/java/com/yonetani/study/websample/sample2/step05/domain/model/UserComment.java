/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 
 * 掲示板コメントで入力した内容を表すドメインオブジェクトです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.domain.model;

import java.util.Random;

import com.yonetani.study.websample.sample2.step05.domain.type.Comment;
import com.yonetani.study.websample.sample2.step05.domain.type.MailAddress;
import com.yonetani.study.websample.sample2.step05.domain.type.Name;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するドメインオブジェクト：掲示板コメントを表すクラスです。
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
public class UserComment {
	// 名前
	private final Name name;
	// メールアソレス
	private final MailAddress mailAddress;
	// コメント
	private final Comment comment;
	
	/**
	 * 引数の値をもとにUserCommentを生成して返します。
	 * 
	 * @param name
	 * @param mailAddress
	 * @param comment
	 * @return
	 */
	public static UserComment from(String name, String mailAddress, String comment) {
		return new UserComment(
				Name.from(name),
				MailAddress.from(mailAddress),
				Comment.from(comment));
	}
	
	/**
	 * 名前が「!おみくじ」ならば御神籤の結果を返す、そうでない場合はNameの値を返す
	 * 
	 * @return
	 */
	public Name getName() {
		if(!name.equals("!おみくじ")) return name;
		int random = new Random().nextInt(3);
		switch (random) {
			case 0:
				return Name.from("大吉");
			case 1:
				return Name.from("中吉");
			default:
				return Name.from("小吉");
		}
	}
	
	/**
	 * コメントの内容を検査し、リンクなどがある場合は削除してから新しいCommentを生成して返す
	 * 
	 * @return
	 */
	public Comment getComment() {
		if(comment.toString().indexOf("<link data str>") != -1) {
			return Comment.from("リンク貼り付けがあるので削除した結果をここに格納");
		}
		return comment;
		
	}
	
}
