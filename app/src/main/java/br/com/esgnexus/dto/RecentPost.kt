package br.com.esgnexus.dto

import java.util.Date

data class RecentPost(
    var id: Long,
    var datePost: Date,
    var description: String,
    var imagePost: String,
    var userPhoto: String
)
