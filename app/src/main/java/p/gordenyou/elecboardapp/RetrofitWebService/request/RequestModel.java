package p.gordenyou.elecboardapp.RetrofitWebService.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name = "GetAppData", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class RequestModel {
    @Element(name = "subOperationFunction", required = false)
    public String subOperationFunction;
    @Element(name = "param1", required = false)
    public String param1;
    @Element(name = "param2", required = false)
    public String param2;
    @Element(name = "param3", required = false)
    public String param3;
    @Element(name = "param4", required = false)
    public String param4;
    @Element(name = "param5", required = false)
    public String param5;
    @Element(name = "param6", required = false)
    public String param6;
    @Element(name = "param7", required = false)
    public String param7;
    @Element(name = "param8", required = false)
    public String param8;
    @Element(name = "param9", required = false)
    public String param9;
    @Element(name = "param10", required = false)
    public String param10;
    @Element(name = "param11", required = false)
    public String param11;
    @Element(name = "param12", required = false)
    public String param12;
    @Element(name = "param13", required = false)
    public String param13;
    @Element(name = "param14", required = false)
    public String param14;
    @Element(name = "param15", required = false)
    public String param15;

    public RequestModel(String subOperationFunction) {
        this.subOperationFunction = subOperationFunction;
    }

    public RequestModel(String subOperationFunction, String param1) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
    }

    public RequestModel(String subOperationFunction, String param1, String param2) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
    }

    public RequestModel(String subOperationFunction, String param1, String param2,String param3) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public RequestModel(String subOperationFunction, String param1, String param2,String param3, String param4) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }

    public RequestModel(String subOperationFunction, String param1, String param2,String param3, String param4, String param5) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
    }

    public RequestModel(String subOperationFunction, String param1, String param2,String param3, String param4, String param5, String param6) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
        this.param6 = param6;
    }

    public RequestModel(String subOperationFunction, String param1, String param2,String param3, String param4, String param5, String param6, String param7) {
        this.subOperationFunction = subOperationFunction;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
        this.param6 = param6;
        this.param7 = param7;
    }
}
