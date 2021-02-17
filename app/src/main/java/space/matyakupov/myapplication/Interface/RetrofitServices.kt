package space.matyakupov.myapplication.Interface

import retrofit2.Call// Обратить внимание
import retrofit2.http.GET
import space.matyakupov.myapplication.Model.Movie

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>> // И тут внимание

}