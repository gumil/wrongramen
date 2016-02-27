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

package com.raras.restaturant.model

import java.util.ArrayList

class MenuListItem(val name: String, val description: String) {
    companion object {

        fun generateMenu(): ArrayList<MenuListItem> {
            val list = ArrayList<MenuListItem>()
            list.add(MenuListItem("Tonkotsu (Rich) • PHP 395", "If you will only eat here once: " + "A deep and milky pork bone broth. Served with sliced chashu"))
            list.add(MenuListItem("Tantanmen • PHP 395", "You're gonna ask for it anyway: " + "A bold sesame broth with ground pork and shredded chashu"))
            list.add(MenuListItem("Tonkotsu (Light) • PHP 290", "If you're sensitive to pork fat:" + "A lighter version of our signature tonkotsu ramen"))
            list.add(MenuListItem("The Communist • PHP 395", "Inspired by hotpots: " + "7 Asian spices in a fiery pork broth topped with sliced chashu"))
            list.add(MenuListItem("FU Ramen • PHP 425", "Your breakfast in liquid form: " + "Spam, bacon, cheese, and fried egg in a garlic pepper broth"))
            list.add(MenuListItem("Sea Men Ramen • PHP 345", "We hope you get the joke: " + "Clams. squid, and shrimp in a light seafood broth"))
            list.add(MenuListItem("Crispy Pata Ssam • PHP 795", "5 hour slow-cooked and deep fried crispy pork leg served with lettuce and homemade sauce"))
            list.add(MenuListItem("Chicken Akuma • PHP 245", "Japanese fried chicken in asian buffalo sauce"))
            list.add(MenuListItem("Red Cow Tamagoyaki • PHP 255", "Corned beef and shitake mushroom egg roll"))
            list.add(MenuListItem("Bacon & Cheese Katsu • PHP 265", "Deep fried bacon & cheese with sweet wasabi"))
            list.add(MenuListItem("Chashu Rice Rolls • PHP 125", "Shredded chashu rolled in rice wrappers"))
            list.add(MenuListItem("Tofu Katsu • PHP 125", "Golden brown and crispy silken tofu"))
            list.add(MenuListItem("Giant Oyster Katsu • PHP 255", "Golden brown and crispy Japanese oysters"))
            list.add(MenuListItem("Mochi Ice Cream • PHP 85", "Black Sesame / Red Bean / Green Tea"))
            list.add(MenuListItem("Poop Of The Gods • PHP 135", "Belgian chocolate with sea salt and olive oil"))
            list.add(MenuListItem("", "")) //workaround for bug
            return list
        }
    }
}
