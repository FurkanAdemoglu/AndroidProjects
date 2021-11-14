package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.MarsPhoto
import com.example.android.marsphotos.overview.PhotoGridAdapter


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    /**
     * let scope function
    let is one of Kotlin's Scope functions which lets you execute a code block within the context of an object. There are five Scope functions in Kotlin, refer to the documentation to learn more.

    Usage:

    let is used to invoke one or more functions on results of call chains.

    The let function along with safe call operator( ?.) is used to perform a null safe operation on the object. In this case, the let code block will only be executed if the object is not null.

    Inside the bindImage() function, add a let{} block to the imageURL argument, using the safe call operator.

     */

    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }

    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView,
                         data: List<MarsPhoto>?) {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }
}