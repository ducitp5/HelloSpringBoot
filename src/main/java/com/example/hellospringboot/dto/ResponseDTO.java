package com.example.hellospringboot.dto;

public class ResponseDTO {
    private String status;
    private Object data;

    public ResponseDTO(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() { return status; }
    public Object getData() { return data; }
}
