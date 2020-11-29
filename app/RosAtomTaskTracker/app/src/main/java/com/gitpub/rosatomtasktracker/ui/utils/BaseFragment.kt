package com.gitpub.rosatomtasktracker.ui.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.jvmErasure

open class BaseFragment<Binding : ViewBinding>(
    private val bindingClass: KClass<Binding>
) : Fragment() {
    protected lateinit var binding: Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflateMethod =
            bindingClass.members.find {
                it is KFunction &&
                        it.name == "inflate" &&
                        it.parameters.size == 3 &&
                        it.parameters.first().type.jvmErasure == LayoutInflater::class
            } ?: return null
        val binding = inflateMethod.call(inflater, container, false)
        @Suppress("UNCHECKED_CAST")
        this.binding = binding as Binding
        return binding.root
    }
}
