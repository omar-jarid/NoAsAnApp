# NoAsAnApp

**NoAsAnApp** is a simple Android application that interacts with the [No-as-a-service API](https://github.com/hotheadhacker/no-as-a-service) to generate random reasons for rejecting or refusing anything.

---

## Overview

The purpose of this app is to provide users with random rejection reasons by consuming the No-as-a-service API.  
Each time the user interacts with the app, a new request is sent to the API, and the received response is displayed on screen.

---

## Features

- Minimalistic main screen with a single button
- Every button press triggers a new API request
- The app retrieves and displays a random reason provided by the API
- Clean and simple user interface focused on functionality
- Copy the generated response into Clipboard

---

## Libraries Used

The project leverages these Android libraries:

- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Handles dependency injection across the application, simplifying component management and improving code modularity.
- [Timber](https://github.com/JakeWharton/timber): A lightweight logging library providing an extensible API for logging debug information.
- [Retrofit](https://square.github.io/retrofit/): A type-safe HTTP client that simplifies network calls by using annotations to define API endpoints.
- [SplashScreen](https://developer.android.com/develop/ui/views/launch/splash-screen): Provides a smooth and customizable launch screen experience when the app starts.

---

## Install on your device
You can use the provided APK.

Minimum version required: API 26 (Android 8.0 - Oreo)
