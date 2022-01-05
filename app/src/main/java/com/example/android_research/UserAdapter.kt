package com.example.android_research

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_research.model.UserModel

class UserAdapter(
    var activity: Activity,
    var list: ArrayList<UserModel>,
    var onItemClick: (UserModel) -> Unit
) :
    RecyclerView.Adapter<UserAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ItemHolder(view);
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var lblName: TextView = view.findViewById(R.id.lbl_Title)
        var lblContent: TextView = view.findViewById(R.id.lbl_Content)
        var layoutClick: LinearLayout = view.findViewById(R.id.layout_Click)
        fun onBind(model: UserModel) {
            lblName.text = model.userName
            lblContent.text = model.description
            layoutClick.setOnClickListener { onItemClick(model) }
        }
    }
}