package com.example.dynamicfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var starSignListener: StarSignListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is StarSignListener){
            starSignListener = context
        }else{
            throw RuntimeException("Must Implement StarSignListener")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val starSigns = listOf<View>(
            view.findViewById(R.id.aquarius),
            view.findViewById(R.id.pisces),
            view.findViewById(R.id.aries),
            view.findViewById(R.id.taurus),
            view.findViewById(R.id.gemini),
            view.findViewById(R.id.cancer),
            view.findViewById(R.id.leo),
            view.findViewById(R.id.virgo),
            view.findViewById(R.id.libra),
            view.findViewById(R.id.scorpio),
            view.findViewById(R.id.sagittarius),
            view.findViewById(R.id.capricorn)
        )

        starSigns.forEach {
            it.setOnClickListener(this)
        }

    }

    override fun onClick(p0: View?) {
        p0?.let {
            starSignListener.onSelected(it.id)
        }
    }

}