# Android Rock Stars


Repository of my first application. It is an Android app made with Kotlin, clean architecture and MVVM.

The application brings the data of the top rated tv series from the IMDB api. It consists of two screens, the first is an infinite list of the series and the second is the detail view of the specific serie, where you can see more information such as the release date, the summary, etc.

The curiosity of this project is that it mixes views and components created with Jetpack Compose with classic xml views.

We have the main characteristics:

- Clean Arquitecture with 3 layers. Data -> Domain  -> Ui
- SOLID principies
- Jetpack compose and classics XML views
- Material design
- Support dark and light theme
- Custom Splash Screen with animated logo and brand logo
- Custom mappers between Data and Domain
- Tmdb oficial api : https://developers.themoviedb.org/3/tv/get-top-rated-tv
- Infinite scroll with Paging 3.0
- Retrofit and Gson
- Coroutines
- Dependecies Injector with Dagger Hilt
- Coil
- StateFlow
- Navigation compose
- ViewBinding
- Differents mocks to show the preview with jetpack
- Dependencies gradle file to manage libraries much more easy 
- Android icon
- Good loking design!
- Circular Progress Indicator (jetpack)when open the app while fetching the data
. Circular Progress bar (xml) when open the detail screen while fethcing the data
- TopBar indicator with jetpack compose
- A Jetpack compose component showed in a xml activity
- Design with accesibility in mind (every item has a content description and great contrast)
- Reformat some parameters (like 5300 to 5.3k, 8.9 average votes to 8,9)
