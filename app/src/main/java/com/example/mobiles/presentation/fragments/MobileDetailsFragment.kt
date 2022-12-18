package com.example.mobiles.presentation.fragments

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.navigation.fragment.navArgs
import com.example.mobiles.R
import com.example.mobiles.presentation.model.MobileModel


class MobileDetailsFragment : Fragment() , OnClickListener {

    private val safeArgs by navArgs<MobileDetailsFragmentArgs>()
    private lateinit var toolbar : Toolbar
    private lateinit var imageView: ImageView
    private lateinit var name : TextView
    private lateinit var price : TextView
    private lateinit var brand : TextView
    private lateinit var pressHere : TextView
    private lateinit var model : MobileModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mobile_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = view.findViewById(R.id.toolbarr)
        imageView = view.findViewById(R.id.item_image_view)
        name = view.findViewById(R.id.item_name_tv)
        price = view.findViewById(R.id.price_tv)
        brand = view.findViewById(R.id.brand_tv)
        pressHere = view.findViewById(R.id.press_here)

        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener(View.OnClickListener { requireActivity().onBackPressed() })

        model = safeArgs.model
        imageView.setImageResource(model.image)
        name.text = model.name
        price.text = model.price.toString() + " ر.س "
        brand.text = model.brand

        pressHere.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.press_here -> {
                val search = Intent(Intent.ACTION_WEB_SEARCH)
                search.putExtra(SearchManager.QUERY,model.name)
                startActivity(search )
            }
        }
    }

}