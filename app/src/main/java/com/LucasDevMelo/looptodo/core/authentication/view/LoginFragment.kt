package com.LucasDevMelo.looptodo.core.authentication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.LucasDevMelo.looptodo.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    //para forçar que o binding não seja mais nullabe
    private val binding get() = _binding!!
    private lateinit var loginCallback: LoginCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
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
        binding.btnCreate.setOnClickListener {
            loginCallback.onCreateAccountClicked()
        }
    }

    //Para quando a view for destruída, destruir tambem a conecção da interface gráfica
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}