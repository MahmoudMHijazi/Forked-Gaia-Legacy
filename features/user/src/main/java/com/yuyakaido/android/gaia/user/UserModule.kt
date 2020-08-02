package com.yuyakaido.android.gaia.user

import android.app.Application
import androidx.room.Room
import com.yuyakaido.android.gaia.core.domain.app.AppScope
import com.yuyakaido.android.gaia.core.domain.repository.UserRepositoryType
import com.yuyakaido.android.gaia.core.infrastructure.RetrofitForPrivate
import com.yuyakaido.android.gaia.user.infrastructure.local.MeDatabase
import com.yuyakaido.android.gaia.user.infrastructure.remote.UserApi
import com.yuyakaido.android.gaia.user.infrastructure.repository.UserRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserModule {

  @AppScope
  @Provides
  fun provideUserApi(
    @RetrofitForPrivate retrofit: Retrofit
  ): UserApi {
    return retrofit.create(UserApi::class.java)
  }

  @AppScope
  @Provides
  fun provideMeDatabase(
    application: Application
  ): MeDatabase {
    return Room
      .databaseBuilder(
        application,
        MeDatabase::class.java,
        MeDatabase::class.java.simpleName
      )
      .build()
  }

  @AppScope
  @Provides
  fun provideUserRepositoryType(
    api: UserApi,
    database: MeDatabase
  ): UserRepositoryType {
    return UserRepository(
      api = api,
      database = database
    )
  }

}