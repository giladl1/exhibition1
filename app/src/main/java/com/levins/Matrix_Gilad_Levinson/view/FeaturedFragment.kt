package com.levins.Matrix_Gilad_Levinson.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levins.Matrix_Gilad_Levinson.Matrix_Gilad_LevinsonApplication
import com.levins.Matrix_Gilad_Levinson.repository.PileRepository
import com.levins.Matrix_Gilad_Levinson.view.RecyclerAdapter
import com.levins.Matrix_Gilad_Levinson.R
import com.levins.Matrix_Gilad_Levinson.model.DataObjectX
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch


class FeaturedFragment : Fragment() {
    lateinit var repository : PileRepository
    lateinit var viewModel: MainViewModel
    lateinit var viewAdapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager
//    lateinit var lastView: View
    lateinit var results : ArrayList<resultItem>
    companion object {
        fun newInstance() = FeaturedFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        repository = ((activity?.application as Matrix_Gilad_LevinsonApplication).repository)
        lifecycleScope.launch() {
        }
        return inflater.inflate(R.layout.fragment_featured2, container, false)// fragment_add_pile
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        lastView = main
    }
    private fun engageRepositoryToGetLocations() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(repository))
            .get(MainViewModel::class.java )
        viewModel.getLocations()
        Log.v("operate adapter","before")
        viewModel.locations.observe(viewLifecycleOwner, Observer {
            val elements = it.DataObject.DataListObject
            var List1 :ArrayList<DataObjectX> = arrayListOf<DataObjectX>()
            val List2 :ArrayList<DataObjectX> = arrayListOf<DataObjectX>()
            val List3 :ArrayList<DataObjectX> = arrayListOf<DataObjectX>()
            val List4 :ArrayList<DataObjectX> = arrayListOf<DataObjectX>()
            val List5 :ArrayList<DataObjectX> = arrayListOf<DataObjectX>()
            for(element in elements){
                when (element.CatId) {
                    1 ->List1.add(element)
                    2 ->List2.add(element)
                    3 ->List3.add(element)
                    4 ->List4.add(element)
                    else -> {
                        List5.add(element)
                    }
                }

            }
            operateAdapterWithElements(cat1RecyclerView,List1)
            operateAdapterWithElements(cat2RecyclerView,List2)
            operateAdapterWithElements(cat3RecyclerView,List3)
            operateAdapterWithElements(cat4RecyclerView,List4)
            operateAdapterWithElements(cat5RecyclerView,List5)
            val categories = it.DataObject.DataListCat
            for(cat in categories){
                when (cat.CatId) {
                    1 ->textView1.text = cat.CTitle
                    2 ->textView2.text = cat.CTitle
                    3 ->textView3.text = cat.CTitle
                    4 ->textView4.text = cat.CTitle
                    else -> {
                        textView5.text = cat.CTitle
                    }
                }

            }
        })
    }

    private fun operateAdapterWithElements(recyclerView: RecyclerView,elements: List<DataObjectX>) {
        Log.v("operate adapter","work")
        viewManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewAdapter = RecyclerAdapter(requireContext() , elements)
        recyclerView.apply {
            layoutManager = viewManager
            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }


    //take the answers data from the views in order to send to the server:
    override fun onStart() {
        super.onStart()
        results = arrayListOf<resultItem>()
        engageRepositoryToGetLocations()

    }
}


