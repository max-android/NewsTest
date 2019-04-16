package com.my_project.newstest.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
data class Headline (
    @SerializedName("source") @Expose val source: Source,
    @SerializedName("author") @Expose val author: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("description") @Expose val description: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("urlToImage") @Expose val urlImage: String,
    @SerializedName("publishedAt") @Expose val data: String,
    @SerializedName("content") @Expose val content: String
):Serializable
