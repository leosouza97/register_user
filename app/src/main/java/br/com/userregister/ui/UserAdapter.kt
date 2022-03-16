package br.com.userregister.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.userregister.R
import br.com.userregister.data.User

class UserAdapter : ListAdapter<User, UserAdapter.ViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_card, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: User) {
        val textName = itemView.findViewById<TextView>(R.id.tv_name)
        val textLastName = itemView.findViewById<TextView>(R.id.tv_lastname)

        textName.text = item.name
        textLastName.text = item.lastName
    }
}


}

class DiffCallback: DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem == newItem
    override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

}