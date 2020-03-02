# Game of Trobots

~~ *This project was implemented in May 2016* ~~

It is a game in which we observe robots fighting each other, each of them behaves according to the artificial intelligence assigned to him.


**Unit tests** are performed with *JUnit* and the code is commented in order to generate the **HTML documentation**.


When the game starts, enter:
- the size of the game grid (>=10)
- the number of robots that will fight (>=2)

And then the game runs by itself, you can at any time:
- pause the game, then resume it
- change the AI of a robot (it's better to do this after pausing the game) if there are several AIs.
- open the AI editor to add a new AI
- restart a game
- quit the game
While the robots are fighting, you can observe the energy consumption of each one, as well as the activation or not of its shield.

Initially, the robot has 100% energy, i.e. 100 energy points (ep). Shooting with a laser causes a loss of 75 ep. Launching a missile costs 50 ep. Activating the shield costs 25 ep. Skip your turn costs 25 ep. Rotating 90 degrees costs 5 ep. Moving (forward or backward) costs 10 ep.

The default AI that is assigned to the robots at the start of the game is described by a decision tree (*default_AI.jpg*) in which we can see the sequence of conditions and actions.
The AI editor is not completely finished, the actions to create one are available, but it does not create a new strategy yet and does not display graphically a decision tree yet.
It is also possible to make a conjunction, a disjunction, or a negation of conditions in an AI.


The game is expandable, because we can create new Action or Condition classes and they will be automatically detected by the game.
