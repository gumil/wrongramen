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

package com.raras.restaturant

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import com.raras.restaturant.adapter.ViewPagerAdapter
import com.raras.restaturant.fragment.HomeFragment
import com.raras.restaturant.fragment.MenuFragment
import com.raras.restaturant.fragment.ReserveFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
        setSupportActionBar(toolbar)
        val viewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)
        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "HOME")
        adapter.addFragment(MenuFragment(), "MENU")
        adapter.addFragment(ReserveFragment(), "RESERVE")
        viewPager.adapter = adapter
    }

}
