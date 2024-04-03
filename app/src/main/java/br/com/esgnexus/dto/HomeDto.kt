package br.com.esgnexus.dto

data class HomeDto(
    var enterpriseId: Long,
    var recentPosts: List<RecentPost>
)
