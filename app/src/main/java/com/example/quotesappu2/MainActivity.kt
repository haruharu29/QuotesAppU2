package com.example.quotesappu2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesappu2.data.DataSource
import com.example.quotesappu2.model.quote
import com.example.quotesappu2.ui.theme.QuotesAppU2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppU2Theme {
                QuotesApp()
            }
        }
    }
}

@Composable
fun QuotesApp()
{
    Quoteslist(
        quoteList = DataSource().loadQuote()
    )
}

@Composable
fun Quoteslist(quoteList: List<quote>, modifier: Modifier = Modifier)
{
    /*LazyColumn{
        items(quoteList)
        {
                Quote: quote -> QuoteCard(quote = quote, modifier = Modifier.padding(8.dp))

        }
    }*/

    LazyColumn()
    {
        items(quoteList)
        {
            Quote: quote -> QuoteCard(Quote = Quote, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun QuoteCard(Quote: quote, modifier: Modifier = Modifier)
{
    Card(modifier = modifier)
    {
        Column{
            Row(){
                Text(text = stringResource(id = Quote.stringResourceId1),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )

                Image(painter = painterResource(id = Quote.imageResourceId),
                    contentDescription = stringResource(id = Quote.stringResourceId1),
                    modifier = modifier.clip(shape = CircleShape)
                        .size(150.dp),
                    contentScale = ContentScale.Crop,
                    alignment = AbsoluteAlignment.CenterRight
                )
            }

            Text(text = stringResource(id = Quote.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Preview
@Composable
fun QuoteCardPreview(){
    QuotesApp()
}