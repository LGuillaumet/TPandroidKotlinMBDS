package android.mbds.tp1.guillaumet.neighbors.fragments

import android.content.Context
import android.mbds.tp1.guillaumet.neighbors.R
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputEditText

class NeighborDetailsFragment (var neighbor: Neighbor) : Fragment() {

    private lateinit var avatar: ImageView
    private lateinit var avatarUrl: TextInputEditText
    private lateinit var name: TextInputEditText
    private lateinit var phone: TextInputEditText
    private lateinit var website: TextInputEditText
    private lateinit var address: TextInputEditText
    private lateinit var about: TextInputEditText
    private lateinit var viewFragment: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment = inflater.inflate(R.layout.details_neighbor_fragment, container, false)
        avatar = viewFragment.findViewById(R.id.Avatar)
        avatarUrl = viewFragment.findViewById(R.id.AvatarUrl)
        name = viewFragment.findViewById(R.id.Name)
        phone = viewFragment.findViewById(R.id.Phone)
        website = viewFragment.findViewById(R.id.Website)
        address = viewFragment.findViewById(R.id.Adress)
        about = viewFragment.findViewById(R.id.About)
        changeImage(neighbor.avatarUrl.toString())
        avatarUrl.setText(neighbor.avatarUrl)
        name.setText(neighbor.name)
        phone.setText(neighbor.phoneNumber)
        website.setText(neighbor.webSite)
        address.setText(neighbor.address)
        about.setText(neighbor.aboutMe)

        return viewFragment
    }

    private fun changeImage(url: String) {
        val context: Context? = context
        if (context != null) {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            Glide.with(viewFragment.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .skipMemoryCache(false)
                .into(avatar)
        }
    }

}