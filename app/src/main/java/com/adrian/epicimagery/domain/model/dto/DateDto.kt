package com.adrian.epicimagery.domain.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DateDto(
    @SerializedName("date")
    @Expose
    val date: String
)