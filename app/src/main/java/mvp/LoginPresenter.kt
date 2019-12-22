package mvp

import bean.LoginBean
import com.wd.kj.MainActivity

/**
 * author: 栗铃涵
 * data: 2019/12/22 18:18:42
 * function
 */
class LoginPresenter (iView:MainActivity):Contract.IPresenter(){
    private var model:LoginUtils?=null
    private var iView :Contract.IView?=null
    init {
        model= LoginUtils()
        this.iView=iView
    }
    override fun getPresenter(phone: String, pwd: String) {
        model!!.getModel1(phone,pwd,object :CallBack{
            override fun Desuccess(loginBean: LoginBean) {
                if(iView!=null){
                    iView!!.Desuccess(loginBean)
                }
            }

            override fun Error(ememme: String) {
            }

        })
    }
}