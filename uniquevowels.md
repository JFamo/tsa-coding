# Unique Vowels
## Nationals 2018

Take input in the form of a string and a positive integer N. Return the longest substring of the input string which contains exactly N number of unique vowels and its length.

## Testing
Input | Expected Output
------------ | -------------
String: memapopi <br>N: 2 | Longest substring: 5, memap
String: beep <br>N: 1 | Longest substring: 4, beep
String: antidisestablishmentarianism <br>N: 3 | Longest substring: 28, antidisestablishmentarianism
String: pneumonoultramicroscopicsilicovolcanoconiosis <br>N: 3 | Longest substring: 36, ltramicroscopicsilicovolcanoconiosis
String: floccinaucinihilipilification <br>N: 1 | Longest substring: 15, cinihilipilific
String: sheepish <br>N: 3 | No such substring exists!
String: PERPETUATE <br>N: 2 | Longest substring: 7, PERPETU
String: 241214942198892104-21 -0239009432192 1924 891 <br>N: 3 | No such substring exists!

## Note
My provided solution does not have the ability to correctly flag nonexistent substrings - we completed it in the last 6 minutes of our time window.
