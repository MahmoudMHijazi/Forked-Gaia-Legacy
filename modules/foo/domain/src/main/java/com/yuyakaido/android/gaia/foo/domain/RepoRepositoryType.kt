package com.yuyakaido.android.gaia.foo.domain

import com.yuyakaido.android.gaia.core.Repo
import io.reactivex.Single

interface RepoRepositoryType {
    fun fetchRepos(query: String): Single<List<Repo>>
}