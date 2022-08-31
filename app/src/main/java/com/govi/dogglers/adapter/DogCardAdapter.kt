package com.govi.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.govi.dogglers.const.Layout.GRID
import com.govi.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    //TODO: Initialize the data using the List found in data/DataSource
    private val dogList = DataSource.dogs

    /**
     * Initialize view elements
     */
   class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val dogImage: ImageView? = view!!.findViewById(R.id.ImgId)
        val dogName: TextView? = view!!.findViewById(R.id.Dogs_name)
        val dogAge: TextView? = view!!.findViewById(R.id.Dogs_age)
        val dogHobby: TextView? = view!!.findViewById(R.id.Dogs_Hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val adapterLayout = when (layout) {
            // TODO Inflate the layout
            GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        // TODO: Null should not be passed into the view holder. This should be updated to reflect the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }


    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val dogData = dogList[position]
        // TODO: Set the image resource for the current dog
        holder.dogImage?.setImageResource(dogData.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.dogName?.text = dogData.name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.dogAge?.text = resources?.getString(R.string.dog_age, dogData.age)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobby?.text = resources?.getString(R.string.dog_hobbies, dogData.hobbies)
    }
    

    // TODO: return the size of the data set instead of 0
    override fun getItemCount(): Int = dogList.size

}
