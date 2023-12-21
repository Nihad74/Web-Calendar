#Web Calendar - Spring Boot Application
##Introduction
Welcome to the Web Calendar repository! This Spring Boot application allows users to manage events through a simple and intuitive web interface. Users can post events, retrieve them, delete specific events, get today's events, and retrieve events between two specified dates.

##Features
-Post Events: Users can create and post new events with details such as title, description, date, and time.

-Retrieve Events: Users can retrieve a list of all events or specific events based on criteria such as date, time, or title.

-Delete Events: Users have the ability to delete specific events, providing flexibility in managing their calendar.

-Today's Events: Easily fetch a list of events scheduled for the current day.

-Events Between Dates: Retrieve events that fall within a specified date range, enabling users to plan for specific time periods.

##API Endpoints
-POST /event: Create a new event.

-GET /event: Retrieve all events.

-GET /event/{id}: Retrieve details of a specific event.

-GET /event/today: Retrieve events scheduled for today.

-GET /event/?start_time={startDate}&end_time={endDate}: Retrieve events between two specified dates.

-DELETE /event/{id}: Delete a specific event.
