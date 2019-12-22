package com.wd.kj


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bean.LoginBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_regist.*
import mvp.Contract
import mvp.LoginPresenter

class MainActivity : AppCompatActivity(), Contract.IView {
    private var presenter:LoginPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         presenter = LoginPresenter(this)
        btn_login!!.setOnClickListener {
            val phone = login_edit_phone.text.toString()
            val lock = login_edit_lock.text.toString()
            if(phone.equals("")||lock.equals("")){
                Toast.makeText(this,"账号密码不能为空",Toast.LENGTH_SHORT).show()
            }else{
                val publicKey = RsaCoder.encryptByPublicKey(lock)
                presenter!!.getPresenter(phone,publicKey)
            }
        }

        btn_zhuce!!.setOnClickListener {
            val intent1= Intent(this, RegistActivity::class.java)
            startActivity(intent1)
        }
    }
    override fun Desuccess(loginBean: LoginBean) {
       val loginBean1=loginBean as LoginBean
       val message =loginBean.message
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        if(loginBean1.status.equals("0000")){
        val inteny=Intent(this,ShowActivity::class.java)
            startActivity(inteny)
        }
    }

    override fun Error(ememme: String) {
    }

}
