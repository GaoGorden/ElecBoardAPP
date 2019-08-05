package p.gordenyou.elecboardapp.RetrofitWebService.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body", strict = false)
public class AssetResponseBody {
    @Element(name = "GetAppDataResponse", required = false)
    public AssetResponseModel responseModel;
}
