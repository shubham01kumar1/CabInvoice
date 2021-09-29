# Cab Invoice Problem - TDD Approach
  The cab service is a subscription based Cab Service, where the customer books a cab, and pays the bill at the end of the month.
## UC-1-Calculate Fare:
  Given	distance	and	time,	the	invoice	generator should return the total fare for the journey.
  Cost - Rs. 10 per kilometer + Rs. 1 per minute. Minimum Fare - Rs. 5
## UC-2-MultipleRides:
  The	Invoice	Generator	should	now	take	in	multiple rides, and calculate the aggregate total for all.
## UC-3-EnhancedInvoice:
  The	Invoice	Generator	should	now	return	the following as a part of the invoice -
          -Total Number of Rides
          -Total Fare
          -Average Fare Per Ride
## UC-4-InvoiceService:
   Given a user id, the Invoice Service gets the List of rides from the Ride Repository, and returns the Invoice. 
## UC-5-PremiumRides
  The Cab Agency now supports 2 categories of rides:
        -Normal Rides:rs. 10 per  km, Rs. 1 per minute, minimum fare of Rs.5
        -Premium Rides: Rs.15 per km, Rs.2 per minute, Minimum fare of Rs.20
