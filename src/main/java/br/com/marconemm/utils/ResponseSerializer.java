package br.com.marconemm.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public final class ResponseSerializer<T> {

    private String msg;
    private HttpStatus status;
    private T data;

    public ResponseSerializer() {
        msg = null;
        status = null;
        data = null;
    }

    public ResponseEntity<Map<String, Object>> toJSON(){
        Map<String, Object> map = new HashMap<>();

        if (msg != null) map.put("message", msg);
        if (data != null) map.put("data", data);
        if (status != null) map.put("status", status.value());

        return new ResponseEntity<>(map,status);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
