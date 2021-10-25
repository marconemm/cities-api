package br.com.marconemm.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public final class ResponseSerializer<T> {

    private String msg;
    private HttpStatus status = HttpStatus.OK;
    private T data;

    public ResponseSerializer() {
        msg = null;
        data = null;
    }

    public ResponseEntity<Map<String, Object>> toJSON() {
        Map<String, Object> map = new HashMap<>();

        if (msg != null) {
            if (status != HttpStatus.OK && status != HttpStatus.ACCEPTED) {
                map.put("error", msg);
            } else {
                map.put("msg", msg);
            }
        }

        if (msg != null && msg.contains("meters")) {
            if (data != null) map.put("distance", data);
        } else {
            if (data != null) map.put("data", data);
        }

        return new ResponseEntity<>(map, status);
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
