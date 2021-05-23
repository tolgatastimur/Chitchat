package com.tolga.chitchat.ui.conversation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tolga.chitchat.R
import com.tolga.chitchat.databinding.ItemOtherMessageBinding
import com.tolga.chitchat.databinding.ItemOwnMessageBinding
import com.tolga.chitchat.domain.models.Message
import com.tolga.chitchat.utils.Constants
import com.tolga.chitchat.utils.isNull
import com.tolga.chitchat.utils.notNull
import javax.inject.Inject

class MessagesAdapter @Inject constructor() :
    ListAdapter<Message, RecyclerView.ViewHolder>(MessagesDiffCallBack()) {

    private var context: Context? = null
    private val ownMessage = -1
    private lateinit var itemOtherMessageBinding: ItemOtherMessageBinding
    private lateinit var itemOwnMessageBinding: ItemOwnMessageBinding

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["messageSetItems"])
        fun messagesSetAdapter(
            view: RecyclerView?,
            data: ArrayList<Message>?
        ) {
            view.notNull { v ->
                v.adapter.isNull { v.adapter = MessagesAdapter() }
                data?.let { (v.adapter as MessagesAdapter).submitList(it) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == ownMessage) {
            itemOwnMessageBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_own_message, parent, false)
            OwnMessageAdapterViewHolder(itemOwnMessageBinding)
        } else {
            itemOtherMessageBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_other_message, parent, false)
            OtherMessageAdapterViewHolder(itemOtherMessageBinding)
        }
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        context?.let {
            if (holder.itemViewType == ownMessage) {
                (holder as OwnMessageAdapterViewHolder).bindData(
                    currentList.get(position)

                )
            } else {
                (holder as OtherMessageAdapterViewHolder).bindData(
                    currentList.get(position)
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (currentList.get(position).user.id == Constants.UserID.OWN) return ownMessage
        return super.getItemViewType(position)
    }

    class OwnMessageAdapterViewHolder(
        private val binding: ItemOwnMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            message: Message?
        ) {
            binding.message = message
        }
    }

    class OtherMessageAdapterViewHolder(
        private val binding: ItemOtherMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            message: Message?
        ) {
            binding.message = message
        }
    }
}

class MessagesDiffCallBack : DiffUtil.ItemCallback<Message>() {

    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }


}
