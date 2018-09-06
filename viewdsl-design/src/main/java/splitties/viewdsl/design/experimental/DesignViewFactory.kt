/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package splitties.viewdsl.design.experimental

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import splitties.viewdsl.core.experimental.styles.Style
import splitties.viewdsl.design.fixedimpls.FixedAppBarLayoutBehavior

inline fun <reified V : View> instantiateDesignView(
        clazz: Class<out V>,
        context: Context,
        @Suppress("UNUSED_PARAMETER") style: Style<V>?
): V? = when (clazz) {
    FloatingActionButton::class.java -> FloatingActionButton(context)
    AppBarLayout::class.java -> object : AppBarLayout(context), CoordinatorLayout.AttachedBehavior {
        override fun getBehavior(): CoordinatorLayout.Behavior<*> = FixedAppBarLayoutBehavior()
    }
    NavigationView::class.java -> NavigationView(context)
    BottomNavigationView::class.java -> BottomNavigationView(context)
    CollapsingToolbarLayout::class.java -> CollapsingToolbarLayout(context)
    TabLayout::class.java -> TabLayout(context)
    TextInputLayout::class.java -> TextInputLayout(context)
    TextInputEditText::class.java -> TextInputEditText(context)
    else -> null
} as V?
