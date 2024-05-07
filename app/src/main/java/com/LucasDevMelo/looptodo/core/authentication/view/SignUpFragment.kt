package com.LucasDevMelo.looptodo.core.authentication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.LucasDevMelo.looptodo.R
import com.LucasDevMelo.looptodo.databinding.FragmentSignUpBinding

class SignUpFragment: Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    //para forçar que o binding não seja mais nullabe
    private val binding get() = _binding!!
    private lateinit var loginCallback: LoginCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    //é disparado toda vex que é anexado
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if ( context is LoginCallback ) {
            loginCallback = context
        }
    }

    //É disparada quando a view é criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24)
        //evento de touch
        binding.toolbar.setNavigationOnClickListener {
            loginCallback.onLoginClicked()
        }
    }

    //Para quando a view for destruída, destruir tambem a conecção da interface gráfica
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}