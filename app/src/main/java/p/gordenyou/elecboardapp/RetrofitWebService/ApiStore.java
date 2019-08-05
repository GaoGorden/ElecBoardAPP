package p.gordenyou.elecboardapp.RetrofitWebService;

import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestEnvelope;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiStore {

    /*
     * 指定请求头:
     * "Content-Type: text/xml; charset=utf-8"指定文本格式,及编码格式
     * SOAPAction的值为
     * 分解为http://tempuri.org/ + AssetMaterialInfo,其实就是命名空间+接口名
     */
    @Headers({
            "Content-Type: text/xml; charset=utf-8",
            "SOAPAction: http://tempuri.org/GetAppData"
    })
    @POST("Service.asmx")
    Call<AssetResponseEnvelope> getAssetInfo(@Body RequestEnvelope requestEnvelope);

}
