package mvp

import bean.LoginBean

/**
 * author: 栗铃涵
 * data: 2019/12/21 09:9:48
 * function
 */
interface CallBack {
    fun Desuccess(loginBean: LoginBean)
    fun Error(ememme:String)
}