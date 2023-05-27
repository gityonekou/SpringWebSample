/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Securityで認証と認可」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step7/
 * 
 */
package com.yonetani.study.websample.sample1.login.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Sample1用のログインユーザデータです。
 * SAMPLE1_USERテーブルのDTOクラスです。
 * 
 * @author user
 *
 */
@Data
//@Entity
public class Sample1User {
	// ユーザID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	
	// ユーザ名
	@NotNull
	@Size(max = 255)
	private String userName;
	
	// パスワード
	@NotNull
	@Size(max = 30)
	private String password;
	
	// ロール
	@NotNull
	@Size(max = 10)
	private String role;
}
