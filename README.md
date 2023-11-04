# Bigger Picture News App

Bigger Picture News is a versatile mobile app designed to provide users with a comprehensive view of information they care about the most. From real-time currency exchange rates to the latest news articles and local weather forecasts, this app serves as a one-stop solution for staying updated and informed. With a modular design and user-friendly interface, Bigger Picture News makes it easy for users to access personalized content effortlessly.

[Download on Google Play](https://play.google.com/store/apps/details?id=com.trinityjayd.biggerpicturenews&pcampaignid=web_share)

## Features

- **Customizable Exchange Rate**: Users can personalize their experience by selecting their preferred currency exchange rate (ZAR/USD) and stay informed about currency fluctuations.

- **Preferred News Sources**: Choose from a list of available news sources and receive curated articles from two preferred sources. Clicking on an article opens up the full content for easy reading.

- **Weather Forecast**: Access the current weather forecast for Durban, ensuring you're always prepared for the day ahead.

- **Modular Design with Fragments**: Bigger Picture News employs a modular architecture using fragments, making it flexible and easy to maintain. Each section of the app is encapsulated in its own fragment, promoting reusability and efficiency.

- **User Authentication**: Users have the option to authenticate, either before accessing any content or when setting preferences. Firebase authentication is used to ensure a secure login process.

## Installation

1. Clone the repository to your local machine.
   
   ```bash
   git clone https://github.com/your-username/bigger-picture-news.git
   ```

2. Open the project in your preferred Android development environment (e.g., Android Studio).

3. Ensure you have the necessary dependencies installed. You can manage dependencies using Gradle.

4. Configure Firebase:
   - Create a project on Firebase (if not already done).
   - Add your Firebase configuration to the `google-services.json` file in the `app` directory.

5. Replace API keys:
   - Replace placeholders for API keys with your actual keys in relevant files.

6. Build and run the app on an Android emulator or physical device.

## Usage

1. Launch the Bigger Picture News app on your Android device.

2. If prompted, log in using your Firebase authentication credentials.

3. Customize your experience by setting your preferred ZAR/USD exchange rate and selecting two preferred news sources.

4. Explore the different sections of the app:
   - Exchange Rate: View the real-time ZAR/USD exchange rate.
   - News: Browse curated articles from your selected news sources.
   - Weather: Check the current weather forecast for Durban.

5. Click on a news article to read the full content.

## APIs Used

- [Free Currency API](https://api.freecurrencyapi.com/): Fetch real-time currency exchange rates.
- [News API](https://newsapi.org/v2/): Retrieve the latest news articles from various sources.
- [AccuWeather API](http://dataservice.accuweather.com/): Obtain current weather forecasts.

## Acknowledgments

This app was developed using various technologies and services to provide users with valuable information in a seamless manner. Special thanks to Firebase for authentication and the realtime database functionality.

## License

This project is licensed under the [MIT License](LICENSE).

---

