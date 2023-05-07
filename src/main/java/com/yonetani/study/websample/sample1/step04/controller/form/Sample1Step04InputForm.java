/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Formと入力チェック(バリデーション)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step4/
 * 
 * 入力画面のformデータを受け取るデータクラス(DTO)です。
 * 
 * また、DTOクラスに入力チェック用のアノテーションを有効とするためにSpring>スターターの追加を選択し
 * 「スタータープロジェクトの依存関係」ウインドウを表示後、「Validation」(または、I/O→Validation)を
 * 依存関係に追加してください。
 * 
 * 以下のようにSpringBoot 3.×からValidationのパッケージがjavaxからjakartaに変更となっているので注意
 * 
 * Java EE 8 -> Jakarta EE 10 (9+)
 * • Java EE の後継 Jakarta EE に移行する事が必須になった (javax.* -> jakarta.*)
 * 
 * 【複数の項目にわたってチェック】
 * 複数の項目にわたってチェックを行う方法(項目1と項目2をあわせたチェック(サンプルのパスワード1、パスワード2
 * が等しいかどうかなど)
 * は以下の方法があります。
 * 
 * １．チェック内容をメソッドにまとめてまとめて単項目のチェックとする。@AssertTrueアノテーションをつける
 * 		@AssertTrueアノテーション：trueであることをチェックする
 * 
 * ２．独自のアノテーションを定義してクラスに定義する
 * ３．Controllerで入力チェックを実装する
 * 
 * ★Controllerへのチェック結果を判定する処理を追加必要★
 * DTOクラスにアノテーションを付けただけでは入力チェックは行われません。Controllerでレスポンスのページを返す
 * 処理でチェック結果を受け取り・判定する必要があります。
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step04.controller.form;

import java.util.Objects;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * formタグの入力に対応するDTO(Data Transfer Object)
 * 
 * @author user
 *
 */
@Data
public class Sample1Step04InputForm {
	/*
	 * 入力チェックを行うアノテーション
	 * @NotNull：nullではない(空文字列、スペース、タブのみは許可される)
	 * @NotEmpty：空でない(nullと空文字列は不可、スペース、タブのみは許可される)
	 * @NotBlank：空白ではない(null、空文字列、スペース、タブのみだと不可)
	 * @Size(min, max)：要素数の範囲を指定、Stringなら文字数、ListやMapなら要素数
	 * @Max、@Min：数値の上限、下限
	 * @Email：メールアドレスとして妥当かチェックする
	 * @Pattern(regex)：指定した正規表現に一致するかをチェックする
	 * @AssertTrue：trueであることをチェックする
	 * 
	 * ★上記以外は以下を参照★
	 * https://penguinlabo.hatenablog.com/entry/springframework/validator
	 * 
	 * 
	 */
	// mail
	@NotEmpty(message = "エラーメッセージを独自に設定")
	@Email
	private String email;
	
	// 数値
	@Min(10)
	@Max(100)
	private Integer integer;
	
	// パスワード1
	@NotNull
	@Size(min = 8, max = 16)
	@Pattern(regexp = "^[0-9a-zA-Z]+$")
	private String password1;
	
	// パスワード2
	@NotNull
	@Size(min = 8, max = 16)
	@Pattern(regexp = "^[0-9a-zA-Z]+$")
	private String password2;
	
	
	/**
	 * パスワード1とパスワード2の値が等しいかどうか
	 * 
	 * @return
	 */
	@AssertTrue(message = "パスワードが一致しません")
	public boolean isSamePassword() {
		// JDK7から追加されたObjectsで2つの文字列(オブジェクト)が等しいかどうかを安全に比較(NullPointerを意識せずに比較)
		// 従来だとthis.password1.equals(this.password2)となり判定前にNullを比較する必要があった
		return Objects.equals(this.password1, this.password2);
	}
}
