/**
 * SpringBootの勉強用プロジェクトです
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * ★本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea
 * 
 * 「05：Mybatisを使ったデータの保存」のサンプル
 * 「06：MyBatisを使ったデータの取得、その表示」のサンプル
 * 
 * USER_COMMENTテーブルで使用するリポジトリを実装したデータソースです。
 * 
 * 本家リンク
 * https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 * 
 */
package com.yonetani.study.websample.sample2.step05.infrastructure.datasource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.yonetani.study.websample.sample2.step05.domain.model.UserComment;
import com.yonetani.study.websample.sample2.step05.domain.model.UserCommentRepository;
import com.yonetani.study.websample.sample2.step05.domain.model.UserComments;
import com.yonetani.study.websample.sample2.step05.dto.UserCommentReadDto;
import com.yonetani.study.websample.sample2.step05.dto.UserCommentWriteDto;

import lombok.RequiredArgsConstructor;

/**
 * Zenn あしたば　の「Javaの基礎を学び終えたアナタに贈る, SpringBoot/SpringSecurityによる掲示板開発ハンズオン」
 * の以下サンプルで使用するUSER_COMMENTテーブルで使用するリポジトリを実装したデータソースです。
 * 「05：Mybatisを使ったデータの保存」
 * 「06：MyBatisを使ったデータの取得、その表示」
 * 
 * 本家リンク
 *  https://zenn.dev/angelica/books/52be1e365c61ea/viewer/2e7c96
 *  
 * @author user
 *
 */
@Repository
@RequiredArgsConstructor
public class UserCommentDataSource implements UserCommentRepository {
	
	private final UserCommentMapper mapper;
	
	@Override
	public void save(UserComment userComment) {
		mapper.insert(UserCommentWriteDto.from(userComment));
	}

	@Override
	public UserComments select() {
		List<UserCommentReadDto> dtos= mapper.select();
		return UserComments.from(
				dtos.stream().map(dto -> UserComments.UserComment.from(
					dto.getId(),
					dto.getName(),
					dto.getMailAddress(),
					dto.getComment(),
					dto.getCreatedAt())).collect(Collectors.toUnmodifiableList()));
	}

}
