Expense Sharing Application
---------------------------

Users: U1 (YOU), U2, U3, U4
Transaction T1: 1000
CASE: SPLIT EQUAL

U2 -> U1 : 250
U3 -> U1 : 250
U4 -> U1 : 250

Case: EXACT

Transaction T2: 1100

U3 -> U1: 500
U4 -> U1: 600

U3 Balance: 250 + 500 = 750
U4 Balance: 250 + 600 = 850
U2 Balance: 250 + 0 = 250

Case: SHARE

Transaction T3: 2000

U1 Share: 1
U2 Share: 2
U3 Share: 1
U4 Share: 1

U2 -> 800
U1 -> 400
U3 -> 400
U4 -> 400

U1 Balance: 0
U3 Balance: 750 + 400 = 1150
U2 Balance: 250 + 800 = 1050			
U4 Balance: 850 + 400 = 1250


Users: Id, name, email, mobile
Amount should be handled till 2 decimal places.
SHARE will always be an integer
In case of EXACT, you need to verify if the total sum of shares is equal to the total amount or not.




* addUser(<U>, Details)
* recordExpense(amount, description, involvedUsers, paid, splitType)
* recordExpense(amount, description, involvedUsers, paid, splitType, shareDetails)
* getBalance(User <U>)

You can store all data in memory.
You can print outputs



Group ->
List<Expense>
Recurring numbers.
One user pays for any design.pattern.expense.
