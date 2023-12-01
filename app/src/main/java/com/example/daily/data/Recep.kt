package com.example.daily.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.daily.R

data class Recep(
    @StringRes val name: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val hobbies: Int
)

val receps = listOf(
    Recep(R.string.d_0, R.drawable.img1, R.string.recipe0),
    Recep(R.string.d_1, R.drawable.img2, R.string.recipe1),
    Recep(R.string.d_2, R.drawable.img3, R.string.recipe2),
    Recep(R.string.d_3, R.drawable.img4, R.string.recipe3),
    Recep(R.string.d_4, R.drawable.img5, R.string.recipe4),
    Recep(R.string.d_5, R.drawable.img6, R.string.recipe5),
    Recep(R.string.d_6, R.drawable.img7, R.string.recipe6)
)
