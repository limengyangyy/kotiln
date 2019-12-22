package mvp

import bean.RegisterBean
import com.wd.health.keji.mdoel.utils.ApiHttpUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import utils.APIHttps

/**
 * author: 栗铃涵
 * data: 2019/12/21 10:10:54
 * function
 */
class RegisterUtils:Contract1.IModel {
    private var apis:APIHttps?=null
    override fun getmodel(phone: String, nickName: String, pwd: String, callback1: CallBack1) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        apis= ApiHttpUtils.instance.create(APIHttps::class.java)
            apis!!.getRegister(phone,nickName,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :DisposableObserver<RegisterBean>(){
                    override fun onComplete() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        print("mmmmmmmmmmmmmmmmmmmm")
                    }

                    override fun onNext(t: RegisterBean) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        callback1.Desuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    print("mmmmmmmmmmmmmmm"+e)
                    }

                })
    }




}