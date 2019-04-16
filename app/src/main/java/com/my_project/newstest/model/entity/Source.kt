package com.my_project.newstest.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
data class Source(
    @SerializedName("id") @Expose val id: String,
    @SerializedName("name") @Expose val name: String
): Serializable
