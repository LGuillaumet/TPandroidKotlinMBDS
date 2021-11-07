package android.mbds.tp1.guillaumet.neighbors.fragments

import android.content.Context
import android.mbds.tp1.guillaumet.neighbors.MainActivity
import android.mbds.tp1.guillaumet.neighbors.R
import android.mbds.tp1.guillaumet.neighbors.data.NeighborRepository
import android.mbds.tp1.guillaumet.neighbors.models.Neighbor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputLayout

class AddNeighbourFragment : Fragment() {


    private lateinit var imageUrl: EditText
    private lateinit var nameInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var websiteInput: EditText
    private lateinit var adressInput: EditText
    private lateinit var aboutMeInput: EditText

    private lateinit var imageView: ImageView


    private lateinit var telephoneLayout: TextInputLayout
    private lateinit var saveBtn: Button

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        imageUrl = view.findViewById(R.id.imageUrl)
        nameInput = view.findViewById(R.id.nameInput)
        phoneInput = view.findViewById(R.id.phoneInput)
        websiteInput = view.findViewById(R.id.websiteInput)
        adressInput = view.findViewById(R.id.adressInput)
        aboutMeInput = view.findViewById(R.id.aboutMeInput)
        imageView = view.findViewById(R.id.imageView)



        saveBtn = view.findViewById(R.id.saveBtn)

        return view
    }


    private fun changeImage() {
        val context: Context? = context
        if (context != null) {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            Glide.with(context)
                .load(imageUrl.text.toString())
                .apply(RequestOptions.circleCropTransform())
                .placeholder(circularProgressDrawable)
                .error(R.drawable.ic_baseline_person_outline_24)
                .skipMemoryCache(false)
                .into(imageView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        saveBtn.setOnClickListener {
            val nom = nameInput.text.toString()
            val avatarUrl = imageUrl.text.toString()
            val address = adressInput.text.toString()
            val phoneNumber = phoneInput.text.toString()
            val aboutMe = aboutMeInput.text.toString()
            val webSite = websiteInput.text.toString()
            val favorite = false
            val id = NeighborRepository.getInstance().getNeighbours().size + 1

            val neighbor = Neighbor(
                id = id,
                name = nom,
                avatarUrl = avatarUrl,
                address = address,
                phoneNumber = phoneNumber,
                aboutMe = aboutMe,
                favorite = favorite,
                webSite = webSite
            )

            NeighborRepository.getInstance().createNeighbour(neighbor)

            (activity as? MainActivity)?.changeFragment(ListNeighborsFragment())

        }


        imageUrl.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                changeImage()
            }
        }
    }


}

