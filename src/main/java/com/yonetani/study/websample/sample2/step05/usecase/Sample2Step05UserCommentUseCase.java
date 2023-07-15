/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * 掲示板のサービスを提供するサービスクラスです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.usecase;

import org.springframework.stereotype.Service;

import com.yonetani.study.websample.sample2.step05.domain.model.UserComment;
import com.yonetani.study.websample.sample2.step05.domain.model.UserCommentRepository;
import com.yonetani.study.websample.sample2.step05.domain.model.UserComments;
import com.yonetani.study.websample.sample2.step05.form.Sample2Step05CommentForm;

import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * 
 * 「05：Mybatisを使ったデータの保存」サービス
 * 「06：MyBatisを使ったデータの取得、その表示」サービス
 * を提供するサービスクラスです。
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 *  
 * @author user
 *
 */
@Service
@RequiredArgsConstructor
public class Sample2Step05UserCommentUseCase {
	
	private final UserCommentRepository repository;
	
	/**
	 * ユーザの書き込みをDBに反映し、表示データをController(プレゼンテーション層)に
	 * 返します。
	 * 
	 * ※表示データ用のDTOはstep06にて実装するためここでは返却値なしで実装します。
	 * 
	 * @param commentForm
	 */
	public void write(Sample2Step05CommentForm commentForm) {
		
		// フォームオブジェクトからドメインオブジェクトへ変換
		UserComment userComment = UserComment.from(
				commentForm.getName(),
				commentForm.getMailAddress(),
				commentForm.getComment());
		
		// USER_COMMENTテーブルから直近20件のデータを取得し、今回の投稿内容と同じものがあればエラーを返す
		
		// 投稿内容をUSER_COMMENTテーブルに反映する
		repository.save(userComment);
		
		// USER_COMMENTテーブルから直近20件のデータを取得し返す
		
	}
	
	/**
	 * 表示データを全件取得します。
	 * 
	 * @return
	 */
	public UserComments read() {
		return repository.select();
	}
}
