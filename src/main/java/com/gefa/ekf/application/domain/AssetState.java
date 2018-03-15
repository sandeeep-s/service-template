package com.gefa.ekf.application.domain;

public abstract class AssetState {

    public enum StatusCode {
        CREATED, DELETED;
    }

    private StatusCode statusCode;


    public void moveToCreatedState() {
        throw new UnsupportedOperationException();
    }

    public void moveToDeletedState() {
        throw new UnsupportedOperationException();
    }
}
