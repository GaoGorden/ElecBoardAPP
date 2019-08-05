package p.gordenyou.elecboardapp.RetrofitWebService.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "soap:Body", strict = false)
public class RequestBody {
    @Element(name = "GetAppData", required = false)
    public RequestModel GetAppData;

    public RequestBody(RequestModel assetMaterialInfo) {
        GetAppData = assetMaterialInfo;
    }
}
