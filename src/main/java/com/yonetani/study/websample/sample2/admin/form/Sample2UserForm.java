/**
 * SpringBootの勉強用プロジェクトです。
 * 
 * ユーザ登録画面のフォーム入力データです。
 * 
 */
package com.yonetani.study.websample.sample2.admin.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザ登録画面のフォーム入力データです。
 * 
 * @author user
 *
 */
@Data
public class Sample2UserForm {

	// ユーザ名
	@NotNull
	@Size(max = 20)
	// ^先頭[***]文字定義*0個以上$末尾
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String userName;
	
	// パスワード
	@NotNull
	@Size(max = 64)
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	private String password;
	
	// ロール
	@NotNull
	@Size(max = 10)
	private String role;
}
