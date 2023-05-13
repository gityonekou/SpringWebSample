/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Securityで認証と認可」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step7/
 * 
 * [Spring Security]
 * version 6.0.*基準の実装にてコーティングしています。
 * 上記サンプルではWebSecurityConfigurerAdapterは非推奨→6.*からは削除となっているところを対応済みです
 * 
 */
package com.yonetani.study.websample.sample1.login.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Sample1用のログインプロバイダーです。
 * AuthenticationManagerに登録され認証処理が行われます。
 * 
 * @author user
 *
 */
public class Sample1AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	/**
	 *　UserDetails に何かしらの追加チェックを行いたい場合はここに実装する
	 *　・ログイン状態フラグがログアウトであること
	 *　・ログインリトライ回数が3回未満など。独自の仕様を実装できる
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	/**
	 *　パスワードチェックを行う
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
