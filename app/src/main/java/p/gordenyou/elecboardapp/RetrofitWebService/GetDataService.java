package p.gordenyou.elecboardapp.RetrofitWebService;

import android.content.Context;
import android.util.Log;

import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestBody;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestEnvelope;
import p.gordenyou.elecboardapp.RetrofitWebService.request.RequestModel;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseBody;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseEnvelope;
import p.gordenyou.elecboardapp.RetrofitWebService.response.AssetResponseModel;
import p.gordenyou.elecboardapp.commons.CommonMethod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class GetDataService {

    private Context context;
    private String TAG;
    private RequestModel requestMode;
    private String result = "";

    public GetDataService(Context context,String TAG, RequestModel requestMode){
        this.context = context;
        this.TAG = TAG;
        this.requestMode = requestMode;
    }

    public String GetData() {
        // 初始化Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.104/Huadian/")
                .addConverterFactory(SimpleXmlConverterFactory.create()) // 返回数据为xml,因此要加入xml解析
                .build();
        ApiStore apiStore = retrofit.create(ApiStore.class);
        // 初始化请求体
//        RequestModel requestModel = new RequestModel("GetCompanyInfo");
        RequestBody requestBody = new RequestBody(requestMode);
        RequestEnvelope requestEnvelope = new RequestEnvelope(requestBody);
        // 开始请求
        Call<AssetResponseEnvelope> call = apiStore.getAssetInfo(requestEnvelope);
        call.enqueue(new Callback<AssetResponseEnvelope>() {
            @Override
            public void onResponse(Call<AssetResponseEnvelope> call, Response<AssetResponseEnvelope> response) {
                // 处理响应体
                AssetResponseEnvelope responseEnvelope = response.body();
                if (responseEnvelope == null) {
                    Log.d(TAG, "onResponse: responseEnvelope == null");
                    CommonMethod.ShowErrMsgDialog(context, "网络请求有误，请联系管理员！");
                    result = "";
                    return;
                }
                AssetResponseBody responseBody = responseEnvelope.responseBody;
                if (responseBody == null) {
                    Log.d(TAG, "onResponse: responseBody == null");
                    CommonMethod.ShowErrMsgDialog(context, "网络请求有误，请联系管理员！");
                    result = "";
                    return;
                }
                AssetResponseModel responseModel = responseBody.responseModel;
                if (responseModel == null) {
                    Log.d(TAG, "onResponse: responseModel == null");
                    CommonMethod.ShowErrMsgDialog(context, "网络请求有误，请联系管理员！");
                    result = "";
                    return;
                }
                result = responseModel.GetAppDataResult;
                Log.d(TAG, "onResponse: result : " + result);
//                showResult(result);
            }

            @Override
            public void onFailure(Call<AssetResponseEnvelope> call, Throwable t) {
                CommonMethod.ShowErrMsgDialog(context, "请检查网络！");
                result = "";
            }
        });
        return result;
    }
}
