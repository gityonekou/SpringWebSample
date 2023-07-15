/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * DBに登録されているユーザコメントを全件取得するドメインオブジェクトです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/5ef08e
 */
package com.yonetani.study.websample.sample2.step05.domain.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.yonetani.study.websample.sample2.step05.domain.type.Comment;
import com.yonetani.study.websample.sample2.step05.domain.type.DateTime;
import com.yonetani.study.websample.sample2.step05.domain.type.MailAddress;
import com.yonetani.study.websample.sample2.step05.domain.type.Name;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するDBに登録されているユーザコメントを全件取得するドメインオブジェクトです。
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
public class UserComments {

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	@Getter
	public static class UserComment {
		// ID
		private final int id;
		// 名前
		private final Name name;
		// メールアソレス
		private final MailAddress mailAddress;
		// コメント
		private final Comment comment;
		// 投稿日時
		private final DateTime dateTime;
		
		public static UserComment from(
				int id,
				String name,
				String mailAddress,
				String comment,
				LocalDateTime dateTime) {
			return new UserComment(
					id,
					Name.from(name),
					MailAddress.from(mailAddress),
					Comment.from(comment),
					DateTime.from(dateTime));
		}
		
	}
	// 画面に表示する投稿データ
	private final List<UserComment> values;
	
	/**
	 * 引数の表示データからUserCommentsを生成して返します。
	 * 
	 * @param comments
	 * @return
	 */
	public static UserComments from(List<UserComment> comments) {
		if(CollectionUtils.isEmpty(comments)) {
			return new UserComments(Collections.emptyList());
		} else {
			return new UserComments(comments);
		}
	}
	
}
