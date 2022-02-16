package com.adrian.epicimagery.data.framework.retrofit.service

import com.adrian.epicimagery.domain.model.dto.DateDto
import io.reactivex.Single
import retrofit2.http.GET

interface DateService {
    @GET("api/enhanced/all")
    fun getTracks(): Single<List<DateDto>>
}