package com.yuyakaido.android.blueprint.app

import android.app.Application
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import com.yuyakaido.android.blueprint.BuildConfig
import com.yuyakaido.android.blueprint.di.AppComponent
import com.yuyakaido.android.blueprint.di.AppModule
import com.yuyakaido.android.blueprint.di.DaggerAppComponent
import javax.inject.Inject

class Blueprint : Application() {

    @Inject
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeTwitter()
        initializeDagger()
    }

    private fun initializeDagger() {
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun initializeTwitter() {
        Twitter.initialize(TwitterConfig.Builder(this)
                .debug(BuildConfig.DEBUG)
                .twitterAuthConfig(TwitterAuthConfig(
                        BuildConfig.TWITTER_CONSUMER_KEY,
                        BuildConfig.TWITTER_CONSUMER_SECRET))
                .build())
    }

}