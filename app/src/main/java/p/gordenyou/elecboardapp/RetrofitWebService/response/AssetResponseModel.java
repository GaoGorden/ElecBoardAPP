package p.gordenyou.elecboardapp.RetrofitWebService.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GetAppDataResponse")
public class AssetResponseModel {
    @Attribute(name = "xmlns", empty = "http://tempuri.org/", required = false)
    public String nameSpace;
    @Element(name = "GetAppDataResult")
    public String GetAppDataResult;
}
