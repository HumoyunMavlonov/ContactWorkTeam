package uz.gita.contactworkteam.data.source.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import uz.gita.contactworkteam.data.source.remote.request.ContactAddRequest
import uz.gita.contactworkteam.data.source.remote.request.ContactEditRequest
import uz.gita.contactworkteam.data.source.remote.response.ContactRepose

interface ContactApi {
    @GET("contact")
    suspend fun getAllContacts(): Response<ContactRepose>

    @POST("contact")
    suspend fun addProduct(@Body contactRequest: ContactAddRequest): Response<ContactRepose>

    @PUT("contact")
    suspend fun updateProduct(
        @Body contactRequest: ContactEditRequest
    ): Response<ContactRepose>

    @DELETE("contact")
    suspend fun deleteContact(@Query("id") id: Int): Response<ContactRepose>
}