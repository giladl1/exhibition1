package com.levins.Matrix_Gilad_Levinson.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.levins.Matrix_Gilad_Levinson.R
import com.mapbox.maps.extension.style.expressions.dsl.generated.switchCase

private val TAB_TITLES = arrayOf(
    R.string.tab_text_4,
    R.string.tab_text_3 ,
    R.string.tab_text_2,
    R.string.tab_text_1



)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        when (position) {
            0 -> return PlaceholderFragment.newInstance(position + 1)
            1 -> return PlaceholderFragment.newInstance(position + 1, )
            2 -> return FeaturedFragment.newInstance()
            else ->{
                return MainFragment.newInstance()

            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}