package com.yuyakaido.android.gaia.di

import android.app.Application
import com.yuyakaido.android.gaia.BuildConfig
import com.yuyakaido.android.gaia.RunningSession
import com.yuyakaido.android.gaia.auth.ui.AuthorizationIntentResolver
import com.yuyakaido.android.gaia.core.android.*
import com.yuyakaido.android.gaia.core.java.AppScope
import com.yuyakaido.android.gaia.core.java.AppStore
import com.yuyakaido.android.gaia.core.java.AvailableEnvironment
import com.yuyakaido.android.gaia.core.java.Environment
import com.yuyakaido.android.gaia.gateway.ui.GatewayIntentResolver
import com.yuyakaido.android.gaia.home.ui.HomeIntentResolver
import com.yuyakaido.android.gaia.repo.detail.ui.RepoDetailIntentResolver
import com.yuyakaido.android.gaia.repo.ui.ProfileFragmentResolver
import com.yuyakaido.android.gaia.repo.ui.RepoFragmentResolver
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @AppScope
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @AppScope
    @Provides
    fun provideAvailableEnvironment(): AvailableEnvironment {
        return AvailableEnvironment(
            environments = listOf(
                Environment(
                    title = "Debug",
                    githubApiEndpoint = BuildConfig.GITHUB_API_ENDPOINT,
                    githubAuthEndpoint = BuildConfig.GITHUB_AUTH_ENDPOINT,
                    githubClientId = BuildConfig.GITHUB_CLIENT_ID,
                    githubClientSecret = BuildConfig.GITHUB_CLIENT_SECRET
                ),
                Environment(
                    title = "Production",
                    githubApiEndpoint = BuildConfig.GITHUB_API_ENDPOINT,
                    githubAuthEndpoint = BuildConfig.GITHUB_AUTH_ENDPOINT,
                    githubClientId = BuildConfig.GITHUB_CLIENT_ID,
                    githubClientSecret = BuildConfig.GITHUB_CLIENT_SECRET
                )
            )
        )
    }

    @AppScope
    @Provides
    fun provideRunningSession(): RunningSession {
        return RunningSession()
    }

    @AppScope
    @Provides
    fun provideAppStore(): AppStore {
        return AppStore()
    }

    @AppScope
    @Provides
    fun provideAuthorizationIntentResolverType(): AuthorizationIntentResolverType {
        return AuthorizationIntentResolver()
    }


    @AppScope
    @Provides
    fun provideGatewayIntentResolverType(): GatewayIntentResolverType {
        return GatewayIntentResolver()
    }

    @AppScope
    @Provides
    fun provideHomeIntentResolverType(): HomeIntentResolverType {
        return HomeIntentResolver()
    }

    @AppScope
    @Provides
    fun provideRepoDetailIntentResolverType(): RepoDetailIntentResolverType {
        return RepoDetailIntentResolver()
    }

    @AppScope
    @Provides
    fun provideRepoFragmentResolverType(): RepoFragmentResolverType {
        return RepoFragmentResolver()
    }

    @AppScope
    @Provides
    fun provideProfileFragmentResolverType(): ProfileFragmentResolverType {
        return ProfileFragmentResolver()
    }

}