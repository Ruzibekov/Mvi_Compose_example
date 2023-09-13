package uz.ruzibekov.mvi_compose_example.data.api

import retrofit2.http.GET
import uz.ruzibekov.mvi_compose_example.data.model.AuthorsData

interface ApiService {

    @GET("users")
    suspend fun getAuthors(): AuthorsData
}