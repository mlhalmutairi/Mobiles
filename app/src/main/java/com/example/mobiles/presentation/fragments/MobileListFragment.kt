package com.example.mobiles.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiles.R
import com.example.mobiles.presentation.model.MobileModel
import com.example.mobiles.presentation.RecyclerView.RecyclerViewInterface


class MobileListFragment : Fragment(), RecyclerViewInterface {

    private lateinit var mobileList : ArrayList<MobileModel>
    private lateinit var adapter: mobileListAdapter
    private lateinit var recyclerView : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.mobiles_recycler_view)

        mobileList = ArrayList()
        mobileList.add(MobileModel("Samsung Grand2",R.drawable.mobile1,"Samsung",1800f))
        mobileList.add(MobileModel("Iphone 13 Pro ",R.drawable.iphone13,"Apple",3500f))
        mobileList.add(MobileModel("Galaxy S10 ",R.drawable.s10,"Samsung",2600f))
        mobileList.add(MobileModel("Xiaome 12 pro",R.drawable.xiaomi12pro,"xiaomi",999f))
        adapter = mobileListAdapter(requireActivity(),mobileList,this)

        recyclerView.adapter = adapter

    }

    override fun onItemClicked(position: Int) {
        val action = MobileListFragmentDirections.actionListFragmentToDetailsFragment(mobileList[position])
        findNavController().navigate(action)
    }

}