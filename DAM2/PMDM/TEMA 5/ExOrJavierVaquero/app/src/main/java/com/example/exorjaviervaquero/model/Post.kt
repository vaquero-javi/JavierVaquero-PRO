package com.example.exorjaviervaquero.model

import java.io.Serializable

data class Post (
    val id: Long,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: Reactions,
    val views: Long,
    val userID: Long
) : Serializable

data class Reactions (
    val likes: Long,
    val dislikes: Long
) : Serializable

