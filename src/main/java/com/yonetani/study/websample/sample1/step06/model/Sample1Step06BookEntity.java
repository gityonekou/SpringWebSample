/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Data JPAでデータベース操作」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step6/
 * 
 * DBテーブル：BOOKに対応するエンティティのDTOです。
 * 
 * クラス名はテーブル名をパスカルケース
 * にしたもの、フィールド名はカラム名をキャメルケースにしたものになります。
 * テーブル名やカラム名にアンダーバーがある場合はそこを区切りにして名前をつけます。
 * 例
 * テーブル名)TABLE_NAME→TableName
 * カラム名)CALAM_NAME→calamName
 * 
 * また、テーブルを定義したときにカラムにつけた制約は、Entityクラスでも同じようにアノテーションで制約
 * を定義するように心がけましょう（面倒だからと手を抜かないように）
 * 
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step06.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DBテーブル：BOOKに対応するエンティティのDTOです
 * 
 * @author user
 *
 */
@Entity
@Data
public class Sample1Step06BookEntity {

	/*
	 * @Idアノテーション：主キーであること
	 * @GeneratedValue(strategy)アノテーション：自動採番
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * null不可
	 * MAX長：255文字
	 */
	@NotNull
	@Size(max = 255)
	private String title;
	
}
