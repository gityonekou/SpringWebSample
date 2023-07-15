/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：Spring Securityで認証と認可」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step7/
 * 
 * [Spring Security]
 * version 6.0.*基準の実装にてコーティングしています。
 * 上記サンプルではWebSecurityConfigurerAdapterは非推奨→6.*からは削除となっているところを対応済みです
 * 
 * [ログインエラー時のメッセージ日本語化など]
 * 以下のサイトで修正方法がわかります。
 * このサイトの内容も取り込んでから家計簿アプリを作りたい
 * https://qiita.com/t-yama-3/items/a538d47b8f0a27639d23
 * 
 * [CSRF：しーさーふ（クロスサイトリクエストフォージェリ）]
 * SpringBootではthymelrefのth:actionを用いることでCSRF対策を自動で組み込みます。
 * つまり、開発者側が意図的にしーさーふのためのロジックを別途用意する必要はありません。
 * 詳しくは、以下サイトを参考に(こちらの人はMybatisのサンプルも載せているので、あわせて理解したい)
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/f0683a
 * ＜上ページにある徳丸本は買っておいていいかも＞
 * 
 * 
 */
package com.yonetani.study.websample.sample1.login.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
		
		// csrf除外対象
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
		// 同一ドメインでiframeを許可する設定
		http.headers(headers -> headers.frameOptions().sameOrigin());
		
		// アクセス権限に関する設定
		http.authorizeHttpRequests(authz -> authz
				// cssなど、静的なリソースはアクセス制限をかけない(permitAll)
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				// /と/login/はアクセス制限をかけない
				.requestMatchers("/").permitAll()
				// h2コンソールへのアクセスはすべてOK
				// 本番環境時、H2DBは起動しないように設定しておく必要あり
				// サービスが起動していないからnot foundエラーが帰ることを確認要
				// パス:http://localhost:8080/h2-console/
				//.requestMatchers("/h2-console/**").hasRole("ADMIN")
				.requestMatchers("/h2-console/**").permitAll()
				// まとめて書くこともOKです。好きなほうで
				//.requestMatchers("/", "/login/").permitAll()
				// /sample1/adminはADMINロールを持つユーザだけアクセス可能
				// :名前はROLE_ADMINとなることに注意
				.requestMatchers("/sample2/admin").hasRole("ADMIN")
				// /sample1/**はUSERロールを持つユーザだけがアクセス可能
				// 実際のアプリではrequestMatchers("/**").hasRole("USER")となるのかな？？
				// ユーザ権限でアクセスするパスは後々検討が必要
				.requestMatchers("/menu/**").hasRole("USER")
				.requestMatchers("/sample1/**").hasRole("USER")
				.requestMatchers("/sample2/**").hasRole("USER")
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
				.loginProcessingUrl("/login/")
				// ログイン画面へのパス
				.loginPage("/login/").permitAll()
				// 認証失敗時に呼ばれるハンドラクラス：これを指定した場合、.failureUrl()は無視されれる
				// 認証失敗時は単純にログイン失敗時の画面に遷移すればいいだけではない(失敗の種類に応じて
				// 発生する例外を分けたいなどの要件があるなど、その場合は独自のハンドラを作成することでできそう
				//.failureHandler(new MyWebToolAppAuthenticationFailureHandler())
				// ログインに失敗した場合の遷移先
				.failureUrl("/login/")
				// ログイン成功時
				//.defaultSuccessUrl("/menu/")
				// 第2引数にtureを指定した場合、別のターゲット(ログイン画面表示前にアクセスしたURLがデフォルトの遷移先ではない)を指定して
				// ログイン画面に遷移した場合でもデフォルト画面に遷移させることができる(つまり、必ずトップ画面に遷移させる場合はtrueを指定、
				// ログイン後のショートカットを有効にする場合はfalseを指定
				//.defaultSuccessUrl("/sample1/", true)
				.defaultSuccessUrl("/menu/", true)
				
				// ユーザ名とパスワードのネーム指定
				.usernameParameter("username")
				.passwordParameter("password")
		);
		
		// ログアウトに関する設定
		http.logout(logout -> logout
				// ログアウト処理のパス(POSTの場合:SpringではログアウトはデフォルトでPOSTを送ることが前提になっているので注意)
				// この設定だと、/logoutにPOSTするとログアウト処理が行われる
				.logoutUrl("/logout/")
				// GETでログアウトを行う場合：ただし、特殊な事情がないとGETでログアウトはない気がする(getでユーザ名などのパラメータを直でかかないとだし
				//.logoutRequestMatcher(new AntPathRequestMatcher("/sample1/logout"))
				// ログアウト完了時の遷移先:ここではindex画面になる
				.logoutSuccessUrl("/")
				// カスタム LogoutSuccessHandler を指定する場合。これを指定すると、logoutSuccessUrl() は無視されます
				// .logoutSuccessHandler(logoutSuccessHandler)
				// ログアウト時にセッションを無効にする(デフォルトtrueのためコメントアウト
				// .invalidateHttpSession(true)
				// ログアウト完了時、指定のクッキーを削除
				// JSESSIONIDはログイン時にCSRFトークンが保存されているクッキーでもあります。
				// 詳しくは、ファイルヘッダ記載のCSRF解説のページを参照
				.deleteCookies("JSESSIONID")
		);
		
		// build結果を返す
		return http.build();
	}
	
//	/**
//	 * 推奨されないので、コメントアウト
//	 * https://qiita.com/suke_masa/items/908805dd45df08ba28d8
//	 * 
//	 * 静的リソースへの認証不要の設定は上記のhttp.authorizeHttpRequestsメソッドでのアクセス権限に関する設定時に
//	 * 行う方が推奨されている。
//	 * WebSecurityCustomizerをBean登録する場合、そのURLへはセキュリティが完全に機能しなくなるので、セキュリティフォールとなる
//	 * ことに注意です。
//	 * 
//	 * @return
//	 */
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//	}
//	
//	
	/*
	 * [TIPS]誰がUserDetailsManager/PasswordEncoderを使うのか
	 * ★SpringSecurityではAuthenticationManagerに認証のための処理を追加する形に新・旧出変わりはありません★
	 * →関連はこちらを参照：https://qiita.com/nannou/items/2363b37516f6228a4b9d
	 * 
	 * SpringSecurity5.7より以前では、掲題の機能を使うために AuthenticationManagerBuilder というクラス
	 * を使用していました。<土谷の備忘録(びぼうろく)ブログ内サンプル>
	 * 
	 * SpringSecurity5.7からは、SpringSecurityがAuthenticationManagerを作成する際に、DIコンテナに存在
	 * しているUserDetailsManager, PasswordEncoderを使用するようになっています。
	 * <あしたば>
	 * <Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン>
	 * https://zenn.dev/angelica/books/52be1e365c61ea
	 * この無料本のChapter 08
	 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/1c1ebe
	 * 
	 * この無料本は一度全部確認することを進める。。。
	 * 
	 * ★つまり、以下のソースはDBのConfigを作成してそちらに移したほうがわかりやすいと思われ。
	 * Sample1LoginDatabaseConfig.javaに移動しています。
	 * 
	 */
//	/**
//	 * パスワードのハッシュ化を行うアルゴリズムを返す
//	 * 
//	 * @return
//	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		// return new BCryptPasswordEncoder();
//		// 上記の書き方から公式の推奨方法変更(https://qiita.com/so_kun/items/64ffcc780cba5f904fea)
//		// 将来的な移行の容易さなどを考慮して、Bcrypt のみではなく noop や sha256 など、他のエンコード方式も包括して対応できるようにする
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	
//	/**
//	 * UserDetailsServiceを使ってユーザ認証(ユーザ名で認証)を実装する場合、
//	 * この方法でいけるかを確認。こちらを有効にする場合はAuthenticationProviderを削除すること
//	 * インメモリ形式での認証のパターン　DBを使う場合は以下公式を参考にすること
//	 * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//	 * ※こちらはユーザ登録からログインまでを実装しています。
//	 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/1c1ebe
//	 * 
//	 * @return
//	 */
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		UserDetailsService sl = new Sample1UserDetailsServiceImpl();
//		sl.
//		return ;
//	}
//	public InMemoryUserDetailsManager getUserDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("test")
//                .password("testpass")
//                .roles("USER")
//                .build();
//            return new InMemoryUserDetailsManager(user);
//	}
//	/**
//	 * Sample1用のログインプロバイダーをBean登録する。<br>
//	 * ここら辺の仕組みは以下URLを確認する。<br>
//	 * https://qiita.com/nannou/items/2363b37516f6228a4b9d
//	 * 
//	 * @return
//	 */
//	@Bean
//	public AuthenticationProvider getAuthenticationProvider() {
//		// Sample1用のログインプロバイダーをBean登録する。
//		// ここら辺の仕組みは以下URLを確認するとわかると思います。
//		// https://qiita.com/nannou/items/2363b37516f6228a4b9d
//		// 上記サンプルの概略図のAuthenticationManagerが管理するAuthenticationProviderを登録する形となります。
//		// 通常の認証ではユーザID,パスワードを用いて行うので、それ以上の情報で認証を行う場合は独自のフィルターを実装しないといけない
//		// ことになるみたいです。（上記URLより)
//		return new Sample1AuthenticationProvider();
//	}
}
  