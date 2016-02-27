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

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.raras.restaturant.R
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private var mContext: Context? = null

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        mContext = activity
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        val imageLogo = view.findViewById(R.id.home_image_logo) as ImageView
        val imageOpening = view.findViewById(R.id.home_image_opening) as ImageView
        val imageMap = view.findViewById(R.id.home_image_map) as ImageView
        val imageInauthentic = view.findViewById(R.id.home_image_inauthentic) as ImageView

        Picasso.with(mContext).load(R.drawable.logo).into(imageLogo)
        Picasso.with(mContext).load(R.drawable.opening).into(imageOpening)
        Picasso.with(mContext).load(R.drawable.google_map).into(imageMap)
        Picasso.with(mContext).load(R.drawable.inauthentic).into(imageInauthentic)
        return view
    }
}
