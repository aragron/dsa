package dsa.vector;

import dsa.ExceptionBoundaryViolation;

public class Vector_Array implements Vector{

    private final int N = 1024;//数组的容量
    private int n = 0;//向量的实际规模
    private Object[] A;//对象数组

    public Vector_Array() {
        A = new Object[N];
        n = 0;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }

        return null;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        return null;
    }
}
