package com.mahmoud_darwish.nomad.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoud_darwish.nomad.R
import com.mahmoud_darwish.nomad.ui.theme.NomadTheme
import com.mahmoud_darwish.nomad.ui.theme.largePadding
import com.mahmoud_darwish.nomad.ui.theme.mediumPadding
import com.mahmoud_darwish.nomad.ui.theme.smallPadding
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier
        .fillMaxSize(), backgroundColor = Color(0xFF051334),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = stringResource(R.string.navigation_icon_desc)
                        )
                    }
                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            HomeTopSection()
            HomeMiddleSection()
            BottomSection()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(horizontal = largePadding)
                    .padding(bottom = largePadding)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_partner_section_ana),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.home_partner_section_unknown),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.home_partner_section_visa),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun BottomSection() {
    // column
    // row
    // box
    // image
    // column
    // column
    // button
    Column(
        modifier = Modifier
            .padding(horizontal = largePadding)
            .padding(bottom = largePadding)
            .fillMaxWidth(),
        verticalArrangement = spacedBy(largePadding),
        horizontalAlignment = CenterHorizontally
    ) {
        MiddleSectionImagesRow {
            // first image
            val modifier = Modifier.weight(1f)
            MiddleSectionImage(
                modifier,
                R.string.indonesia_name,
                R.string.bali_city_name,
                R.drawable.bali_city_image
            ) { /*TODO*/ }

            MiddleSectionImage(
                modifier,
                R.string.indonesia_name,
                R.string.malang_city_name,
                R.drawable.malang_city_image
            ) { /*TODO*/ }
        }

        MiddleSectionImagesRow {
            // first image
            val modifier = Modifier.weight(1f)
            MiddleSectionImage(
                modifier,
                R.string.indonesia_name,
                R.string.nusa_city_name,
                R.drawable.nusa_city_image
            ) { /*TODO*/ }

            MiddleSectionImage(
                modifier,
                R.string.middle_east_name,
                R.string.dubai_city_name,
                R.drawable.dubai_city_image
            ) { /*TODO*/ }
        }
    }
}

@Composable
private fun MiddleSectionImagesRow(RowContents: @Composable RowScope.() -> Unit) {
    Row(
        horizontalArrangement = spacedBy(largePadding),
        modifier = Modifier.fillMaxWidth(), content = RowContents
    )
}

@Composable
private fun MiddleSectionImage(
    modifier: Modifier,
    countryNameStringResource: Int,
    cityNameStringResource: Int,
    cityImageResource: Int,
    onViewDetailsClick: () -> Unit
) {
    Box(modifier.fillMaxWidth()) {
        val countryName = stringResource(countryNameStringResource)
        val cityName = stringResource(cityNameStringResource)
        Image(
            painterResource(id = cityImageResource),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            Modifier
                .padding(mediumPadding)
                .matchParentSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {
            Column(
                horizontalAlignment = CenterHorizontally
            ) {
                Text(text = countryName, color = Color.White)
                Text(text = cityName, color = Color.White)
            }
            Button(onClick = onViewDetailsClick) {
                Text(text = stringResource(id = R.string.view_details))
            }
        }
    }
}

/**
 * Middle section
 * */
@Composable
private fun HomeMiddleSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(horizontal = largePadding, vertical = largePadding)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Color.White)
                .padding(mediumPadding)
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(smallPadding)) {
                Text(text = "20K")
                Text(text = "Members")
            }
            Column(verticalArrangement = Arrangement.spacedBy(smallPadding)) {
                Text(text = "12")
                Text(text = "Countries")
            }
            Column(verticalArrangement = Arrangement.spacedBy(smallPadding)) {
                Text(text = "3K")
                Text(text = "Hotels")
            }
            Column(verticalArrangement = Arrangement.spacedBy(smallPadding)) {
                Text(text = "7")
                Text(text = "Partners")
            }
        }
    }
}

/**
 * Top section
 * */
@Composable
private fun HomeTopSection() {
    Box {
        Image(
            painterResource(id = R.drawable.background_home_top),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(mediumPadding * 2),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.explore_message),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = Color.White
            )

            Text(
                text = stringResource(id = R.string.explore_sub_message),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                color = Color.White
            )

            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.get_started)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NomadTheme { HomeScreen() }
}
