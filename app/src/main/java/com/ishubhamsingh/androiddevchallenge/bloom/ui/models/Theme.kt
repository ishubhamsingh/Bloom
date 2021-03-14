package com.ishubhamsingh.androiddevchallenge.bloom.ui.models

data class Theme(
    var title: String,
    var imageUrl: String
)

fun getThemeData() = arrayListOf(
    Theme(
        title = "Desert chic",
        imageUrl = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?cs=srgb&dl=pexels-quang-nguyen-vinh-2132227.jpg&fm=jpg"
    ),
    Theme(
        title = "Tiny terrariums",
        imageUrl = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?cs=srgb&dl=pexels-katarzyna-modrzejewska-1400375.jpg&fm=jpg"
    ),
    Theme(
        title = "Jungle vibes",
        imageUrl = "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?cs=srgb&dl=pexels-volkan-vardar-5699665.jpg&fm=jpg"
    ),
    Theme(
        title = "Easy care",
        imageUrl = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?cs=srgb&dl=pexels-%D0%B2%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80-%D0%B3%D0%BB%D0%B0%D0%B4%D0%BA%D0%BE%D0%B2-6208086.jpg&fm=jpg"
    ),
    Theme(
        title = "Statements",
        imageUrl = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?cs=srgb&dl=pexels-sidnei-maia-3511755.jpg&fm=jpg"
    )
)