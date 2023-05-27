/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Securityで認証と認可」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step7/
 * 
 */
package com.yonetani.study.websample.sample1.login.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Sample1用のUserDetailsServiceです。
 * Sample1LoginSecurityConfigにてBean登録して認証を行います。
 * ログインプロバイダーを使わないパターンです。
 * Spring Bootで使うユーザ情報の取得を行います。
 * 
 * @author user
 *
 */
public class Sample1UserDetailsServiceImpl implements UserDetailsService {

	/**
	 *　引数のユーザ名に対応するユーザ情報がDBに登録されているかを判定します。
	 *　認証OKの場合はそのユーザ情報を返却します。
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		Set<GrantedAuthority> auth = new HashSet<>();
		//auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		auth.add(new SimpleGrantedAuthority("ROLE_USER"));
		// テスト用データ(返却するのはorg.springframework.security.core.userdetails.Userなので注意
		// (Sample1Userではない:UserDetailsを実装後でないと返せない))
		User userDetails = new User("test", "testpass", auth);
		
		System.out.println("■user=[" + username + "]■");
		if(!username.equals("test") ) {
			throw new UsernameNotFoundException("ユーザ名が不正です");
		}
		
		return userDetails;
	}

}
