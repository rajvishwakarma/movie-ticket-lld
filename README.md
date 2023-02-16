# movie-ticket-lld

Requirement

Movie ticket booking system
Listing of shows
Listing of theatres
Booking a seat
Viewing the ticket


#Functional Requirement R & Use Cases

User -> search of movie
Based on movie -> theaters with shows 
Based on shows -> select the seats
Book seats -> Make payment
View the tickets

#Design patterns covered

1. Singleton
2. Observer Pattern
3. Template Pattern
4. Strategy Pattern (could be used for Payment)
5. Depemndency Injection Pattern
6. State Pattern (For Seats and Booking)

Note: I have added comments on the Main page while calling each funtionalities and tried to make it simple.
There are few use case where we need to have locks on seats if the user selects the seats and create Booking but doesn't complete the payment then the seats should to unlocked and available for other users to book.
Payment module was not covered in this LLD.
