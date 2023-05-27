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
package com.yonetani.study.websample.sample1.login.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
		Set<GrantedAuthority> auth = new HashSet<>();
		auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		// テスト用データ(返却するのはorg.springframework.security.core.userdetails.Userなので注意
		// (Sample1Userではない:UserDetailsを実装後でないと返せない))
		User userDetails = new User("test user", "testpass", auth);
		
		System.out.println("★user=[" + username + "]★");
		if(!username.equals("test") ) {
			throw new UsernameNotFoundException("ユーザ名が不正です");
		}
		
		return userDetails;
	}

}
