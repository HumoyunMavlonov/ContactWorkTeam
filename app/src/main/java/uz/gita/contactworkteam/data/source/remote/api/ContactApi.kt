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
import uz.gita.contactworkteam.data.source.remote.response.ContactResponse

interface ContactApi {
    @GET("contact")
    suspend fun getAllContacts(): Response<ContactResponse>

    @POST("contact")
    suspend fun addContact(@Body contactRequest: ContactAddRequest): Response<ContactResponse>

    @PUT("contact")
    suspend fun updateContact(
        @Body contactRequest: ContactEditRequest
    ): Response<ContactResponse>

    @DELETE("contact")
    suspend fun deleteContact(@Query("id") id: Int): Response<ContactResponse>
}