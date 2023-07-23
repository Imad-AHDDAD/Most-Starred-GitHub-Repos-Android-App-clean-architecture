package com.a7dev.moststarredgithubrepos_cleanarchitecture.ui.common

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:imageSrc")
fun setImageSrc(imageView: ImageView, imageSrcId: Int?){
    if (imageSrcId != null) {
        imageView.setBackgroundResource(imageSrcId)
    }
}