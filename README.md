# Memory-Card-Game


In this game there are 2*N cards that are N pairs of numbers (0...N-1). 
The cards are placed face down in a random order on the table. The game will be played either 
between a human player and a computer player, or between two human players. 
In each round, the human player chooses the two cards to be turned over at the same time (i.e., he chooses the second card before turning over the first),
while the computer player follows the following strategy. The first position the computer player chooses at random, from the positions that have a card.
If the number in this position has been seen before in another position in the past, he chooses this position as his second choice. 
If not, it also selects the second position at random, from the positions containing a card. 
If the cards are the same the player collects the cards and wins a point. 
The cards are removed from the table. Otherwise, the cards are closed, and the next player continues. 
The game ends when all pairs have been found. The player who has the most points wins.

In order to run the program you should run **MemoryGame** Class with command line argument which is the number of pairs (java MemoryGame 5)
