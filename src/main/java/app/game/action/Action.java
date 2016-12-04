package app.game.action;

import app.game.model.GameModel;

/**
 * Created by james on 11/26/16.
 */

/*
5.13 Action
The Clue-less game is advanced through the command pattern. The Action class is an
interface with several implementers: SetToken, StartGame, Move, MakeSuggestion,
DisproveSuggestion, MakeAccusation, and EndTurn. Actions are emitted by the
ClueLessGame object in response to client interaction and are emitted only if the client
is associated with an added player. All Actions have the same interface, and those
attributes and operations are defined here.
 */


public interface Action {
/*
Operation name: IsLegal(gameState: ClueLessModel): boolean
Input: The state of the game
Output: boolean
Description: Determines if the Action to be applied is legal or not.
*/
    boolean isLegal(GameModel model);

/*
Operation name: Apply(gameState: ClueLessModel)
Input: The state of the game
Output: void
Description: Performs the action in the game, thus changing the game state.
*/
    void apply(GameModel model); //Performs the action in the game, thus changing the game state
    String getMessage();
}
