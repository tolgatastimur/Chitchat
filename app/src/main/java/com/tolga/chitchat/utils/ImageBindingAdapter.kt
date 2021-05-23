package com.tolga.chitchat.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun setImageUrl(imageView: ImageView?, imageUrl: String?) {
        ifNotNull(imageView, imageUrl, { view, url ->
            Glide.with(view.context)
                    .load(url)
                    .into(view)
        })
    }

    @JvmStatic
    @BindingAdapter("bind:circleImageUrl", "bind:circleImagePlaceHolder", requireAll = false)
    fun setCircleImageUrl(imageView: ImageView, imageUrl: String?, placeHolder: Drawable?) {
        Glide.with(imageView.context)
                .load(imageUrl)
                .placeholder(placeHolder)
                .transform(CircleCrop())
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("visibleInVisibleIf")
    fun visibleInVisibleIf(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("enableIf")
    fun changeEnabled(view: View, isEnabled: Boolean) {
        view.isEnabled = isEnabled
    }

    @JvmStatic
    @BindingAdapter("app:src")
    fun setImageResource(imageView: ImageView, resourceId: Int) {
        imageView.setImageResource(resourceId)
    }
}
