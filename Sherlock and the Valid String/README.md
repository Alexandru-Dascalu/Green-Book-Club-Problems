Problem statement:

Sherlock considers a string to be valid if it all characters of the string appear 
the same number of times. It is also valid if he can remove just one character at one
index in the string, and the remaining characters will occur the same number of
times. Given a string , determine if it is valid.
 
For example, if s=abc , it is a valid string because frequencies are {a:1,b:1,c:1}. So 
is s=abcc because we can remove one c and have 1 of each character in the remaining string. 
If s=abccc however, the string is not valid as we can only remove occurrence 1 of c. That 
would leave character frequencies of {a:1, b:1, c:2}.

Input Format:
A single string s.
 
Constraints:
The length of s is between one and 100000 inclusive, and is made from lowercase ascii latin letters 
from the English Alphabet.
 
Output Format:
Print YES if string  is valid, otherwise, print NO.
 
Taken from https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem .
