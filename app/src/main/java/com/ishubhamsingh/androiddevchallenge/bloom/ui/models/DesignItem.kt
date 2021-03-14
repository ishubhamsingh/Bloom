package com.ishubhamsingh.androiddevchallenge.bloom.ui.models

data class DesignItem(
   var title: String,
   var imgUrl: String,
   var isChecked: Boolean
)

fun getDesignData() = arrayListOf(
    DesignItem(
        title = "Monstera",
        imgUrl = "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?cs=srgb&dl=pexels-huy-phan-3097770.jpg&fm=jpg",
        isChecked = true
    ),

    DesignItem(
        title = "Aglaonema",
        imgUrl = "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?cs=srgb&dl=pexels-karolina-grabowska-4751978.jpg&fm=jpg",
        isChecked = false
    ),

    DesignItem(
        title = "Peace lily",
        imgUrl = "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?cs=srgb&dl=pexels-melvin-vito-4425201.jpg&fm=jpg",
        isChecked = false
    ),

    DesignItem(
        title = "Fiddle leaf",
        imgUrl = "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?cs=srgb&dl=pexels-%D0%B2%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80-%D0%B3%D0%BB%D0%B0%D0%B4%D0%BA%D0%BE%D0%B2-6208087.jpg&fm=jpg",
        isChecked = true
    ),

    DesignItem(
        title = "Snake plant",
        imgUrl = "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?cs=srgb&dl=pexels-fabian-stroobants-2123482.jpg&fm=jpg",
        isChecked = false
    ),

    DesignItem(
        title = "Pothos",
        imgUrl = "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?cs=srgb&dl=pexels-faraz-ahmad-1084199.jpg&fm=jpg",
        isChecked = false
    )
)