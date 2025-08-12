//package com.gorzo.recyclerview


package com.gorzo.recyclerview

import android.content.Context
import android.content.Intent
import android.content.SyncContext
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class PostRvAdapter(val context: Context, val posts: List<Post>) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)
        return PostViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        holder.tvTitle.text = currentPost.title
        holder.tvBody.text = currentPost.body
        holder.tvUserId.text = currentPost.userId.toString()
        holder.crvPost.setOnClickListener {
            val intent = Intent(context, ViewPostActivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return posts.size
    }
}


class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvtitle)  // check exact casing here
    val tvBody: TextView = itemView.findViewById(R.id.tvBody)
    val tvUserId: TextView = itemView.findViewById(R.id.tvuserId)  // watch out here for casing

    val crvPost: View = itemView.findViewById<ConstraintLayout>(R.id.crvPost)
}

