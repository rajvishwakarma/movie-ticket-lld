# Movie ticket booking system LLD

Requirement

1. Movie ticket booking system
2. Listing of shows
3. Listing of theatres
4. Booking a seat
5. Viewing the ticket

Use Cases

1. Create User
2. Create Movie
3. Create Theatre
4. Create and Add Shows to Theatre having details of Movie
5. List All Shows
6. Lsiting All Theatres
7. Search By Movie
8. Booking a Seat(part of Show)
9. View Ticket Details

*Payment is out of scope

Design patterns covered

1. Singleton
2. Observer Pattern
3. Template Pattern
4. Strategy Pattern (could be used for Payment Strategy)
5. Dependency Injection Pattern
6. State Pattern (For Mainting states of Seats and Booking)

Note: 
1. I have added comments on the Main page while calling each funtionalities and tried to make it simple.
2. Searching Shows by movie could be done based on date, I have checked for Movie name.
3. While booking a seat of a show, we could have introduced locks on seats, where when a user books a seat, its gets blocked so that no other user is able to book the same seat. Here the Booking will be create with status CREATED. But till the time the Payment is done the seats will be locked for some period and if the user doesn't come back and complete the payment the seats will be again marked as VACANT.
4. Payment module was not covered in this LLD.
5. We can convert this into Maven and used Lombok so that we can avoid extra efforts on creating manually getter/setter/constructor etc.
