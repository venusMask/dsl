package org.venus.dsl.parse.node;

public final class NodeLocation
{
    private final int line;
    private final int charPositionInLine;

    public NodeLocation(int line, int charPositionInLine)
    {
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }

    public int getLineNumber()
    {
        return line;
    }

    public int getColumnNumber()
    {
        return charPositionInLine + 1;
    }
}