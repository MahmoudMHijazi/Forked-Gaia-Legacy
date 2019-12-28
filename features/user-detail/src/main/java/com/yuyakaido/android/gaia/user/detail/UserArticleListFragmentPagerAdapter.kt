package com.yuyakaido.android.gaia.user.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yuyakaido.android.gaia.core.domain.app.AppRouterType
import com.yuyakaido.android.gaia.core.domain.entity.User

class UserArticleListFragmentPagerAdapter(
  manager: FragmentManager,
  private val router: AppRouterType,
  private val detail: User.Detail
) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  override fun getPageTitle(position: Int): CharSequence? {
    return UserArticleListPage.values()[position].name
  }

  override fun getCount(): Int {
    return UserArticleListPage.values().size
  }

  override fun getItem(position: Int): Fragment {
    return UserArticleListPage.values()[position].fragment.invoke(router, detail)
  }

}