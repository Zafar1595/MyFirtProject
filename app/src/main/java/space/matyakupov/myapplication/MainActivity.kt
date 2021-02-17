package space.matyakupov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmax.dialog.SpotsDialog
import dmax.dialog.SpotsDialog.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import space.matyakupov.myapplication.Adapter.MyMovieAdapter
import space.matyakupov.myapplication.Common.Common
import space.matyakupov.myapplication.Interface.RetrofitServices
import space.matyakupov.myapplication.Model.Movie

class MainActivity : AppCompatActivity(), MainView {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    var adapter: MyMovieAdapter = MyMovieAdapter(this)
    lateinit var presenter: MainPresenter
    //lateinit var dialog: AlertDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerMovieList: RecyclerView = findViewById(R.id.recyclerMovieList)

        mService = Common.retrofitService

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        recyclerMovieList.adapter = adapter

        presenter = MainPresenter(this)
        presenter.getAllMovies()
    }

    override fun setData(movieList: List<Movie>) {
        adapter.movieList = movieList
    }

//    private fun getAllMovieList() {
//        //dialog.show()
//        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
//            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
//
//            }
//            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
//                 adapter.movieList = response.body() as MutableList<Movie>
//                //dialog.dismiss()
//            }
//        })
//    }

//    fun customDialog(imageurl: String, bio: String){
//        var customDialogBio = CustomDialogBio(this)
//        val messageBoxView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_item, null)
//
//        var textView: TextView = messageBoxView.findViewById(R.id.txt_custom_dialog)
//        textView.text = bio
//        customDialogBio.show()
//
//    }
}