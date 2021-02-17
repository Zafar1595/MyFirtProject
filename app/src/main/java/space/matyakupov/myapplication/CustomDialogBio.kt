package space.matyakupov.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_dialog_item.*

class CustomDialogBio(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_item)
    }

    fun startCustomDialog(imageurl: String, bio: String){
        //val messageBoxView = LayoutInflater.from(this.context).inflate(R.layout.custom_dialog_item, null)
       // var imageView: ImageView = messageBoxView.findViewById(R.id.image_movie_custom_dialog)
       // var textView: TextView = messageBoxView.findViewById(R.id.txt_custom_dialog)
        //var textView: TextView = messageBoxView.findViewById(R.id.txt_custom_dialog)
        //Picasso.get().load(imageurl).into(imageView)
        //textView.text = "bio"
//        imageView.setOnClickListener {
//            Toast.makeText(context, "ImageView is clicked", Toast.LENGTH_SHORT).show()
//        }
//        Log.d("qandaymanis",txt_custom_dialog.text.toString() )
        show()
    }

}