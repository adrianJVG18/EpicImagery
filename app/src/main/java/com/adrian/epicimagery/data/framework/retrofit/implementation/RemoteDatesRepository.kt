package com.adrian.epicimagery.data.framework.retrofit.implementation

import com.adrian.epicimagery.data.framework.retrofit.client.NasaClient
import com.adrian.epicimagery.data.framework.retrofit.service.DateService
import com.adrian.epicimagery.data.repository.DatesRepository
import com.adrian.epicimagery.domain.model.dto.DateDto
import io.reactivex.Single

class RemoteDatesRepository: DatesRepository {

    private val datesApi = NasaClient.getClient()
        .create(DateService::class.java)

    override fun getDates(): Single<List<DateDto>> {
        return datesApi.getTracks()
    }
}