package space.matyakupov.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import space.matyakupov.myapplication.CustomDialogBio
import space.matyakupov.myapplication.MainActivity
import space.matyakupov.myapplication.Model.Movie
import space.matyakupov.myapplication.R
import kotlin.math.acos

class MyMovieAdapter(val context: Context):RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    var movieList: List<Movie> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var image: ImageView = itemView.findViewById(R.id.image_movie)
        var txt_name: TextView = itemView.findViewById(R.id.txt_name)
        var txt_team: TextView = itemView.findViewById(R.id.txt_team)
        var txt_createdby: TextView = itemView.findViewById(R.id.txt_createdby)

        fun populateModel(movie: Movie, context: Context) {
            txt_name.text = movie.name
            txt_team.text = movie.team
            txt_createdby.text = movie.createdby

            Picasso.get().load(movie.imageurl).into(image)

            image.setOnClickListener {
                var customDialogBio = CustomDialogBio(context)
                //var imageViewCD = customDialogBio.findViewById<ImageView>(R.id.image_movie_custom_dialog)
                //var textViewCD = customDialogBio.findViewById<TextView>(R.id.txt_custom_dialog)
                //Picasso.get().load(movie.imageurl).into(imageViewCD)
                //textViewCD.text = movie.bio
                var strImgUrl: String? = movie.imageurl.toString()
                val strTxtBio: String = movie.bio.toString()

                if (strImgUrl != null) {
                    customDialogBio.startCustomDialog(strImgUrl, strTxtBio)
                }
//                if (strImgUrl != null && strTxtBio != null) {
//                    customDialogBio.startCustomDialog(strImgUrl, strTxtBio)
//                }
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.findViewById<TextView>(R.id.txt_name).text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(movieList[position], context)
    }
}