package br.com.igorbag.githubsearch.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitModel(
    val name: String,
    @SerializedName("html_url")
    val html_url: String
) : Parcelable
