package com.gitpub.rosatomtasktracker.ui.utils

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

//open class BaseActivity<Binding : ViewBinding>(
//    private val bindingClass: KClass<Binding>
//) : FragmentActivity(), DIAware {
//    override val di by di()
//
//    protected lateinit var binding: Binding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initializeViewBinding()
//    }
//
//    private fun initializeViewBinding() {
//        val inflateMethod =
//            bindingClass.members.find {
//                it is KFunction &&
//                        it.name == "inflate" &&
//                        it.parameters.size == 1 &&
//                        it.parameters.first().type.jvmErasure == LayoutInflater::class
//            } ?: return
//        val binding = inflateMethod.call(LayoutInflater.from(this))
//        @Suppress("UNCHECKED_CAST")
//        this.binding = binding as Binding
//        setContentView(binding.root)
//    }
//}

inline fun <T : ViewBinding> Activity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}