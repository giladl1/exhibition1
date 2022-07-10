package com.levins.Matrix_Gilad_Levinson.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.levins.Matrix_Gilad_Levinson.MainActivity
import com.levins.Matrix_Gilad_Levinson.R
import kotlinx.android.synthetic.main.fragment_extended_element.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [ExtendedElementFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExtendedElementFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extended_element, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewCat.text = "category number: " + param1
        textviewId.text =  "id number: " + param2
        Glide.with(activity as MainActivity)
            .load(param3)
            .placeholder(R.mipmap.ic_hamatgad)
            .into(imageView2)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExtendedElementFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(category: String?, id: String?, imgUrl: String?) = //param1: String, param2: String
            ExtendedElementFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, category)
                    putString(ARG_PARAM2, id)
                    putString(ARG_PARAM3, imgUrl)
                }
            }
    }
}