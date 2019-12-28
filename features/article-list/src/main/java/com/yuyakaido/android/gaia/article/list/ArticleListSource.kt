package com.yuyakaido.android.gaia.article.list

import android.os.Parcelable
import com.yuyakaido.android.gaia.core.domain.entity.Article
import com.yuyakaido.android.gaia.core.domain.entity.Community
import com.yuyakaido.android.gaia.core.domain.entity.User
import com.yuyakaido.android.gaia.core.domain.repository.ArticleRepositoryType
import com.yuyakaido.android.gaia.core.domain.value.EntityPaginationItem
import kotlinx.android.parcel.Parcelize

sealed class ArticleListSource : Parcelable {

  abstract suspend fun articles(
    repository: ArticleRepositoryType,
    after: String?
  ): EntityPaginationItem<Article>

  @Parcelize
  object Popular : ArticleListSource() {
    override suspend fun articles(
      repository: ArticleRepositoryType,
      after: String?
    ): EntityPaginationItem<Article> {
      return repository
        .articlesOfCommunity(
          path = "popular",
          after = after
        )
    }
  }

  @Parcelize
  data class CommunityDetail(
    val community: Community.Summary
  ) : ArticleListSource() {
    override suspend fun articles(
      repository: ArticleRepositoryType,
      after: String?
    ): EntityPaginationItem<Article> {
      return repository
        .articlesOfCommunity(
          community = community,
          after = after
        )
    }
  }

  @Parcelize
  data class Submit(
    val user: User
  ) : ArticleListSource() {
    override suspend fun articles(
      repository: ArticleRepositoryType,
      after: String?
    ): EntityPaginationItem<Article> {
      return repository
        .articlesOfUser(
          user = user,
          after = after
        )
    }
  }

  @Parcelize
  data class Upvote(
    val user: User
  ) : ArticleListSource() {
    override suspend fun articles(
      repository: ArticleRepositoryType,
      after: String?
    ): EntityPaginationItem<Article> {
      return repository
        .articlesOfUser(
          user = user,
          path = "upvoted",
          after = after
        )
    }
  }

  @Parcelize
  data class Downvote(
    val user: User
  ) : ArticleListSource() {
    override suspend fun articles(
      repository: ArticleRepositoryType,
      after: String?
    ): EntityPaginationItem<Article> {
      return repository
        .articlesOfUser(
          user = user,
          path = "downvoted",
          after = after
        )
    }
  }

}