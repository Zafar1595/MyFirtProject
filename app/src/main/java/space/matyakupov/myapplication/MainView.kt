package space.matyakupov.myapplication

import space.matyakupov.myapplication.Model.Movie

interface MainView {

    fun setData(movieList: List<Movie>)
}