/**
 * SpringBootの勉強用プロジェクトです。
 * 土谷の備忘録(びぼうろく)ブログ内サンプル「Spring Boot入門：ServiceとDI(依存性の注入)」をコーディングしています。
 * https://www.tsuchiya.blog/spring-boot-step5/
 * 
 * Sprign Bootが管理するクラスのインスタンス（@Controller、@Service、@Component、@Repositoryなど）の
 * フィールドに@Autowiredアノテーションを付けると、Spring Bootが自動的に対象クラスのインスタンスをこのフィールドに
 * 格納してくれます。つまり、DI可能となります。
 * 
 * 【なぜコンストラクタインジェクションが推奨されるのか】
 * https://qiita.com/yuto-hatano/items/69d01343f710117e4243
 * 
 * 記述量を増やさずに簡単にかけてしまうのであれば、フィールドインジェクションで良いのでは？
 * と思った方もいるのではないでしょうか。
 * コンストラクタインジェクションが推奨されている観点としては様々あるようですが、
 * 個人的には下記の3つが大事かなと思っています。
 * 
 * [単一責任の原則]
 * オブジェクト指向の言語における設計原則の一つに「SOLID原則」というものがあります。
 * 単一責任の原則とは「SOLID原則」の中で提唱された原則の一つで、簡単に言うと「1つのクラスは1つだけの
 * 責任（機能）を持たなければならない。」という思想です。
 * 
 * コンストラクタインジェクションが煩雑に感じる（記述が多く見える）場合、少なくともそのクラスは数多くの
 * 機能をインジェクションしている（＝依存関係が多い）ことになります。
 * 
 * 
 * [コンストラクタが不変性を持てること]
 * フィールドをfinal宣言できるため、イミュータブル（状態を変更することができない）なオブジェクトにしたり、
 * 必要な依存関係のみを不変にすることができます。
 * 
 * フィールドインジェクションの場合、final宣言はできないため依存関係は変更可能なままとなります
 * 
 * [循環依存することを防げる]
 * コンストラクタインジェクションでfinal宣言している場合、コンストラクタ呼び出しのタイミングでDIの設定が完了し、
 * その後は先述の通りイミュータブルになります
 * そのため、循環依存が起きている場合、アプリケーション起動時に警告が出ます。
 * その他2つのインジェクション（フィールドインジェクション、セッターインジェクション）については、
 * 実際に対象のDIコンテナが呼び出されるまでは問題を検知することができません。
 * 
 * 【そもそも、コンストラクターインジェクションの方が単体テストが楽にできるようです】
 * https://qiita.com/kmuro/items/aead50c699fefe56c120
 * 　@Autowiredの場合、SpringBootの自動生成でフレームワーク関連のコンテキストやDB関連の情報が必要になるので
 * 　テストが厄介になるということみたい。
 * 
 * 
 */
package com.yonetani.study.websample.sample1.step05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yonetani.study.websample.sample1.step05.service.Sample1Step05Service;
import com.yonetani.study.websample.sample1.step05.service.Sample1Step05ServiceImpl1;
import com.yonetani.study.websample.sample1.step05.service.Sample1Step05ServiceImpl2;

/**
 * 「Spring Boot入門:ServiceとDI(依存性の注入)」を表示するコントローラーです。
 * 
 * @author user
 *
 */
@Controller
public class Sample1Step05Controller {

	private static final String TEST_STR = "テスト対象文字列";
	
	// final修飾してコンストラクター初期化以外でのサービスの変更を不可とします。
	// Springで推奨する方法となります。
	private final Sample1Step05Service service1;
	private final Sample1Step05Service service2;
	
	// フィールドインジェクションの例(ここでは使わない)
	//@Autowired
	//@Qualifier("mainServiceImpl1")
	// private MainService service1;
	
	/**
	 * コンストラクター
	 * 
	 * Spring4.3以上なら@Autowiredアノテーション省略可 SpringBootにて自動で呼び出し。DI管理されます。
	 * ※Spring Boot 3.0.6→Spring Framework 6.0.8
	 * 
	 * 今回、コンストラクターインジェクションを実現するために引数の型をコンクリートクラスで指定することで
	 * DIを可能としています。
	 * この方法がいいのかどうかは今後検証が必要とはなるかと思う。フィールドのクラスをコンクリートの型にするなど
	 * ただ、この方法であればフィールドで持つサービスを一つ(不変)とできるので、フィールドインジェクションよりはいいのか？？
	 * そもそも、一つのコントローラーに依存するのが一つのサービスというのはクラスが多くなりすぎるというのはあるが、
	 * どうするか。。
	 * 
	 * @param service1
	 * @param service2
	 */
	// @Autowired // → Spring4.3以上ならこのアノテーション省略可
	public Sample1Step05Controller(Sample1Step05ServiceImpl1 service1, Sample1Step05ServiceImpl2 service2) {
		this.service1 = service1;
		this.service2 = service2;
	}
	
	/**
	 * 「Spring Boot入門：ServiceとDI(依存性の注入)」を初期表示します。
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/sample1/step05/")
	public String step05Index(Model model) {
		model.addAttribute("value1", service1.decorate(TEST_STR));
		model.addAttribute("value2", service2.decorate(TEST_STR));
		return "/sample1/step05/sample105index";
	}
}
