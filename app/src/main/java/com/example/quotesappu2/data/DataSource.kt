package com.example.quotesappu2.data

import com.example.quotesappu2.R
import com.example.quotesappu2.model.quote


class DataSource
{
    fun loadQuote(): List<quote>
    {
        return listOf<quote>(
            quote(R.string.quotes1, R.string.author1, R.drawable.image1),
            quote(R.string.quotes2, R.string.author2, R.drawable.image2),
            quote(R.string.quotes3, R.string.author3, R.drawable.image3),
            quote(R.string.quotes4, R.string.author4, R.drawable.image4),
            quote(R.string.quotes5, R.string.author5, R.drawable.image5),
            quote(R.string.quotes6, R.string.author6, R.drawable.image6),
            quote(R.string.quotes7, R.string.author7, R.drawable.image7),
            quote(R.string.quotes8, R.string.author8, R.drawable.image8),
            quote(R.string.quotes9, R.string.author9, R.drawable.image9),
            quote(R.string.quotes10, R.string.author10, R.drawable.image10)
    )
}

}