# [Fa23] Hack4Impact Technical Interview OOP Problem

_Interviewer info are in italics, while information to be read aloud is in standard type._

## Background (2 min)

<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/4928/4928380.png" alt="Clean4Impact"/>
</p>

Let's pretend that Hack4Impact is starting a wash-and-fold laundry service called "Clean4Impact." The service will entail a weekly morning pickup of our client's laundry to be charged by the size of the bag they use. Then, we wash and fold the laundry at our facilities before returning the bag to the client at the end of the day.

Given our company's technical background, we'd like to create an in-house laundry tracking program to help us with day-to-day business operations.

## Code Starters

Java

```java
import java.util.*;

public class ExampleClass {
   public ExampleClass() {

  }
}
```

Python

```python
class ExampleClass:
    def __init__(self):
      pass
```

C++

```c++
#include <iostream>
#include <string>
#include <vector>
using std::cout;
using std::endl;
using std::string;
using std::vector;

class ExampleClass {

};
```

JavaScript

```js
class ExampleClass {
    constructor() {}
}

// Fill in the rest
```

## Part 1

_Reveals the problem and tests the candidate on their object-oriented programming proficiency._

In this first part, you'll write some code to track client laundry pickups for the day.

_Copy the text below into the coderpad, then read it!_

[!] A laundry pickup includes an address as well as a laundry bag size, which corresponds to how much laundry they have & the price they'll pay. Choices are: - Small ($5) - Medium ($10) - Large ($15)

[!] You'll need to keep track of the total revenue for the day as pickups come in, to be updated every time your code is called to track a pickup.

_NOTE: If they ask for clarification about how pickups come in, when a pickup comes in, answer: it can call their function_

## Part 2

_Copy the text below into the coderpad, then read it!_

[!] One more thing--As we're still bootstrapping the company, we only have one laundry pickup van. Since the van goes house to house in the morning picking up bags, it will reach its max capacity at some point. This means that any subsequent pickups need to be ignored, and they won't be counted in our revenue for the day. Our van can hold up to 10 large bags worth of clothes.

Medium bags are half the size of a large, and small bags are half the size of a medium. Here's a bag size chart:

```
        Large
_____________________
|  Small  | Medium  |
|_________|         |
|  Small  |         |
|_________|_________|
```

_QUESTION: What happens when we add another bag type (new size + price)?_

## Part 3

Delivery seems to be done! Also, we just put in a purchase order for a fleet of vans! Hopefully we'll keep expanding.

_Copy the text below into the coderpad, then read it!_

[!] Each van has its own unique size, or max capacity, (in terms of the number of large laundry bags it can hold), as well as an ID of some form, you _(candidate)_ can decide! Now we need an effective way of choosing which van to assign to a morning laundry pickup, propose a method to accomplish this and write a solution. Some things to note: we know nothing/don't care about pickup location distances or using the fewest number of vans, but we do want to pickup as much laundry as possible.

_QUESTION: Are there any problems with the way you've chosen a van for a specific laundry pickup?_

## Part 4

Great work! Now business is booming. Those vans really do use a lot of gas though, and it'd be great to track that in some way.

_Copy the text below into the coderpad, then read it!_

[!] For simplicity's sake, assume each van uses gas proportional to its highest capacity at any given time in the morning during pickup. The exact quantity of gas the van uses during pickup is expressed by the following equation:

    Gas (Gallons) = 0.1 * Number of Pickups * (Used Capacity (Terms of Large Bags) + Max Capacity (Terms of Large Bags))

[!] Next, assume that gas costs $4/Gallon. Write some code to calculate the resulting _net income_ for the day. Net income is expressed by the following equation:

    Net Income = Revenue - Cost of Gas

_NOTE: People come pick up clothes so they don't need to use gas for delivery._

## Part 5

With the cost of gas all accounted for, our business is ready to expand. Our friends at Georgia Tech, UPenn, and Cornell want to create their own franchises using our code.

_Copy the text below into the coderpad, then read it!_

[!] We'll need to track each franchise's revenue, net income, vans, and all other attributes separately from one another. Modify your code to support this structural change.

[!] It'd be great if we could determine the franchise with the largest revenue every day, please add a function to return this.

## Part 6

We're now ready to move this program to the web, and we need to think about how it will fit into our larger software systems.

_Copy the text below into the coderpad, then read it!_

_Please write your responses below the questions for this section_

[!] How do you imagine your code will obtain laundry requests, and from where will they originate?

[!] How do you imagine your code will present computed information (revenue, net income), or how will it send this information to a presentation system?

[!] How do you plan to deploy your program as a service accessible to other business systems?

[!] Let's say we put all these things into production, what's the worst that could happen?

