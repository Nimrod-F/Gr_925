package model.types;

public class IntType implements IType{
    public boolean equals(IType other) {
        return other instanceof IntType;
    }

    @Override
    public String toString() {
        return "Int";
    }
}
