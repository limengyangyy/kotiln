package mvp

import bean.LoginBean
import com.wd.health.keji.mdoel.utils.ApiHttpUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import utils.APIHttps

/**
 * author: 栗铃涵
 * data: 2019/12/21 10:10:03
 * function
 */
class LoginUtils :Contract.IModel {
    private var utils:APIHttps?=null
    override fun getModel1(phone: String, pwd: String, callBack: CallBack) {

       utils= ApiHttpUtils.instance.create(APIHttps::class.java)
        utils!!.getLogin(phone,pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<LoginBean>() {
                override fun onComplete() {
                    print("xxxxxxxxxxxxxxxxxxxxxxxxxxx")
                }

                override fun onNext(t: LoginBean) {
                    callBack.Desuccess(t)
                }

                override fun onError(e: Throwable) {
                    print("xxxxxxxxxxxxxxxxxxxxx"+e)
                }
            })
    }
}