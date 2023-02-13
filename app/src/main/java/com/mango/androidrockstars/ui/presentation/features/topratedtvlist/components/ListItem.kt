package com.mango.androidrockstars.ui.presentation.features.topratedtvlist.components

//@Composable
//fun ListItemCard(
//    name: String,
//    posterPath: String,
//    voteAverage: Double,
//    voteCount: Int,
//    actionClick: () -> Unit,
//    ) :ApiResultList {
//    val colorStar = Color(0xFFFBD309)
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Column(
//            modifier = Modifier
//                .padding(bottom = 10.dp),
//        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("https://image.tmdb.org/t/p/w300/${posterPath}")
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .aspectRatio(2 / 2f)
//                    .clip(shape = MaterialTheme.shapes.medium),
//                )
////            Image(
////                painter = painterResource(id = R.drawable.wakanda),
////                contentDescription = null,
////                modifier = Modifier
////                    .clip(shape = MaterialTheme.shapes.medium),
////                alignment = Alignment.Center,
////            )
//            Text(
//                text = name,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                fontWeight = FontWeight.Bold,
//                style = MaterialTheme.typography.h5,
//                modifier = Modifier.padding(top = 7.dp),
//                color = MaterialTheme.colors.onPrimary
//            )
//            Row(
////                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(
//                    text = voteAverage.toString(),
//                    color = MaterialTheme.colors.onPrimary
//                )
//                Icon(
//                    Icons.Filled.Star,
//                    contentDescription = null,
//                    modifier = Modifier.size(ButtonDefaults.IconSize),
//                    tint = colorStar
//                )
//                Text(
//                    text = "of ${voteCount.toString()} votes",
//L                    color = MaterialTheme.colors.onPrimary
//                )
//            }
//        }
//    }
//}


//@Preview("Light Theme", showBackground = true)
//@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun ListItemBothThemesPreview() {
//    AndroidRockStarsTheme {
//        ListItemCard()
//    }
//}
////


//@Preview("Light Theme", showBackground = true)
//@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun ListItemBothThemesPreview() {
//    AndroidRockStarsTheme {
//        ListItemCard(
//            image = "",
//            title = "Movie 1",
//            totalVotes = 10,
//            averageRate = 4.7,
//            actionClick = { })
//    }
//}