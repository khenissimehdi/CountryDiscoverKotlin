package com.example.countrydiscover

class QuantitativeFact {
    data class Rank(val position: Int, val maxPosition: Int) {
        val ratio get() = (maxPosition.toFloat() - position.toFloat()) / (maxPosition.toFloat() - 1f)
    }

    sealed class QuantitativeFact(val value: Float, val rank: Rank) {
        abstract val unit: String
    }

    class AreaFact(value: Float, rank: Rank): QuantitativeFact(value, rank) { override val unit = "km^2" }
}