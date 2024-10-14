package model.types;

public class BoolType implements IType{
    public boolean equals(IType other) {
        return other instanceof BoolType;
    }

    @Override
    public String toString() {
        return "Boolean";
    }
}
