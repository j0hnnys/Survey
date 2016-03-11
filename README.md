# Survey

SE-137 Team Project (Group 2)

Calvin Leung        calvin.leung@sjsu.edu
Daniel Nguyen       danni.le@me.com
Johnny Nguyen       j0hnny_n@yahoo.com
Stephen Piazza      stephen.apiazza@gmail.com

This survey application has three major features:
  1. The ability to take surveys.
  2. Being able to create your own surveys.
  3. Seeing the results of a survey

The application uses Parse to asynchronously update data onto its Parse database, so an internet connection is required to use it. It includes a sign up feature that allows you to create an account in order to log in to the application.

The login screen is featured with standard sign-in features. It also makes it easy for first-time users to create an account.
<img src=screenshots/login.png width=300 height=500 />

Users are given options on what they want to do:
1) Take a survey   2) Create a survey   3) See survey results
<img src=screenshots/options.png width=300 height=500 />

Taking surveys are easy to complete as they utilize standard checkbox and radio buttons to answer select questions.
<img src=screenshots/list.png width=300 height=500 /> <img src=screenshots/survey.png width=300 height=500 />

Creating surveys allow you to easily create multiple questions in a single survey before saving it to the Parse database.
<img src=screenshots/create.png width=300 height=500 />

Survey results are also stored within the Parse databased and generate the results based on the data fetched from Parse.
<img src=screenshots/results.png width=300 height=500 />
