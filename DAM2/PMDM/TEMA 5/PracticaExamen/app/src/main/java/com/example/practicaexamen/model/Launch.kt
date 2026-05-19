package com.example.practicaexamen.model

import java.io.Serializable

data class Launch(
    val id: String,
    val name: String,
    val details: String? = null,
    val links: Links
) : Serializable

data class Links (
    val patch: Patch
) : Serializable

data class Patch (
    val small: String? = null,
) : Serializable
