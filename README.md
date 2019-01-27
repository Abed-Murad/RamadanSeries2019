# Ramadan Series 2019

Team:
=====

Designer:@Abed-Murad

Developer:@Abed-Murad

Marketing:@Abed-Murad

Description
===========

An app to show the best Ramadan Tv Shows in 2019, were the user can see the latest shows trailers if they are not available yet , or the show in youtube if the show is available.

The app also provide a details screen for each show to show it details and when it will air.

The app have sections for each genre of the shows like action , drama, .... , with a slider a the top of the main screen.

The main Screen Shows a slider at the top then shows categories and their shows

The Main Screen Drawer Shows The Categories List, and about links.

The Show Screen Shows the Show Poster the the show actors, then the Shows episodes, if the Show is not available the Alternative Screen will be shown with the Poster or Trailer and The Actors list and the Air time.

The Video Screen Shows The Video, The Title and Related Videos List

Content Source(s):
==================

<https://www.elcinema.com/ramadan/2019/#w2003051>

Intended User
=============

The Arabic User in general and the Egyption users

Features
========

Version 1
---------

-   Push notifications

-   Launch Screen

-   Show Shows List

-   Shows Slider

-   Show Video on Youtube  

-   Show Related Videos Below the Video

-   Full Screen Mode

Technologies

-   Firebase Firestore

-   Android SDK

Key Considerations
==================

-   ### All The Strings, dimensions, colors, are based on their corresponding files.

Room - Firebase - Repository Triangle:
--------------------------------------

The App Will Fetch The Data to From FireStore to The Room Database then when anything changes the changes will be made to the room database which will inform the app of the changes using the Repository Pattern

libraries
=========

-   Retrofit : Https Requests

-   Glide: Image Loading

-   Binding Library: Data Binding

-   Gson: converting json to pojo

-   Google Material Icons

-   Android Youtube Player :For Youtube Videos

Tasks
=====

Version 1
---------

### Task 1: UI/UX implementation

-   Create The Launch Screen Layout

-   Create The Main Screen Layout

-   Slider

-   4 horizontal recyclers

-   Create The Show Screen Layout

-   Create The Video ScreeRn Layout

-   Create The Logo

### Task 2: Data Models Creating and pulling

-   Create Firestore Data Model

-   Create The Firebase Web Client

