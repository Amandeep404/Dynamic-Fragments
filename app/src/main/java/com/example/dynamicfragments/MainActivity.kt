package com.example.dynamicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

interface StarSignListener{
    fun onSelected(id:Int)
}

class MainActivity : AppCompatActivity(),StarSignListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            fragmentContainer?.let {
                val listFragment = ListFragment()

                supportFragmentManager.beginTransaction().add(it.id, listFragment).commit()
            }
        }
    }

    override fun onSelected(id: Int) {

        fragmentContainer?.let {
            val detailFragment = DetailFragment.newInstance(id)

            supportFragmentManager.beginTransaction()
                .replace(it.id, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}