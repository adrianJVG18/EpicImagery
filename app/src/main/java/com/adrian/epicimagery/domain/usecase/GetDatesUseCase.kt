package com.adrian.epicimagery.domain.usecase

import com.adrian.epicimagery.data.framework.retrofit.implementation.RemoteDatesRepository
import com.adrian.epicimagery.data.repository.DatesRepository
import com.adrian.epicimagery.domain.model.dto.DateDto
import io.reactivex.Single

class GetDatesUseCase {

    private val datesRepository: DatesRepository by lazy {
        RemoteDatesRepository()
    }

    fun execute(): Single<List<DateDto>> {
        return datesRepository.getDates()
    }

}