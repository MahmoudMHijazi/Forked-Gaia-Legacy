package com.yuyakaido.android.gaia

import com.yuyakaido.android.gaia.article.detail.ArticleDetailActivity
import com.yuyakaido.android.gaia.article.detail.ArticleDetailModule
import com.yuyakaido.android.gaia.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector
  abstract fun contributeHomeActivity(): HomeActivity

  @ContributesAndroidInjector(
    modules = [ArticleDetailModule::class]
  )
  abstract fun contributeArticleDetailActivity(): ArticleDetailActivity

}