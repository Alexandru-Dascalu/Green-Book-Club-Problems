Problem statement:

We define super digit of an integer  using the following rules:

If  has only  digit, then its super digit is .
Otherwise, the super digit of  is equal to the super digit of the digit-sum of . Here, digit-sum of a number is defined as the sum of its digits.
For example, super digit of 9875 will be calculated as:

super_digit(9875) = super_digit(9+8+7+5) 
                  = super_digit(29) 
                  = super_digit(2+9)
                  = super_digit(11)
                  = super_digit(1+1)
                  = super_digit(2)
                  = 2.
                  
You are given two numbers n and k. You have to calculate the super digit of P.
P is created when number n is concatenated k times. That is, if n=123 and k=3, then 123123123.

Input Format

The first line contains two space separated integers, n and k.

Constraints:

1<=n<=10^(100000)

1<=k<=10^5

Output Format:

Output the super digit of P, where P is created as described above.

Problem taken from : https://www.hackerrank.com/challenges/super-digit/problem .
