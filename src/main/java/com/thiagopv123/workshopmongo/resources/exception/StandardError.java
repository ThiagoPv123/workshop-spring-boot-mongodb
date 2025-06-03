package com.thiagopv123.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    public StandardError() {
        super();
    }
    public StandardError(final long timestamp, final Integer status, final String error, final String message, final String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    public long getTimestamp() {
        return timestamp;

    }
    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(final Integer status) {
        this.status = status;
    }
    public String getError() {
        return error;
    }
    public void setError(final String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(final String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(final String path) {
        this.path = path;
    }
}
