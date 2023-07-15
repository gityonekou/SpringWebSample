/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * USER_COMMENTテーブルで使用するマッパーです
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 */
package com.yonetani.study.websample.sample2.step05.infrastructure.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yonetani.study.websample.sample2.step05.dto.UserCommentReadDto;
import com.yonetani.study.websample.sample2.step05.dto.UserCommentWriteDto;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用する USER_COMMENTテーブルで使用するマッパーです。
 * 「05：Mybatisを使ったデータの保存」
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 * @author user
 *
 */
@Mapper
public interface UserCommentMapper {
	
	/**
	 * USER_COMMENTテーブルの全権検索結果を取得します。
	 * sqlは「sql/selectUserComment.sql」を使います。
	 * 
	 * @return
	 */
	@Select("sql/selectUserComment.sql")
	List<UserCommentReadDto> select();
	
	/**
	 * USER_COMMENTテーブルへのInsertを実行します。
	 * sqlは「sql/insertUserComment.sql」を使います。
	 * 
	 * @param dto
	 */
	@Insert("sql/insertUserComment.sql")
	//@Insert("INSERT INTO USER_COMMENT (NAME, MAILADDRESS, TEXT) VALUES (#{dto.name}, #{dto.mailAddress}, #{dto.comment})")
	void insert(@Param("dto") UserCommentWriteDto dto);
}
