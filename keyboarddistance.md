# Keyboard Distance
## Regionals 2018

The goal of this program is to find the shortest distance one must move their fingers to type a certain string on a keyboard. The input will be in the form of an array of strings, where each string represents a row on the keyboard. The program should also take a target string which is being typed. The given keyboard is left-justified, will have no duplicate keys, and will use a ^ to represent the shift key and a space literal to represent the spacebar. The distance starts at the first letter typed and the path can only move in the direct horizontal or vertical.

## Testing
Input | Expected Output
------------ | -------------
Keyboard: {"abcd"} <br>Word: cad | 5
Keyboard: {"bet","dak","zuy"} <br>Word: eauykt | 5
Keyboard: {"abcde","^fghi","jklmn"} <br>Word: ghiAKd | 14
Keyboard: {"bet","dak","zuy"} <br>Word: eauykt | 5
Keyboard: {"qwertyuiop","asdfghjkl","^zxcvbnm "} <br>Word: The Quick Brown Fox Jumps Over the Lazy Dog | 277
Keyboard: {"a","b","c","d","e","f","g","h","i","^"," "} <br>Word: He abided | 36
Keyboard: {"aide^"} <br>Word: Aide | 7
