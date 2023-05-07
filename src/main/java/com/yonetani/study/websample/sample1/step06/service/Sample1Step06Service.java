/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Data JPAでデータベース操作」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step6/
 * 
 */
package com.yonetani.study.websample.sample1.step06.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yonetani.study.websample.sample1.step06.model.Sample1Step06BookEntity;
import com.yonetani.study.websample.sample1.step06.repository.Sample1Step06Repository;

import lombok.RequiredArgsConstructor;

/**
 * 「Spring Boot入門：Spring Data JPAでデータベース操作」のサービスです。
 * 
 * 業務ロジックを実装します
 * 
 * @author user
 *
 */
@Service
@RequiredArgsConstructor
public class Sample1Step06Service {
	
	// Step06レポジトリ
	private final Sample1Step06Repository repository;
	
	/**
	 * 入力したタイトルを書籍データベースに登録する
	 * 
	 * @param title
	 */
	public void save(String title) {
		Sample1Step06BookEntity book = new Sample1Step06BookEntity();
		book.setTitle(title);
		this.repository.save(book);
	}
	
	/**
	 * すべての書籍データを返す
	 * 
	 * @return
	 */
	public List<Sample1Step06BookEntity> findAll() {
		return this.repository.findAll();
	}
	
	/**
	 * タイトルを前方一致で検索した結果をリストで取得
	 * 
	 * @param prefix
	 * @return
	 */
	public List<Sample1Step06BookEntity> findByTitleStartingWith(String prefix) {
		return this.repository.findByTitleStartingWith(prefix);
	}
	
	/**
	 * タイトルに完全一致したインスタンスを一つだけ取得
	 * 
	 * @param title
	 * @return
	 */
	public Sample1Step06BookEntity findByTitle(String title) {
		return this.repository.findByTitle(title).get();
	}
}
