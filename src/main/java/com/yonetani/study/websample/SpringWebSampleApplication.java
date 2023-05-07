/*
 *********************************
 * SpringBootのインターネットサンプルをコーディングしてみたアプリケーションです
 * 一つにまとめられるサンプルは「SpringWebSampleApplication」内で実装します。
 * 
 * こちらのサンプルをもとに、マイ家計簿を作成します。
 * 
 * トップメニュー
 * アプリケーション内URL：root/index
 * 
 * 参考ページ１
 * 「土谷の備忘録(びぼうろく)」
 * https://www.tsuchiya.blog/spring-boot-tutorial/
 * 
 * アプリケーション内URL：root/sample1/***
 * 
 *********************************
 */

package com.yonetani.study.websample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebSampleApplication.class, args);
	}

}
