package com.LucasDevMelo.looptodo.core.authentication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.LucasDevMelo.looptodo.R


//chamara de volta a atividade, baseado em um evento de ação
interface LoginCallback{
    fun onCreateAccountClicked()
    fun onLoginClicked()
}
class LoginActivity : AppCompatActivity(), LoginCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onCreateAccountClicked() {
        val fragment = SignUpFragment()
        supportFragmentManager.commit {
            //trocar fragmento atual
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_out,
                R.anim.slide_out
            )
            replace(R.id.fragment_container_view, fragment)
            addToBackStack(null)
        }
        //aqui irá responder o evento de touch
    }

    override fun onLoginClicked() {
        supportFragmentManager.popBackStack()
    }
}