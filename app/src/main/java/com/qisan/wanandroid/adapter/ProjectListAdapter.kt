package com.qisan.wanandroid.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import com.qisan.wanandroid.R
import com.qisan.wanandroid.databinding.ItemArticleBinding
import com.qisan.wanandroid.databinding.ItemProjectListBinding
import com.qisan.wanandroid.entity.Article
import com.qisan.wanandroid.utils.GlideUtils

/**
 * Created by qisan 2022/6/15
 * com.qisan.wanandroid.adapter
 */
class ProjectListAdapter(private val context: Context): BasePagingDataAdapter<Article,ItemProjectListBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<ItemProjectListBinding> {
        val inflate = ItemProjectListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewBindingHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<ItemProjectListBinding>, position: Int, binding: ItemProjectListBinding, item: Article) {
        val authorStr = item.author.ifEmpty { item.shareUser }
        holder.binding.itemProjectListTitleTv.text = Html.fromHtml(item.title)
        holder.binding.itemProjectListContentTv.text = Html.fromHtml(item.desc)
        holder.binding.itemProjectListTimeTv.text = item.niceDate
        holder.binding.itemProjectListAuthorTv.text = authorStr
        holder.binding.itemProjectListLikeIv.setImageResource(if (item.collect) R.drawable.ic_like else R.drawable.ic_like_not)
        GlideUtils.load(context,item.envelopePic,holder.binding.itemProjectListIv)
    }
}