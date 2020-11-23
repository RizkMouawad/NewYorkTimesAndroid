# Description

- Simple application to show New York Times popular articles.
- Created using Kotlin.
- The application follows the MVVM with clean architecture design patterns

# How to clone and run the app

- In Android Studio choose File -> New -> Project from version control -> Git.
- Paste the bitbucket URL then click clone.
- Sync and rebuild the app.

# Unit Testing

### AppInstrumentedTest

- Right Click on the AppInstrumentedTest class and click on "Run AppInstrumentedTest".
- How It Works:
- First we check if the size of the recyclerview is greater then 5.
  - if it's greater then 5: We click on position 1 of the recycler view, we go to the news details fragment, then we go back to the news fragment after 3 seconds and repeat what we have done for position 2 and 3.
- We go back to the news fragment and swipe the layout to refresh the articles, we wait for 5 seconds and close application.

# Authors

**Rizk Mouawad**