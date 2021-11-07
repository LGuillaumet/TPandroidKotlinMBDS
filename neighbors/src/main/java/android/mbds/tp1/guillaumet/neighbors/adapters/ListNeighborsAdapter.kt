package android.mbds.tp1.guillaumet.neighbors.adapters

import android.content.Context
import android.mbds.tp1.guillaumet.neighbors.R
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView


class ListNeighborsAdapter(items: List<Neighbor>, listNeighborHandler: ListNeighborHandler) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {

    private val mNeighbours: List<Neighbor> = items
    private val mNeighboursHandler: ListNeighborHandler = listNeighborHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.neighbor_item, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        // Display Neighbour Name
        holder.mNeighbourName.text = neighbour.name

        holder.mDeleteButton.setOnClickListener {
            mNeighboursHandler.onDeleteNeibor(neighbour)
        }

        holder.mFavouriteButton.setOnClickListener {
            mNeighboursHandler.onSetFavorite(neighbour)
        }

        holder.mNeighbourAvatar.setOnClickListener {
            mNeighboursHandler.onShowNeighbor(neighbour)
        }






        val context = holder.mNeighbourAvatar.context
// Display Neighbour Avatar
        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_baseline_person_outline_24)
            .error(R.drawable.ic_baseline_person_outline_24)
            .skipMemoryCache(false)
            .into(holder.mNeighbourAvatar)
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val mNeighbourAvatar: ImageView = view.findViewById(R.id.item_list_avatar)
        val mNeighbourName: TextView = view.findViewById(R.id.item_list_name)
        val mDeleteButton: ImageButton = view.findViewById(R.id.item_list_delete_button)
        var mFavouriteButton: ImageButton = view.findViewById(R.id.item_list_favourite_button)

        init {
            // Enable click on item

        }
    }

}