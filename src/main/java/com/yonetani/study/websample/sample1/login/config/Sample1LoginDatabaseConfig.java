/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Securityで認証と認可」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step7/
 * 
 * [Spring Security]
 * version 6.0.*基準の実装にてコーティングしています。
 * 参考ページは以下に変更となります。
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/1c1ebe
 * 
 */
package com.yonetani.study.websample.sample1.login.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import lombok.RequiredArgsConstructor;

/**
 * Login処理時のデータベースコンフィグレーションクラスです。
 * 
 * @author user
 *
 */
@Configuration
@RequiredArgsConstructor
public class Sample1LoginDatabaseConfig {
	
	private final DataSource datasource;
	
	/**
	 * データベースを用いた認証を行うためのUserDetailsManagerをAuthenticationManagerに登録する。
	 * 
	 * @return
	 */
	@Bean
	public UserDetailsManager getJDBCUserDetailsManager() {
		return new JdbcUserDetailsManager(datasource);
	}
	
	/**
	 * パスワードのハッシュ化を行うアルゴリズムを返す
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		// return new BCryptPasswordEncoder();
		// 上記の書き方から公式の推奨方法変更(https://qiita.com/so_kun/items/64ffcc780cba5f904fea)
		// 将来的な移行の容易さなどを考慮して、Bcrypt のみではなく noop や sha256 など、他のエンコード方式も包括して対応できるようにする
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
