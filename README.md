# Algorithms
Algorithms that solve mathematical problems written in Java
This is a simple java app which finds all x's and y's that satisfy x^2 - ny^2 = k, where x, y >= 0 and x, y <= k 
Other conditions are : (x,y) are Natural numbers and 'n' is a square number. 

At first, I tried to work the equation out on paper and it was easy to figure out solutions for prime numbers, that only have two divisors, but I didn't know how to figure out all of the variables that satisfy the equation when k is a positive Integer and has more than 2 divisors. 


After a little research, I used this approach. 

http://www.scienceforums.net/uploads/monthly_2017_11/24099565_526832734341221_1118443138_n.jpg.66e8aa1fe20c08a5b4cc46dad65c3967.jpg

Set 'Pn' has all 'x's' and 'y's' that satisfy the equation x^2 - ny^2 = k, while x and y are Natural numbers and n is a square number. 
Set 'A' has divisors of k (i) and quotients (j) that come from dividing k by divisor (i) which is inside set 'A'. 
We don't take all of the divisors of k (for ex. k = 9009), our largest divisor of 'k' inside set 'A' is the one closest to the square root of 'k'. 
A square root of 9009 is approximately 95, closest number to 95 which divides 9009 is 91, therefore, the divisors of k, that are inside set 'A' are:
i{1, 3, 7, 9, 11, 13, 21, 33, 39, 63, 77, 91}; 
Now, let's divide 9009 by all of the divisors above and get a final set 'A', that has all of the factors needed in further calculations: 
{ (1; 9009) , (3; 3003), (7; 1287), (9;1001), (11;819), (13;693), (21;429), (33;273), (39;231), (63; 143), (77;117), (91;99) } 
(In the picture, I've missed (7; 1287) element, sorry). 
Now, let's figure out values of 'x' and 'y'. 

For example we'll only take first two elements from set 'A', and those are : { (1;9009), (3; 3003) }. 
x = ( j + i ) / 2; 
y = ( j - x ) / (square root of 'n', in our case n = 4, n = d^2, d = 3) = (j-x) / 3   
Proof:  
x^2 - 9y^2 = (x+3y)(x-3y) = 9009, 
create a system of equations 
x + 3 y = j = 9009 
x - 3 y = i = 1 
combine 
x + 2y + x + (-2y) = 9010, 
2x = 9010, 
x = 9010 / 2 = 4505 
x = ( j + i ) / 2 = ( 9009 + 1 ) / 2 = 4505 
we've found 'x', now, let's find 'y' 
4505 + 3y = 9009 
3y = 9009 - 4505 = 4504 
y = 4504 / 3 = 1501.3333333333.... 
y = ( 9009 - 4505 ) / 3 = 1501.3333333333... 
These values cannot be included in our 'P9' set because 'y' is not a Natural number. 
Let's try out the second element in our 'A' set, which is (3, 3003) 
x = (3003 + 3) / 2 = 1503, 
y = (3003 - 1503) / 3 = 500, 
(1503)^2 - 9*(500)^2 = 2259009 - 2250000 = 9009 
(x = 1503, y = 500) are the values that are suitable for 'P9' set. 
Interesting property: 
If you combine 9009 and 1 and divide it by n (n = 9) you won't get a Natural number, and the x and y values are not inside 'P9' set whereas you do the same operation with 3003 and 3, you'll get the opposite result: 
( 9009 + 1 ) / 9 = 1001.11111 - > not a Natural number, 'x' and 'y' do not belong to 'P9' 
(3003 + 3 ) / 9 = 334 - Natural number, 'x' and 'y' belong to 'P9' 
  
Let's try a different value of 'k' and 'n': 
k = 16, n = 4. 
x^2 - 4y^2 = 16; 
i { 1, 2, 3 ,4} 
A{ (1, 16), (2, 8), (4, 4) } 
Let's use that "interesting property" 
16+1 / n = 17 / 4 = 4.25 - not a Natural number, 
2+8 / n = 10 / 4 = 2.5 - not a Natural number, 
4+4 / 4 = 2 - Natural number, 
x = ( j + i ) / 2 = ( 4 + 4 ) / 2 = 4, 
y = ( j - x ) / (square root of 'n') = (4-4) / 2 = 0, 
4^2 - 4*(0)^2 = 16, (x = 4, y = 0) are inside P4 set. 

Quick wrap up:

You get all of divisors that are larger than 0 and less than or equal to square root of k (x^2 - ny^2 = k), and from those divisors you create quotients that become j. And then you use 'i' and 'j' inside your system of equations, by checking if it's suitable for your equation

http://www.scienceforums.net/topic/111623-diophantine-equation/
