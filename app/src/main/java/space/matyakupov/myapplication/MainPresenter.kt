package space.matyakupov.myapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import space.matyakupov.myapplication.Common.Common
import space.matyakupov.myapplication.Interface.RetrofitServices
import space.matyakupov.myapplication.Model.Movie

class MainPresenter(private var view: MainView) {
    var mService: RetrofitServices = Common.retrofitService
    fun getAllMovies(){
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>>{
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                view.setData(response.body() as MutableList<Movie>)
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}