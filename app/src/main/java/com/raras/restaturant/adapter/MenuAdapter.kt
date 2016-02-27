/*
 * Copyright (C) 2016 Miguel Panelo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.raras.restaturant.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.raras.restaturant.R
import com.raras.restaturant.model.MenuListItem

import java.util.ArrayList

class MenuAdapter(private val mContext: Context?, private val mMenuListItems: ArrayList<MenuListItem>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.row_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuListItem = mMenuListItems[position]
        holder.textViewName.text = menuListItem.name
        holder.textViewDescription.text = menuListItem.description
    }

    override fun getItemCount(): Int {
        return mMenuListItems.size
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView
        val textViewDescription: TextView

        init {
            textViewName = itemView.findViewById(R.id.menu_text_meal) as TextView
            textViewDescription = itemView.findViewById(R.id.menu_text_description) as TextView
        }
    }
}