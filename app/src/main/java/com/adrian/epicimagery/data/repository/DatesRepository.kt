package com.adrian.epicimagery.data.repository

import com.adrian.epicimagery.domain.model.dto.DateDto
import io.reactivex.Single

interface DatesRepository {
    fun getDates(): Single<List<DateDto>>
}
