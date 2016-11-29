package app.game.model;

import app.exception.GameModelException;

/**
 * Created by james on 11/28/16.
 */
public abstract class Token {

    private final String name;
    private final GameProperty type;
    private BoardSpace space;

    public Token(String name) throws GameModelException {
        space = null;
        this.name = name;
        type = GameProperty.getType(name);
    }

    public String getName() {
        return name;
    }

    public GameProperty getType() {
        return type;
    }

    public void setSpace(BoardSpace space) {
        this.space = space;
    }

    public BoardSpace getSpace() {
        return space;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Token) {
            Token other = (Token) obj;
            boolean sameName = name.equals(other.getName());
            // check same space
            boolean thisSpaceNull = space == null;
            boolean otherSpaceNull = other.getSpace() == null;
            boolean bothNull = thisSpaceNull && otherSpaceNull;
            boolean bothNotNull = !thisSpaceNull && ! otherSpaceNull;
            boolean sameSpace = bothNull || (bothNotNull && getSpace().equals(other.getSpace()));

            equal = sameName && sameSpace;
        }

        return equal;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(name);
        sb.append(" @ ");
        if (space == null) {
            sb.append("null");
        } else {
            sb.append(space.name);
        }
        return sb.toString();
    }

    public abstract char toChar();
}
