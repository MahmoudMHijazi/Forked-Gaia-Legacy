package com.yuyakaido.android.gaia.subreddit.detail

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yuyakaido.android.gaia.core.GaiaType
import com.yuyakaido.android.gaia.core.ListingDataResponse
import com.yuyakaido.android.gaia.core.Subreddit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SubredditDetailViewModel(
  application: Application
) : AndroidViewModel(
  application
) {

  private val service = getApplication<GaiaType>().redditAuthService

  val title = MutableLiveData<String>()
  val thumbnail = MutableLiveData<Uri>()

  fun onBind(subreddit: Subreddit) {
    title.postValue(subreddit.title)
    thumbnail.postValue(subreddit.thumbnail)
    service
      .comments()
      .enqueue(object : Callback<List<ListingDataResponse>> {
        override fun onResponse(call: Call<List<ListingDataResponse>>, response: Response<List<ListingDataResponse>>) {
          Timber.d(response.toString())
        }
        override fun onFailure(call: Call<List<ListingDataResponse>>, t: Throwable) {
          Timber.e(t.toString())
        }
      })
  }

}