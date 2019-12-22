package utils

import bean.LoginBean
import bean.RegisterBean
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * author: 栗铃涵
 * data: 2019/12/20 20:20:22
 * function
 */
interface APIHttps {
    @POST("techApi/user/v1/login")
    fun getLogin(@Query("phone")pho:String,@Query("pwd")p:String):Observable<LoginBean>
    //注册
    @POST("techApi/user/v1/register")
    fun getRegister(@Query("phone")pho:String,@Query("nickName")nickName:String,@Query("pwd")p:String):Observable<RegisterBean>
}