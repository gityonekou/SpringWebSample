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

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門」のログイン処理のConfigです。<br>
 * サンプルにあるWebSecurityConfigurerAdapterは非推奨→6.*からは削除となっているので
 * 注意(サンプルソースは最新版で対応済み)
 * 
 * @author user
 *
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Sample1LoginSecurityConfig {

	/**
	 * 各種セキュリティパラメータを設定します。
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// アクセス権限に関する設定
		http.authorizeHttpRequests(authz -> authz
				// cssなど、静的なリソースはアクセス制限をかけない(permitAll)
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				// /sample1/と/sample1/loginはアクセス制限をかけない
				.requestMatchers("/sample1/").permitAll()
				.requestMatchers("/sample1/login").permitAll()
				// /sample1/adminはADMINロールを持つユーザだけアクセス可能
				// :名前はROLE_ADMINとなることに注意
				.requestMatchers("/sample1/admin").hasRole("ADMIN")
				// /sample1/**はUSERロールを持つユーザだけがアクセス可能
				// 実際のアプリではrequestMatchers("/**").hasRole("USER")となるのかな？？
				// ユーザ権限でアクセスするパスは後々検討が必要
				.requestMatchers("/sample1/**").hasRole("USER")
				// その他すべてのURLに対して認証を要求
				.anyRequest().authenticated()
		);

		// ログインに関する設定
		/* ※今までのラムダ式：メソッドチェーンを使わない書き方は以下のようになりますよ。。
		 * どっちが使いやすいかは、各自の判断だとはおもうが、今の流れはメソッドチェーンを使うほうなのかな
		 * ちなみに、loginは可変オブジェクトのはず。。(不変だと、メソッドチェーンで書く意味はある
		http.formLogin(login -> {
			// メソッドチェーンを使わない場合(普通の1行で指定する方法)
			login.loginProcessingUrl("");
			login.loginPage("");
			login.failureUrl("");
			// メソッドチェーンを使った書き方
			login.loginProcessingUrl("")
			.loginPage("")
			.failureUrl("");
			
			int test = 0;
			
		});
		 */
		http.formLogin(login -> login
				// ログイン認証処理のパス
				// この設定だと、/loginにPOSTするとログイン処理を行う
				// つまり、ログインページのアクションで指定するURLを指定する
				.loginProcessingUrl("/sample1/login")
				// ログイン画面へのパス
				.loginPage("/sample1/login")
				// 認証失敗時に呼ばれるハンドラクラス：これを指定した場合、.failureUrl()は無視されれる
				// 認証失敗時は単純にログイン失敗時の画面に遷移すればいいだけではない(失敗の種類に応じて
				// 発生する例外を分けたいなどの要件があるなど、その場合は独自のハンドラを作成することでできそう
				//.failureHandler(new MyWebToolAppAuthenticationFailureHandler())
				// ログインに失敗した場合の遷移先
				.failureUrl("/sample1/login")
				// ログイン成功時
				//.defaultSuccessUrl("/sample1/")
				// 第2引数にtureを指定した場合、別のターゲット(ログイン画面表示前にアクセスしたURLがデフォルトの遷移先ではない)を指定して
				// ログイン画面に遷移した場合でもデフォルト画面に遷移させることができる(つまり、必ずトップ画面に遷移させる場合はtrueを指定、
				// ログイン後のショートカットを有効にする場合はfalseを指定
				.defaultSuccessUrl("/sample1/", true)
				// ユーザ名とパスワードのネーム指定
				.usernameParameter("username")
				.passwordParameter("password")
		);
		
		// ログアウトに関する設定
		http.logout(logout -> logout
				// ログアウト処理のパス(POSTの場合:SpringではログアウトはデフォルトでPOSTを送ることが前提になっているので注意)
				// この設定だと、/logoutにPOSTするとログアウト処理が行われる
				.logoutUrl("/sample1/logout")
				// GETでログアウトを行う場合：ただし、特殊な事情がないとGETでログアウトはない気がする(getでユーザ名などのパラメータを直でかかないとだし
				//.logoutRequestMatcher(new AntPathRequestMatcher("/sample1/logout"))
				// ログアウト完了時の遷移先:ここではsample1のログイン画面になる
				.logoutSuccessUrl("/sample1/")
				// カスタム LogoutSuccessHandler を指定する場合。これを指定すると、logoutSuccessUrl() は無視されます
				// .logoutSuccessHandler(logoutSuccessHandler)
				// ログアウト時にセッションを無効にする(デフォルトtrueのためコメントアウト
				// .invalidateHttpSession(true)
				// ログアウト完了時、指定のクッキーを削除
				.deleteCookies("JSESSIONID")
		);
		
		// build結果を返す
		return http.build();
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
	
	/**
	 * Sample1用のログインプロバイダーをBean登録する。<br>
	 * ここら辺の仕組みは以下URLを確認する。<br>
	 * https://qiita.com/nannou/items/2363b37516f6228a4b9d
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		// Sample1用のログインプロバイダーをBean登録する。
		// ここら辺の仕組みは以下URLを確認するとわかると思います。
		// https://qiita.com/nannou/items/2363b37516f6228a4b9d
		// 上記サンプルの概略図のAuthenticationManagerが管理するAuthenticationProviderを登録する形となります。
		// 通常の認証ではユーザID,パスワードを用いて行うので、それ以上の情報で認証を行う場合は独自のフィルターを実装しないといけない
		// ことになるみたいです。（上記URLより)
		return new Sample1AuthenticationProvider();
	}
}
  