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

package com.raras.restaturant.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.raras.restaturant.R
import com.raras.restaturant.adapter.MenuAdapter
import com.raras.restaturant.model.MenuListItem
import com.squareup.picasso.Picasso

class MenuFragment : Fragment() {

    private var mContext: Context? = null
    private var mRecyclerView: RecyclerView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_menu, container, false)
        val header = view.findViewById(R.id.menu_image_header) as ImageView
        Picasso.with(mContext).load(R.drawable.menu).into(header)

        mRecyclerView = view.findViewById(R.id.menu_recycler_view) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        mRecyclerView!!.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView!!.adapter = MenuAdapter(mContext, MenuListItem.generateMenu())
        return view
    }
}
