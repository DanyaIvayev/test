package test;

/**
 * Created by Дамир on 20.10.2016.
 */
public class JsonResponse {
    private String status = null;
    private Object result = null;

    public JsonResponse(String status, Object result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
}
