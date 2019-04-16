package com.my_project.newstest.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
data class News(
    @SerializedName("status") @Expose val status: String,
    @SerializedName("totalResults") @Expose val total: Int,
    @SerializedName("articles") @Expose val news:List<Headline>
): Serializable