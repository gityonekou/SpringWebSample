/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Data JPAでデータベース操作」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step6/
 * 
 * RepositoryインタフェースではEntityクラスに対する操作を定義します。
 * 解説でもあるように、決められたルールに沿ってインタフェース名、メソッド(メソッド名は固定)を定義すれば
 * 実装はすべてSpring Data JPAが行ってくれます。SQLやJavaのコードを自分で書かなくても良いので非常に楽にまります。
 * 
 * サンプル以外のメソッド(自動生成するSQL機能のルール)については以下を参照
 * https://qiita.com/shindo_ryo/items/af7d12be264c2cc4b252
 * 
 * JPAに対応しているクエリは基本単項目の検索になっている？？
 * 家計簿作るときはMyBatis(マイバティス)をメインで考えたほうがよさそう
 * どのORマッパーを使うかを検討→SQLがどういうものになるかを考えないといけない。UIレベルでの検討事項ということか。。
 * 
 * レポジトリを用いたデータの永続化という概念はとても難しい。
 * https://qiita.com/mikesorae/items/ff8192fb9cf106262dbf
 * 
 * DDD
 * https://zenn.dev/kohii/articles/e4f325ed011db8
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step06.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yonetani.study.websample.sample1.step06.model.Sample1Step06BookEntity;

/**
 * SAMPLE1_STEP06_BOOKテーブルのレポジトリです。
 * データの永続化を行います。
 * 
 * @author user
 *
 */
// @Repository 最新のJPAを使えばレポジトリアノテーションは不要です
public interface Sample1Step06Repository extends JpaRepository<Sample1Step06BookEntity, Long>{
	
	/*
	 * デフォルトで以下のメソッドが定義されます。
	 * (JpaRepositoryから継承される)
	 * 下記以外にもたくさんあるので詳しくはドキュメントを参照
	 * 
	 * ・save：引数のインスタンスをデータベースに保存する
	 * ・findById：指定したIDでデータベースからインスタンスを取得する
	 * ・findAll：データベースからすべての行のインスタンスを取得する
	 * ・count：テーブルにある行数を取得する
	 * ・delete：引数のインスタンスをデータベースから削除する
	 * ・existsById：指定したIDがデータベースに存在するかどうかを返す
	 * 
	 */
	
	/*
	 * また、ルールに従って独自にメソッドを定義できます。実装はJPAが自動で行います。
	 */
	
	/**
	 * タイトルに完全一致したインスタンスを一つだけ取得
	 * 
	 * @param title
	 * @return
	 */
	Optional<Sample1Step06BookEntity> findByTitle(String title);
	
	/**
	 * タイトルを前方一致で検索した結果をリストで取得
	 * 
	 * @param prefix
	 * @return
	 */
	List<Sample1Step06BookEntity> findByTitleStartingWith(String prefix);
}
