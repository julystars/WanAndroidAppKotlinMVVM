package com.qisan.wanandroid.global

import com.google.gson.Gson
import com.qisan.wanandroid.constant.Constant
import com.qisan.wanandroid.entity.LoginInfo
import com.qisan.wanandroid.entity.UserInfo
import com.qisan.wanandroid.utils.SharePreferenceUtils

/**
 * Created by QiSan 2022/6/15
 * package com.qisan.wanandroid.global
 */
object WanUser {

    var loginInfo: LoginInfo? = null

    fun isLogin(): Boolean{
        val loginInfoStr: String by SharePreferenceUtils(Constant.LOGIN_INFO, "")
        loginInfo = Gson().fromJson(loginInfoStr,LoginInfo::class.java)
        return loginInfo != null
    }

    fun getLogin(): LoginInfo{
        val loginInfoStr: String by SharePreferenceUtils(Constant.LOGIN_INFO, "")
        return Gson().fromJson(loginInfoStr,LoginInfo::class.java)
    }

}