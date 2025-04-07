# JETRestaurants

## Description

This project is my work for the assessment day

## Technology Stack

     *     Kotlin
     *   Android SDK
     *   XML layouts
     *   Retrofit (if using a network API)
     *   ViewModel
     *   LiveData and StateFlow
    

## Prerequisites

*   Android Studio Koala
*   Kotlin SDK

## Getting Started

1.  **Clone the Repository:**
``` bash git clone https://github.com/alexmadaras00/JETRestaurants cd [YOUR_PROJECT_DIRECTORY] ```
2.  **Open in Android Studio:**
    *   Start Android Studio.
    *   Select "Open an Existing Project" and navigate to the directory where you cloned the repository.

3.  **Sync Project with Gradle Files:**
    *   Android Studio should automatically prompt you to sync the project. If not, you can manually trigger it by clicking the "Sync Project with Gradle Files" button in the toolbar (it looks like an elephant with a blue arrow) or by going to "File" -> "Sync Project with Gradle Files."

4.  **Build the Project:**
    *   Go to "Build" -> "Make Project" or press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (macOS).

## Running the App

1.  **Connect an Android Device or Emulator:**
    *   You can run the app on a physical Android device connected via USB or by using the Android Emulator.
    *   To use the emulator, go to "Tools" -> "Device Manager" and create a new virtual device if you don't have one already.

2.  **Run the App:**
    *   In Android Studio, select the desired device/emulator from the device dropdown in the toolbar.
    *   Click the "Run" button (it looks like a green play icon) or press `Shift+F10` (Windows/Linux) or `Ctrl+R` (macOS).
    *   Choose the app module to run (usually "app").


## Experience

### Unclear assumptions 
As no API restrictions were specified, my initial thought was to use GraphQL, as we only want to extract certain fields. However, I decided to use REST API, as GraphQL requires POST requests, which were not possible for this API.
My solution is integrated in an Android App, using MVVM Clean Architecture, and fetching APIs using Retrofit.
In the UI I decided to implement 2 fragments in one activity (principle recommended by the Android documentation), where the top 10 restaurants are displayed in a Recycler View.

### Improvements

For improvements, I would write automated tests, firstly, for the Retrofit API calls, and then UI, Unit and Integration tests. 
