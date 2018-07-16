# popular-news-sample
Sample application showing a list of most popular news and information of the past week.

## Requirements

- Android API 21 and above

## Third Party Integrations

-  **[NYTimes API](https://developer.nytimes.com/)**- Fetch most popular news from the last 7 days
-  **[Retrofit](https://github.com/square/retrofit)**- API calls
-  **[Glide](https://github.com/bumptech/glide)**- Image loading

## Tests

Run Instrumented unit tests from command line
```gradle
./gradlew connectedAndroidTest
```

## Setup
Get the API Key from [NYTimes developer site](https://developer.nytimes.com/signup)
and include it in the Module's build.gradle.

It is left blank intentionally in the current sample application.
```gradle
buildConfigField('String', "API_KEY", "\"xxxxxxxxxxxxxxx\"")
```