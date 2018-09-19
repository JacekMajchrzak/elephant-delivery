# CD workshops - Elephant Delivery Exercise

### Instruction

1.   Break into teams of 2-3 people, one workstation per team.
2.   Preparation - Each team writes down on paper the 10-20 demo-able user stories ("slices") they will develop and possibly demo. Each should be doable in 3-8 minutes. No slice is just mockup of UI, creation of a data table or data structure. All demos show real input & output (not test harness).
3.   User on production wants to see only finished features:hello world,  5 states , 5 discounts - during demo you have to prove it can hidden on prd
4.   Discussion - Instructor/facilitator leads discussion of the slices, what is and isn't acceptable, solicits ways to slice finer.
5.   Development - A fixed time-box of 50 minutes, five 10-minute development sprints, clock does not stop. At the end of each sprint, each team shows its product to another team.
6.	 Debrief

### How we will work?

- Hardcode ATDD: https://dzone.com/articles/acceptance-test-driven-development-closing-the-com
- Pair-programming (switch driver and pilot roles every sprint)
- Before starting to code do solution review with member of other team
- Before commiting code ask member of other team for code review
- Every commit needs to be deployable into production (we are not showing unfinished features)
- Use feature switches, branch by abstraction and seperate path
- Its not a race we are trying to learn something :)

### Product


We will build a retail calculator. It is a runnable application with user interface, three inputs and one output.
Output: total price of the order. Give a discount based on the total price, then add state tax based on the state code and discounted price.

Accept 3 inputs from the user:
- How many items
- Price per item
- 2-letter state code

Output the total price. Give a discount based on the total price, add state tax based on the state and the discounted price.

Order Value | Discount Rate
----------- | -------------
1000$       | 3%
5000$       | 5%
7000$       | 7%
10000$      | 10%
50000$      | 15%


State       | Tax Rate
----------- | --------
UT          | 6.85%
NV          | 8.00%
TX          | 6.25%
AL          | 4.00%
CA          | 8.25%


### Building and running aplication
1. mvn clean install
2. java -jar target/elephant-delivery-1.0-SNAPSHOT-jar-with-dependencies.jar
3. Go to your browser and open localhost:7070

### Turn off and turn on feature switch
curl -X POST localhost:7070/features/EXAMPLE -d '{"turnToState":"ON"}'
curl -X GET localhost:7070/features